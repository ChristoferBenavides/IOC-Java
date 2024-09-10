package vista;

import controlador.ControladorPrincipal;
import javax.swing.table.AbstractTableModel;
import model.PuntInformacio;
import principal.Lloc;


/**
 *
 * @author fta
 */
public class PuntsInformacioTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Codi", "Nom Responsable", "Any Actual", "Quantitat Persones"};

    private String[][] data;

    public PuntsInformacioTableModel() {
        
        int i = 0;
        
        int totalPuntsInformacio = 0;

        for (int j = 0; j < ControladorPrincipal.getMercatActual().getLocals().size(); j++) {

            if (ControladorPrincipal.getMercatActual().getLocals().get(j) instanceof PuntInformacio) {
                totalPuntsInformacio++;
            }           
        }

        data = new String[totalPuntsInformacio][4];
        
        for (Lloc local : ControladorPrincipal.getMercatActual().getLocals()) {
            if (local instanceof PuntInformacio) {
                data[i][0] = ((PuntInformacio)local).getCodi();
                data[i][1] = ((PuntInformacio)local).getNomResponsable();
                data[i][2] = String.valueOf(((PuntInformacio)local).getAnyActual());
                data[i][3] = String.valueOf(((PuntInformacio)local).getQuantitatPersones());
                i++;
            }
        }
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return data[0].length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int column) {
        return data[row][column];
    }

}
