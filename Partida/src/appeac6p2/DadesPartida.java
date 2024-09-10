/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appeac6p2;

import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class DadesPartida {
    int torn;
    int totalTorns;
    String[] nomsJugadors;
    int[] apostes;
    int[] tornsGuanyats;
    Random random;

    public void inicialitza(){
        torn = 0;
        totalTorns = 0;
        nomsJugadors= new String[] {"CPU", "?"};
        apostes = new int [] {0,0};
        tornsGuanyats=new int [] {0,0};
        random = new Random(System.currentTimeMillis());
    }
}

