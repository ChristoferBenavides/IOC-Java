package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import model.Mercat;
import java.sql.ResultSet;
import model.PuntInformacio;
import principal.GestorMercatsException;
import principal.Lloc;


/**
 *
 * @author fta
 */
public class GestorJDBC implements ProveedorPersistencia {

    private Mercat mercat;

    private Connection conn; //Connexió a la base de dades

    public Mercat getMercat() {
        return mercat;
    }

    public void setMercat(Mercat mercat) {
        this.mercat = mercat;
    }

    /*
     PreparedStatement necessaris
     */

 /*
     * TODO
     *
     * Obtenir un mercat
     * 
     * Sentència select de la taula mercats
     * Columnes: totes
     * Files: la del mercat el codi del qual coincideixi amb el passat per paràmetre
     *
     */
    
    private static String nomMercatSQL = "SELECT * FROM mercats WHERE codi = ?"; 
   
    private PreparedStatement nomMercatSt;
   
    
    
    
    

    /*
     * TODO
     *
     * Afegir un mercat
     * 
     * Sentència per afegir un mercat en la taula mercats
     * Els valors dels camps són els que es passaran per paràmetre
     *
     */
    private static String insereixMercatSQL = "INSERT INTO mercats VALUES(?,?,?)";

    private PreparedStatement insereixMercatSt;

    /*
     * TODO
     *
     * Actualitzar un mercat
     * 
     * Sentència per actualitzar un mercat de la taula mercats
     * Files a actualitzar: la que corresponguin al codi passat per paràmetre
     * Columnes a actualitzar: nom i adreca amb els altres valors passats per paràmetre
     *
     */
    private static String actualitzaMercatSQL = "UPDATE mercats SET nom= ?,adreca= ? WHERE codi = ? ";

    private PreparedStatement actualitzaMercatSt; 

    /*
     * TODO
     *
     * Eliminar punts d'informació (donat el codi d'un mercat)
     * 
     * Sentència que elimina els punts d'informació de la taula de punts d'informació relacionats amb un mercat
     * Files a eliminar: les que es corresponguin al codi del mercat passat per paràmetre
     *
     */
    private static String eliminaPuntInformacioSQL = "DELETE FROM puntsInformacio WHERE codi = ?";

    private PreparedStatement eliminaPuntInformacioSt;

    /*
     * TODO
     *
     * Afegir un punt d'informació
     * 
     * Sentència que afegix un punt d'informació a la taula de punts d'informació
     * Els valors dels camps són els que es passaran per paràmetre
     *
     */
    private static String insereixPuntInformacioSQL = "INSERT INTO puntsInformacio VALUES (?,?,?,?,?)";

    private PreparedStatement insereixPuntInformacioSt;
    

    /*
     * TODO
     *
     * Seleccionar els punts d'informació d'un mercat
     * 
     * Sentència que selecciona els punts d'informació de la taula de punts d'informació d'un mercat determinat
     * Columnes: totes
     * Files: totes les que els seu id del mercat coincideixi amb el codi passat per paràmetre
     *
     */
    private static String selPuntsInformacioSQL = "SELECT * FROM puntsInformacio WHERE IdMercat = ?";

    private PreparedStatement selPuntsInformacioSt;
    

    /*
     *TODO
     * 
     *Paràmetres: cap
     *
     *Acció:
     *  - Heu d'establir la connexio JDBC amb la base de dades EAC112223S1
     *  - Heu de crear els objectes PrepareStatement declarats com a atributs d'aquesta classe
     *    amb els respectius SQL declarats com a atributs just sobre cadascun d'ells.
     *  - Heu de fer el catch de les possibles excepcions (en aquest mètode no llançarem GestorMercatsException,
     *    simplement, mostreu el missatge a consola de l'excepció capturada)
     *
     *Retorn: cap
     *
     */
    public void estableixConnexio() throws SQLException {
        String urlBaseDades = "jdbc:derby://localhost:1527/EAC112223S1";
        String usuari = "root";
        String contrasenya = "root123";

        try {
            conn = DriverManager.getConnection(urlBaseDades, usuari, contrasenya);
            
            nomMercatSt = conn.prepareStatement(nomMercatSQL);
            insereixMercatSt = conn.prepareStatement(insereixMercatSQL);
            actualitzaMercatSt= conn.prepareStatement(actualitzaMercatSQL);
            
            eliminaPuntInformacioSt = conn.prepareStatement(eliminaPuntInformacioSQL);
            insereixPuntInformacioSt  = conn.prepareStatement(insereixPuntInformacioSQL);
            selPuntsInformacioSt = conn.prepareStatement(selPuntsInformacioSQL);
            
        } catch (SQLException e) {
            conn = null;
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void tancaConnexio() throws SQLException {
        try {
            conn.close();
        } finally {
            conn = null;
        }
    }

    /*
     *TODO
     * 
     *Paràmetres: el nom del fitxer i el mercat a desar
     *
     *Acció:
     *  - Heu de desar el mercat sobre la base de dades:
     *      - El mercat s'ha de desar a la taula mercats (nomFitxer passat per paràmetre és el codi del mercat)
     *      - Cada punt d'informació del mercat, s'ha de desar com a registre de la taula dels punts d'informació.
     *      - Heu de tenir en compte que si el mercat ja existeix, heu de fer el següent:
     *          - Actualitzar el registre mercat ja existent
     *          - Eliminar tots els punts d'informació d'aquest mercat de la taula mercats i després inserir els nous com si es tractes
     *            d'un nou mercat.
     *  - Si al fer qualsevol operació es produeix una excepció, llavors heu de llançar l'excepció GestorMercatsException amb codi "GestorJDBC.desar"
     *
     *Retorn: cap
     *
     */
    @Override
    public void desarMercat(String nomFitxer, Mercat mercat) throws GestorMercatsException {

        int numFitxer = Integer.valueOf(nomFitxer);
       
        try {
           estableixConnexio();
           nomMercatSt.setShort(1, (short) numFitxer);
           ResultSet res = nomMercatSt.executeQuery();
           if (res.next()) {
                actualitzaMercatSt.setString(1, mercat.getNom());
                actualitzaMercatSt.setString(2, mercat.getAdreca());
                actualitzaMercatSt.setShort(3, (short) numFitxer);
                actualitzaMercatSt.execute();
                actualitzaMercatSt.close();
                
                
                eliminaPuntInformacioSt.setInt(1,numFitxer);
                eliminaPuntInformacioSt.execute();
                eliminaPuntInformacioSt.close();
                
                if (mercat.getLocals().size() > 0) {
                    for( Lloc p : mercat.getLocals()){
                        if(p instanceof PuntInformacio){
                            PuntInformacio puntInformacio = (PuntInformacio) p;
                            insereixPuntInformacioSt.setString(1, puntInformacio.getCodi());
                            insereixPuntInformacioSt.setString(2, puntInformacio.getNomResponsable());
                            insereixPuntInformacioSt.setInt(3, puntInformacio.getAnyActual());
                            insereixPuntInformacioSt.setInt(4, puntInformacio.getQuantitatPersones());
                            insereixPuntInformacioSt.setInt(5, mercat.getCodi());
                            insereixPuntInformacioSt.execute();
                        }
                    }
                    insereixPuntInformacioSt.close();
                }    
            }else{
                    insereixMercatSt.setShort(1, (short)numFitxer);
                    insereixMercatSt.setString(2, mercat.getNom());
                    insereixMercatSt.setString(3, mercat.getAdreca());
                    insereixMercatSt.execute();
                    insereixMercatSt.close();
                    if (mercat.getLocals().size() > 0) {
                        for( Lloc p : mercat.getLocals()){
                            if(p instanceof PuntInformacio){
                                PuntInformacio puntInformacio = (PuntInformacio) p;
                                insereixPuntInformacioSt.setString(1, puntInformacio.getCodi());
                                insereixPuntInformacioSt.setString(2, puntInformacio.getNomResponsable());
                                insereixPuntInformacioSt.setInt(3, puntInformacio.getAnyActual());
                                insereixPuntInformacioSt.setInt(4, puntInformacio.getQuantitatPersones());
                                insereixPuntInformacioSt.setInt(5, mercat.getCodi());
                                insereixPuntInformacioSt.execute();
                            }
                        }
                        insereixPuntInformacioSt.close();
                    }                    
                }
                tancaConnexio();          
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new GestorMercatsException("GestorJDBC.desar");
        }                   
    }   
           

    /*
     *TODO
     * 
     *Paràmetres: el nom del fitxer del mercat
     *
     *Acció:
     *  - Heu de carregar el mercat des de la base de dades (nomFitxer passat per paràmetre és el codi del mercat)
     *  - Per fer això, heu de cercar el registre mercat de la taula amb codi = nomFitxer
     *  - A més, heu d'afegir els punts d'informació al mercat a partir de la taula de punts d'informació
     *  - Si al fer qualsevol operació es dona una excepció, llavors heu de llançar l'excepció GestorMercatsException 
     *    amb codi "GestorJDBC.carregar"
     *  - Si el nomFitxer donat no existeix a la taula de mercats (és a dir, el codi = nomFitxer no existeix), llavors
     *    heu de llançar l'excepció GestorMercatsException amb codi "GestorJDBC.noexist"
     *
     *Retorn: cap
     *
     */
    @Override
    public void carregarMercat(String nomFitxer) throws GestorMercatsException{
       int numFitxer = Integer.valueOf(nomFitxer);
       
        try{
            estableixConnexio();
            
            nomMercatSt.setShort(1, (short) numFitxer);
            ResultSet res = nomMercatSt.executeQuery();
            if(res.next()){
                int codi = res.getInt("codi");
                String nom = res.getString("nom");
                String adreca = res.getString("adreca");
                mercat = new Mercat (codi,nom,adreca);
                
                selPuntsInformacioSt.setInt(1, numFitxer);
                ResultSet resP =  selPuntsInformacioSt.executeQuery();
                while(resP.next()){
                    String codiP = resP.getString("codi");
                    String nomResponsable= resP.getString("nomResponsable");
                    int anyActual = resP.getInt("anyActual");
                    int quantitatPersones = resP.getInt("quantitatPersones");
                    PuntInformacio p = new PuntInformacio(codiP, nomResponsable, anyActual, quantitatPersones);
                    mercat.addPuntInformacio(p);
                }
            }else{
               throw new GestorMercatsException("GestorJDBC.noexist");   
            }
            tancaConnexio();                       
        }catch (SQLException e) {
            throw new GestorMercatsException("GestorJDBC.carregar");
            
        }
    }

}
