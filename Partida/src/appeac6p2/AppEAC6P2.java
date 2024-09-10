/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package appeac6p2;

/**
 *
 * @author chris
 */
public class AppEAC6P2 {
	
            static final String MISSATGE_LINIA_SEPARACIO = "------------------------------------------";
	    static final String MISSATGE_CONTINUAR = "\nPresiona [ENTRAR] per continuar";
	    static final String MISSATGE_INTRODUIR_OPCIO = "\nEsculliu una opci� i premeu [ENTRAR]";
	    static final String MISSATGE_LLISTAT_FITXERS = "--------------LLISTAT DE FITXERS----------";
	    static final String MISSATGE_LLISTAT_PARTIDES = "--------------LLISTAT DE PARTIDES-------";
	    static final String MISSATGE_LLISTAT_FITXERS_CAPSALERA = "          NOM                 MIDA (bytes)";
	    static final String MISSATGE_LLISTAT_PARTIDES_CAPSALERA = "PARTIDA        JUGADES         GUANYADOR";
	    static final String MISSATGE_LLISTAT_DIRECTORIS_CAPSALERA = "   OPCIO          DIRECTORI";
	    static final String MISSATGE_ERROR_LECTURA = "Error de lectura";
	    static final String MISSATGE_NOJUGADOR = "Històric de jugador innexistent";

	    private FileUtils futils;
	    
	    
    public static void main(String[] args) {
        AppEAC6P2 prg = new AppEAC6P2();
        prg.inici();
    }
    
    void inici(){
       futils=new FileUtils();
       futils.inicialitza();
       
       String [][] dadesJugadors = dadesJugadorsInici();
       dadesJugadors = futils.carregaJugadors(dadesJugadors);
       
        int opcio;

        do{
            opcio = UtilsES.menuPrincipal();
            switch (opcio){
                case 1:
                    opcioMenuJugarPartida(dadesJugadors);
                    break;
                case 2:
                	mostrarPartidesJugadors();
                    break;
                case 3:          	
                	mostrarLogPartides();
                	break;
                case 0:
                	futils.guardaJugadors(dadesJugadors);
                    UtilsES.comiat();
                    break;
            }
        }while(opcio != 0);
    }
    
    void opcioMenuJugarPartida(String[][] dadesJugadors){
        int numJugades;
        int posJug = -1;
        UtilsES.mostrarTitol(UtilsES.MISSATGE_TITOL_CONFIGURACIO);
        
        String nom = UtilsES.demanarString(UtilsES.MISSATGE_TRII_OPCIO_NOM_JUGADOR, UtilsES.MISSATGE_ERROR_CADENA_BUIDA);
        posJug = cercaPosJugador(nom, dadesJugadors);
        if(posJug<0){
            posJug = enregistrarNouJugador(nom, dadesJugadors);
        }
        if(posJug<0){
            UtilsES.mostrarError(UtilsES.MISSATGE_ERROR_DADES_PLENES);
        }else{
            numJugades = UtilsES.demanarQuantesJugades();
            jugarPartida(dadesJugadors, posJug, numJugades);
        }     
    }
    
    void mostrarLogPartides() {
    	String missatge;
    	UtilsES.mostrarTitol("GESTIÓ FITXERS PARTIDES - Partides jugades");
    	String nom = UtilsES.demanarString(UtilsES.MISSATGE_TRII_OPCIO_NOM_JUGADOR, UtilsES.MISSATGE_ERROR_CADENA_BUIDA);
    	int[][] historicPartides= futils.getHistoricJugador(nom);
    	
    	if (historicPartides.length>0) {
    		mostraPartidesJugador(historicPartides);
    		missatge=MISSATGE_CONTINUAR;
    	}
    	else {
    		missatge=MISSATGE_NOJUGADOR;
    	}
        
        UtilsES.demanaReturn(missatge);
    }
    
    void mostrarPartidesJugadors() {
    	UtilsES.mostrarTitol("GESTIÓ FITXERS PARTIDES - LLISTAR FITXERS");
        String[][] llistat = futils.getLlistaPartidesJugadors();

        mostraLListatFitxers(llistat);
        UtilsES.demanaReturn(MISSATGE_CONTINUAR);
    }
    
    void jugarPartida(String[][] dadesJugadors, int posJugador, int numJugades){
        int resultat;
        DadesPartida dadesPartida;
        Partida partida = new Partida();
        
        dadesPartida = partida.crearDadesPartida(dadesJugadors[posJugador][UtilsES.POS_NOM], numJugades);
        
        resultat = partida.jugar(dadesPartida);
        
        if(resultat==Partida.USUARI){
            incrementarPuntuacioJugador(dadesJugadors, posJugador);
        }
        UtilsES.mostraDadesJugador(posJugador, dadesJugadors);
        futils.guardarPartidaEnHistoric(dadesJugadors[posJugador][UtilsES.POS_NOM], numJugades, resultat);
    }
    
    void incrementarPuntuacioJugador(String [][] dadesJugadors, int posJugador){
        int punts = Integer.parseInt(dadesJugadors[posJugador][UtilsES.POS_PARTIDES_GUANYADES]);
        dadesJugadors[posJugador][UtilsES.POS_PARTIDES_GUANYADES] = String.valueOf(punts +1);
    }
    
    String[][] dadesJugadorsInici(){
        String [][] dadesJugadors = {
            {"", ""}, {"", ""}, {"", ""},{"", ""},  
            {"", ""}, {"", ""}, {"", ""},{"", ""}, 
            {"", ""}, {"", ""}, {"", ""},{"", ""},  
            {"", ""}, {"", ""}, {"", ""},{"", ""}, 
            {"", ""}, {"", ""}, {"", ""},{"", ""},  
            {"", ""}, {"", ""}, {"", ""},{"", ""}, 
            {"", ""}, {"", ""}, {"", ""},{"", ""},  
            {"", ""}, {"", ""}, {"", ""},{"", ""}, 
            {"", ""}, {"", ""}, {"", ""},{"", ""},  
            {"", ""}, {"", ""}, {"", ""},{"", ""}

        };
        return dadesJugadors;
    }

    //Implementat a l'EAC4

    int cercaPosJugador(String nom, String[][] dadesJugadors){
        boolean trobat = false;
        int pos = 0;

        while ( !trobat && pos < dadesJugadors.length ){
            trobat = dadesJugadors[pos][UtilsES.POS_NOM].trim().equalsIgnoreCase(nom.trim());
            pos++;
        }

        if ( trobat)
            return pos-1;
        else
            return -1;
    }
   
    
     int enregistrarNouJugador(String nom, String[][] dadesJugadors){
        int posBuida = 0;
        while (posBuida < dadesJugadors.length && !dadesJugadors[posBuida][UtilsES.POS_NOM].equals("")) {
            posBuida++;
        }
        if(posBuida<dadesJugadors.length){
            enregistrarDadesJugador(posBuida, nom, 0, dadesJugadors);
        }else{
            posBuida=-1;
        }
        return posBuida;
    }

    void enregistrarDadesJugador(int pos, String nom, int partidesGuanyades, String[][] dadesJugadors){
        dadesJugadors[pos][UtilsES.POS_NOM] = nom;
        dadesJugadors[pos][UtilsES.POS_PARTIDES_GUANYADES] = Integer.toString(partidesGuanyades);
    }
    
    public void mostraLListatFitxers(String[][] llistatFitxers) {
        System.out.println("\n\n" + MISSATGE_LINIA_SEPARACIO);
        System.out.println(MISSATGE_LLISTAT_FITXERS);
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        System.out.println("\n\n" + MISSATGE_LLISTAT_FITXERS_CAPSALERA + "\n");

        for (int i = 0; i < llistatFitxers.length; ++i) {
           
                String nomFixter = llistatFitxers[i][FileUtils.FITXER_NOM_POS];
                String midaFixter = llistatFitxers[i][FileUtils.FITXER_MIDA_POS];

                nomFixter = String.format("%1$" + 20 + "s", nomFixter);
                midaFixter = String.format("%1$" + 20 + "s", midaFixter);

                System.out.print(nomFixter);
                System.out.println(midaFixter);
           
        }
    }
    
    public void mostraPartidesJugador(int[][] partidesJugador) {
        System.out.println("\n\n" + MISSATGE_LINIA_SEPARACIO);
        System.out.println(MISSATGE_LLISTAT_PARTIDES);
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        System.out.println("\n\n" + MISSATGE_LLISTAT_PARTIDES_CAPSALERA + "\n");
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        for (int i = 0; i < partidesJugador.length; ++i) {
           
                int jugades = partidesJugador[i][0];
                int guanyador = partidesJugador[i][1];

                String id = String.format("%1$" + 5 + "s", i);
                String sJug = String.format("%1$" + 16 + "s", jugades);
                String sGua = String.format("%1$" + 18 + "s", quiGuanya(guanyador));

                System.out.print(id);
                System.out.print(sJug);
                System.out.println(sGua);
           
        }
    }
    private String quiGuanya(int guanyador) {
    	switch(guanyador){
    	case 0:return "CPU";
    	case 1:return "Jugador";
    	case 2:return "Empat";
    	default: return "";	
    		
    	}
    }
    
}
