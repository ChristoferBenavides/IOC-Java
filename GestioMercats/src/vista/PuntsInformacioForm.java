package vista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author fta
 */
public class PuntsInformacioForm {
    
    private JFrame frame;
    
    private final int AMPLADA = 300;
    private final int ALCADA = 200;

    private JLabel lCodi;
    private JTextField tCodi;
    private JLabel lNomResponsable;
    private JTextField tNomResponsable;
    private JLabel lAnyActual;
    private JTextField tAnyActual;
    private JLabel lQuantitatPersones;
    private JTextField tQuantitatPersones;

    private JButton desar;   
    private JButton sortir;   

    public PuntsInformacioForm() {

        frame = new JFrame("Punt d'informació del mercat");
        frame.setLayout(new GridLayout(0, 1));

        //Creació dels controls del formulari
        lCodi = new JLabel("Codi");
        tCodi = new JTextField(10);
        lNomResponsable = new JLabel("Nom Responsable");
        tNomResponsable = new JTextField(20);
        lAnyActual = new JLabel("Any Actual");
        tAnyActual = new JTextField(20);
        lQuantitatPersones = new JLabel("Quantitat Persones");
        tQuantitatPersones = new JTextField(10);

        //Creació dels botons del formulari
        desar = new JButton("Desar");
        sortir = new JButton("Sortir");

        //Addició del tot el formulari a la finestra
        frame.add(lCodi);
        frame.add(tCodi);
        frame.add(lNomResponsable);
        frame.add(tNomResponsable);
        frame.add(lAnyActual);
        frame.add(tAnyActual);
        frame.add(lQuantitatPersones);
        frame.add(tQuantitatPersones);
        frame.add(desar);       
        frame.add(sortir);

        showFinestra();
    }
    
    public PuntsInformacioForm(String codi, String nomResponsable, int AnyActual, int QuantitatPersones){
        this();
        tCodi.setText(codi);
        tNomResponsable.setText(nomResponsable);
        tAnyActual.setText(String.valueOf(AnyActual));
        tQuantitatPersones.setText(String.valueOf(QuantitatPersones));
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

    public JLabel getlCodi() {
        return lCodi;
    }

    public void setlCodi(JLabel lCodi) {
        this.lCodi = lCodi;
    }

    public JTextField gettCodi() {
        return tCodi;
    }

    public void settCodi(JTextField tCodi) {
        this.tCodi = tCodi;
    }

    public JLabel getlNomResponsable() {
        return lNomResponsable;
    }

    public void setlNomResponsable(JLabel lNomResponsable) {
        this.lNomResponsable = lNomResponsable;
    }

    public JTextField gettNomResponsable() {
        return tNomResponsable;
    }

    public void settNomResponsable(JTextField tNomResponsable) {
        this.tNomResponsable = tNomResponsable;
    }

    public JLabel getlAnyActual() {
        return lAnyActual;
    }

    public void setlAnyActual(JLabel lAnyActual) {
        this.lAnyActual = lAnyActual;
    }

    public JTextField gettAnyActual() {
        return tAnyActual;
    }

    public void settAnyActual(JTextField tAnyActual) {
        this.tAnyActual = tAnyActual;
    }

    public JLabel getlQuantitatPersones() {
        return lQuantitatPersones;
    }

    public void setlQuantitatPersones(JLabel lQuantitatPersones) {
        this.lQuantitatPersones = lQuantitatPersones;
    }

    public JTextField gettQuantitatPersones() {
        return tQuantitatPersones;
    }

    public void settQuantitatPersones(JTextField tQuantitatPersones) {
        this.tQuantitatPersones = tQuantitatPersones;
    }

    public JButton getDesar() {
        return desar;
    }

    public void setDesar(JButton desar) {
        this.desar = desar;
    }

    public JButton getSortir() {
        return sortir;
    }

    public void setSortir(JButton sortir) {
        this.sortir = sortir;
    } 
    
}