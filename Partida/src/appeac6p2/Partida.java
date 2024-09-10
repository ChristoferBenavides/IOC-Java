/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appeac6p2;

/**
 *
 * @author josep
 */
public class Partida {
    public static final int EMPAT=2;
    public static final int MAQUINA=0;
    public static final int USUARI=1;
    public static final int PEDRA=0;
    public static final int PAPER=1;
    public static final int TISORA=2;

    int jugar(DadesPartida dadesPartida){
        int guanyador = EMPAT;

        //Jugar fins que s'acabi
        while(dadesPartida.torn<dadesPartida.totalTorns){
            guanyador = tirar(dadesPartida);
            UtilsES.mostrarResultatJugada(dadesPartida.torn, dadesPartida.totalTorns, dadesPartida.nomsJugadors, dadesPartida.apostes, guanyador);
        }
        guanyador = quiGuanyaLaPartida(dadesPartida);
        UtilsES.mostrarGuanyadorPartida(dadesPartida.nomsJugadors, dadesPartida.tornsGuanyats, guanyador);        
        return guanyador;
    }    
    
    int tirar(DadesPartida dadesPartida){
        int guanyador;
        dadesPartida.apostes[USUARI] = UtilsES.demanarAposta();
        dadesPartida.apostes[MAQUINA]  = dadesPartida.random.nextInt(3);
        guanyador = comprovarAposta(dadesPartida);
        dadesPartida.torn++;
        return guanyador;
    }
    
    int comprovarAposta(DadesPartida dadesPartida){
        int guanyador = quinaApostaGuanya(dadesPartida.apostes[MAQUINA],dadesPartida.apostes[USUARI]);
        if(guanyador<EMPAT){
            dadesPartida.tornsGuanyats[guanyador]++;
        }
        return guanyador;
    }
    
    //Implementat a l'EAC5P2
    DadesPartida crearDadesPartida(String nomJugador, int maximTorns){
        DadesPartida dadesPartida = new DadesPartida();
        dadesPartida.inicialitza();
        dadesPartida.totalTorns=maximTorns;
        dadesPartida.nomsJugadors[USUARI] = nomJugador;
        return dadesPartida;
    }
    
    int quiGuanyaLaPartida(DadesPartida dadesPartida){
        int resultat=EMPAT;
        if(dadesPartida.tornsGuanyats[0]<dadesPartida.tornsGuanyats[1]){
            resultat = 1;
        }else if(dadesPartida.tornsGuanyats[0]>dadesPartida.tornsGuanyats[1]){
            resultat = 0;            
        }    
        return resultat;
    }

    int quinaApostaGuanya(int apostaM, int apostaU){
        int resultat;
        if(apostaM == apostaU){
            resultat=EMPAT;
        }else if(apostaM==PEDRA && apostaU==PAPER){
            resultat=USUARI;
        }else if(apostaM==PAPER && apostaU==TISORA){
            resultat=USUARI;
        }else if(apostaM==TISORA && apostaU==PEDRA){
            resultat=USUARI;
        }else{
            resultat=MAQUINA;
        }
        return resultat;
    }    
}

