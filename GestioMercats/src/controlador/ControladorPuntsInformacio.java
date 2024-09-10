package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.PuntInformacio;
import vista.MenuPuntsInformacio;
import vista.PuntsInformacioForm;
import vista.PuntsInformacioLlista;

/**
 *
 * @author fta
 */
public class ControladorPuntsInformacio implements ActionListener {

    private MenuPuntsInformacio menuPuntsInformacio;
    private PuntsInformacioForm puntsInformacioForm = null;
    private PuntsInformacioLlista puntsInformacioLlista = null;
    private int opcioSelec = 0;

    public ControladorPuntsInformacio() {

        menuPuntsInformacio = new MenuPuntsInformacio();
        afegirListenersMenu();

    }

    private void afegirListenersMenu() {

        for (JButton boto : menuPuntsInformacio.getMenuButtons()) {
            boto.addActionListener(this);
        }

    }

    private void afegirListenersForm() {

        puntsInformacioForm.getDesar().addActionListener(this);
        puntsInformacioForm.getSortir().addActionListener(this);

    }

    private void afegirListenersLlista() {

        puntsInformacioLlista.getSortir().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Punts d'informació per al menú
        JButton[] botons = menuPuntsInformacio.getMenuButtons();

        for (int i = 0; i < botons.length; i++) {
            if (e.getSource() == botons[i]) {
                menuPuntsInformacio.getFrame().setVisible(false);
                opcioSelec = i;
                seleccionarOpcio(i);
            }
        }

        //Accions per al formulari de punts d'informació
        if (puntsInformacioForm != null) {

            if (e.getSource() == puntsInformacioForm.getDesar()) {

                if (opcioSelec == 1) {//Nou punt d'informació

                    ControladorPrincipal.getMercatActual().getLocals().add(new PuntInformacio(puntsInformacioForm.gettCodi().getText(), puntsInformacioForm.gettNomResponsable().getText(), Integer.parseInt(puntsInformacioForm.gettAnyActual().getText()), Integer.parseInt(puntsInformacioForm.gettQuantitatPersones().getText())));

                }

            } else if (e.getSource() == puntsInformacioForm.getSortir()) { //Sortir

                puntsInformacioForm.getFrame().setVisible(false);
                menuPuntsInformacio.getFrame().setVisible(true);

            }

        }

        if (puntsInformacioLlista != null) {

            if (e.getSource() == puntsInformacioLlista.getSortir()) {

                puntsInformacioLlista.getFrame().setVisible(false);
                menuPuntsInformacio.getFrame().setVisible(true);

            }

        }

    }

    private void seleccionarOpcio(Integer opcio) {

        switch (opcio) {
            case 0: //sortir
                ControladorPrincipal.getMenuPrincipal().getFrame().setVisible(true);
                break;
            case 1: // alta
                if (ControladorPrincipal.getMercats()[0] != null) {
                    puntsInformacioForm = new PuntsInformacioForm();
                    afegirListenersForm();
                } else {
                    menuPuntsInformacio.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuPuntsInformacio.getFrame(), "Abans s'ha de crear al menys un mercat en el menú de mercats.");
                }
                break;
            case 2: // llista
                if (ControladorPrincipal.getMercats()[0] != null) {
                    puntsInformacioLlista = new PuntsInformacioLlista();
                    afegirListenersLlista();
                } else {
                    menuPuntsInformacio.getFrame().setVisible(true);
                    JOptionPane.showMessageDialog(menuPuntsInformacio.getFrame(), "Abans s'ha de crear al menys un mercat en el menú de mercats.");
                }

                break;
        }

    }

}
