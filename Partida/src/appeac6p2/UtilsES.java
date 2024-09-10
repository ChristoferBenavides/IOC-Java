/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appeac6p2;

/**
 *
 * @author chris
 */
import java.util.Scanner;

public class UtilsES {
    static final short POS_NOM = 0;
    static final short POS_PARTIDES_GUANYADES = 1;
    static final String MISSATGE_LINIA_MARC_ERROR = "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
    static final String MISSATGE_LINIA_SEPARACIO = "----------------------------------------------------------------------------";
    static final String MISSATGE_TITOL_PRINCIPAL = "                       PEDRA/PAPER/TISORA EL VIDEOJOC";
    static final String MISSATGE_ERROR_NO_NUMERO = "Error el que heu escrit no és un número. Torneu-ho a intentar";
    static final String MISSATGE_TITOL_MOSTRAR_DADES_JUGADOR = "               LA TEVA PUNTUACIÓ GLOBAL";
    static final String MISSATGE_ERROR_DADES_PLENES = "No s'ha pogut enregistrar el jugador. S'ha sobrepassat la capacitat màxima";
    static final String MISSATGE_DADES_JUGADOR = "PARTIDES GUANYADES     NOM JUGADOR";
    static final String MISSATGE_QUANTES_JUGADES = "Quantes jugades vols realitzar(3-5)?:";
    static final String MISSATGE_RANG_JUGADES = "El rang vàlid de jugades a escollir es troba entre 3 i 5 ambdós inclosos.\nTorneu-ho a intentar";
    static final String MISSATGE_DEMANAR_APOSTA = "Quina aposta fas (0:PEDRA, 1:PAPER, 2: TISORA)?";
    static final String MISSATGE_TRII_OPCIO = "Trieu una opció";
    static final String MISSATGE_COMIAT = "Fins la propera";
    static final String MISSATGE_TITOL_CONFIGURACIO = "PANTALLA DE CONFIGURACIÓ DEL JOC";
    static final String MISSATGE_TRII_OPCIO_NOM_JUGADOR = "Introduïu el nom del jugador: "; 
    static final String MISSATGE_ERROR_CADENA_BUIDA = "Error cal que escriviu un text. No és válid deixar el valor buit. Torneu-ho a intentar";
    static final String[] MENU_PRINCIPAL = { 
            "1. Jugar partida",
            "2. Llistar fitxers de Partides",
            "3. Mostrar Partides d'un Jugador",
            "0. Sortir"
        };
    static final String[] OPCIONS_APOSTES = { 
        "PEDRA",
        "PAPER",        
        "TISORA"
    };
    
    static int menuPrincipal(){
        int opcio;
        separarLinies(6);
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        System.out.println(MISSATGE_TITOL_PRINCIPAL);
        System.out.println(MISSATGE_LINIA_SEPARACIO);

        for(int i = 0; i < MENU_PRINCIPAL.length; ++i){
            System.out.println( MENU_PRINCIPAL[i] );
        }    
        
        opcio = UtilsES.demanarEnter(MISSATGE_TRII_OPCIO, MISSATGE_ERROR_NO_NUMERO);
        return opcio;
    }
    
    static void comiat(){
        System.out.println(MISSATGE_COMIAT);
    }
    
    static void mostrarResultatJugada(int torn, int totalTorns, String[] nomsJugadors, int[] apostes, int guanyador){
        System.out.println();
        System.out.println();
        System.out.println("==================================");
        System.out.println("Portem " + torn + " de " + totalTorns);
        System.out.println("==================================");        
        System.out.printf("%9s", nomsJugadors[0]);
        System.out.printf("%9s", nomsJugadors[1]);
        System.out.println();
        System.out.println("==================================");
        System.out.printf("%9s", OPCIONS_APOSTES[apostes[0]]);
        System.out.printf("%9s", OPCIONS_APOSTES[apostes[1]]);
        System.out.println();
        System.out.println("==================================");
        if(torn>0){
            if(guanyador==Partida.EMPAT){
                System.out.println("Heu empatat");
            }else{
                System.out.println("El guanyador és: " + nomsJugadors[guanyador]); 
            }
        }
    }    
 
    static String demanarNomJugador(){
        separarLinies(4);
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        System.out.println(MISSATGE_TITOL_CONFIGURACIO);        
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        
        String nom = demanarString(MISSATGE_TRII_OPCIO_NOM_JUGADOR, MISSATGE_ERROR_NO_NUMERO);
        return nom;
    }

    //Implementat a l'EAC5P1
    static int demanarQuantesJugades(){
        int numJugades = 0;
        while (numJugades < 3 || numJugades > 5){
            numJugades =demanarEnter(MISSATGE_QUANTES_JUGADES, MISSATGE_ERROR_NO_NUMERO);
            if(numJugades < 3 || numJugades > 5){
                System.out.println(MISSATGE_RANG_JUGADES);
            }
        }
        return numJugades;
    }    
    
    
    static int demanarAposta(){
        boolean correcte;
        int ap;
        do{
            System.out.println();
            ap = demanarEnter(MISSATGE_DEMANAR_APOSTA, MISSATGE_ERROR_NO_NUMERO);
            correcte = ap>=0 && ap<=2;
        }while(!correcte);
        
        return ap;
    }

    static void mostrarGuanyadorPartida(String[] nomsJugadors, int[] tornsGuanyats, int guanyador) {
        System.out.println();
        System.out.println();
        System.out.println("****************************************");
        System.out.println("******     FINAL DE LA PARTIDA    ******");
        System.out.println("****************************************");
        System.out.println();
        System.out.println("========================================");
        System.out.println("       PUNTUACIÓ FINAL");
        System.out.println("========================================");
        System.out.printf("%9s", nomsJugadors[0]);
        System.out.printf("%9s", nomsJugadors[1]);
        System.out.println();
        System.out.println("========================================");
        System.out.printf("%7d", tornsGuanyats[0]);
        System.out.printf("%9d", tornsGuanyats[1]);
        System.out.println();
        System.out.println("========================================");
        if(guanyador == Partida.EMPAT){
            System.out.println("Esteu empatats");
        }else{
            System.out.print("El guanyador de la partida és: ");
            System.out.println(nomsJugadors[guanyador]);
        }
    }
    
    //FUNCIONS GENÈRIQUES

    static void mostrarTitol(String titolPantalla){
        UtilsES.separarLinies(4);
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        System.out.println(MISSATGE_TITOL_PRINCIPAL);        
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        System.out.println(titolPantalla);        
        System.out.println(MISSATGE_LINIA_SEPARACIO);                
    }
    
    static void mostrarError(String missatge){
        System.out.println(MISSATGE_LINIA_MARC_ERROR);
        System.out.println(missatge);        
        System.out.println(MISSATGE_LINIA_MARC_ERROR);
    }
    
    //Funcions implementades a l'EAC4.
    
    /** 
     * Utilitzat pel programa principal per tal de capturar per teclat un numero
     * que sera retornat al codi que li ha realitzat la crida.
     * @param missatge Conte el text que es mostrara per sollicitar per 
     * pantalla la introduccio del numero.
     * @param missatgeError Conte el text que es mostrara a l'usuari en cas que 
     * introdueixi un numero buid o incorrecte
     * @return Valor enter que simbolitza el n�mero que s'ha introdu�t per teclat
     */
    static int demanarEnter(String missatge, String missatgeError){
        Scanner scanner = new Scanner(System.in);        
        int ret;
        boolean correcte;
        do{
            System.out.println(missatge);
            correcte=scanner.hasNextInt();
            if(!correcte){
                scanner.next();
                System.out.println(missatgeError);
            }
        }while(!correcte);
        ret = scanner.nextInt();  
        scanner.nextLine();        
        return ret;
    }

    /**
     * Demana per pantalla la introduccio d'un text que es retornat al codi que
     * en fa la crida.
     * @param missatge Conte el missatge que es mostrara a l'usuari abans de que
     * aquest introdueixi el text.
     * @param missatgeError Conte el missatge que es mostrara a l'usuari en cas 
     * que aquest introdueixi una String buida
     * @return El text introduit
     */
    static String demanarString(String missatge, String missatgeError){
        Scanner scanner = new Scanner(System.in);
        System.out.println(missatge);
        String textIntroduit = scanner.nextLine();

        while (textIntroduit.isEmpty()){
            System.out.println(missatgeError);
            System.out.println(missatge);
            textIntroduit = scanner.nextLine();
        }
        return textIntroduit;
    }
    
    static void separarLinies(int linies){
         for(int i=0; i<linies; ++i){
            System.out.println();
        }       
    }
    
    static void mostraDadesJugador(int posJugador, String[][] dadesJugadors){
        separarLinies(2);
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        System.out.println(MISSATGE_TITOL_MOSTRAR_DADES_JUGADOR);
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        System.out.println(MISSATGE_DADES_JUGADOR);
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        System.out.print("       " );
        System.out.print(dadesJugadors[posJugador][POS_PARTIDES_GUANYADES]);
        System.out.print("                ");
        System.out.println(dadesJugadors[posJugador][POS_NOM]);
    }
    public static void demanaReturn(String missatge) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(missatge);
        scanner.nextLine();
    }
    
}
