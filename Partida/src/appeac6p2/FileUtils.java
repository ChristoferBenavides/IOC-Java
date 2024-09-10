/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appeac6p2;

/**
 *
 * @author David Amor�s
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtils {

    public static final int FITXER_NOM_POS = 0;
    public static final int FITXER_MIDA_POS = 1;
    public static final int NUM_JUGADORS = 40;
    public static final String directoriPartides = "Partides";
  

    public String directoriDades;
    
  
    private static final String DATA_FILE = "jugadors.txt";

    public void inicialitza() {
        // Per defecte es el directori de treball + /dades 
        directoriDades = System.getProperty("user.dir") + File.separator + "dades";
       
    }

 
    

    /**
     * Funci� per obtenir el llistat del contingut d'una ruta donada com a
     * par�metre
     *
     * 
     * 
	 * la mida. Un array buit si
     * alguna cosa no ha anat be
     */
    public String[][] getLlistaPartidesJugadors() {

        File file = new File(directoriDades + File.separator + directoriPartides);
        File[] llistatDirectori = file.listFiles();

        String[][] contingut = new String[llistatDirectori.length][3];

        // Loop a tot el contingut del directori
        for (int i = 0; i < llistatDirectori.length; i++) {
            long mida = llistatDirectori[i].length();

            contingut[i][FITXER_NOM_POS] = llistatDirectori[i].getName();
            contingut[i][FITXER_MIDA_POS] = Long.toString(mida);   
        }
        return contingut;
    }

   

   
   
 /**
     * Funci� que carrega les dades dels jugadors al l'arry dadesJugadors
     *
     * @param l'array de dadesJugadors a modificar
     * 
     */
    
    
    public String [][] carregaJugadors(String [][] dadesJugadors) {
       try {
            //S'intenta obrir el fitxer
            File f = new File(directoriDades + File.separator + DATA_FILE);
            
            Scanner lector = new Scanner(f);
            //Si s'executa aquesta instrucció, s'ha obert el fitxer
            int i = 0;
            while (lector.hasNextLine()) {
                String linia = lector.nextLine();
                String [] infoJugador = linia.split(",");
                dadesJugadors [i][UtilsES.POS_NOM] = infoJugador [UtilsES.POS_NOM];                   
                dadesJugadors [i][UtilsES.POS_PARTIDES_GUANYADES] = infoJugador [UtilsES.POS_PARTIDES_GUANYADES];
                System.out.print(dadesJugadors [i][UtilsES.POS_NOM] + ",");
                System.out.println(dadesJugadors [i][UtilsES.POS_PARTIDES_GUANYADES]);
                i++;
            }    
            //Cal tancar el fitxer
            lector.close();
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
       return dadesJugadors;
    } 
    
    
    /**
     * Funci� que guarda  les dades dels jugadors dins el fitxer de jugadors
     *
     * @param l'array de Jugadors a guardar
     * 
     */
    
    public void guardaJugadors(String [][] jugadors) {
        try {
            //S'intenta obrir el fitxer
            File f = new File(directoriDades + File.separator + DATA_FILE);
            PrintStream filePrintStream = new PrintStream(f);
            for (int i = 0; i < jugadors.length; i ++) {
                if (!jugadors [i][UtilsES.POS_NOM].isBlank()){
                    filePrintStream.append(jugadors [i][UtilsES.POS_NOM] + ",");
                    filePrintStream.append(jugadors [i][UtilsES.POS_PARTIDES_GUANYADES] + "\n");  
                }        
            }    
            //Cal tancar el fitxer
            filePrintStream.close();
            System.out.println("Fitxer escrit satisfactòriament.");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  
    
     /**
     * Funci� que retorna l'historic d partides d'un jugador
     *
     * @param el nom del jugador a recuperar
     * 
     */
    public int[][] getHistoricJugador(String nomJugador) {
        try {
            File f = new File(directoriDades + File.separator + directoriPartides + File.separator + nomJugador+".log");
            RandomAccessFile raf = new RandomAccessFile(f, "r");
            int [][] array = new int[25][2];
            int recorregut = Integer.BYTES + Integer.BYTES;
            int posicio = 0;
            int i = 0;
            while (posicio < raf.length()){
                raf.seek(posicio);
                array [i][0] = raf.readInt();
                array [i][1] = raf.readInt();
                posicio += recorregut;
                i++;    
            }
            return array;
        }catch (Exception e) {
            //Excepció!
            System.out.println("Error: " + e);
            return new int[25][2];
        }
        
    }

     /**
     * Funci� que guarda  la partida finalitzada per un jugador al leu log.
     *
     * @param nom del jugador, numero de jugades fetes i resultat
     * 
     */
    public void guardarPartidaEnHistoric(String nomJugador, int numJugades, int resultat) {
        try {
            File f = new File(directoriDades + File.separator + directoriPartides + File.separator + nomJugador+".log");
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            raf.seek(f.length());
            raf.writeInt(numJugades);
            raf.writeInt(resultat);
            long pos = raf.getFilePointer();
            raf.setLength(pos);    
        }catch (Exception e) {
            //Excepció!
            System.out.println("Error: " + e);
        }     				
    }                 
}

