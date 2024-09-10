package vista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author root
 */
public final class PuntsInformacioLlista {
    
    private JFrame frame;
    
    private final int AMPLADA = 600;
    private final int ALCADA = 200;
    
    private JTable tPuntsInformacio;

    private JButton sortir;   
    

    public PuntsInformacioLlista() {
        frame = new JFrame("Llista de punts d'informació");
        frame.setLayout(new GridLayout(0, 1));

        tPuntsInformacio = new JTable(new PuntsInformacioTableModel());
        
        sortir = new JButton("Sortir");

        frame.add(new JScrollPane(tPuntsInformacio));  
        frame.add(sortir);

        showFinestra();
    }
    
    private void showFinestra(){
        //Es mostra la finestra amb propietats per defecte
        frame.setSize(AMPLADA, ALCADA);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTable gettPuntsInformacio() {
        return tPuntsInformacio;
    }

    public void settPuntsInformacio(JTable tPuntsInformacio) {
        this.tPuntsInformacio = tPuntsInformacio;
    }

    public JButton getSortir() {
        return sortir;
    }

    public void setSortir(JButton sortir) {
        this.sortir = sortir;
    }
}
