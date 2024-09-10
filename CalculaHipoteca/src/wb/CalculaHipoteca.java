package wb;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;

public class CalculaHipoteca {

	protected Shell shlClcul;
	private Group grpDadesHabitatge;
	private Group grpDadesHipoteca;
	private Group grpAlertes;
	private Text txtPreuHabitatge;
	private Label lblPreuHabitatge;
	private Text textEstalvisAportats;
	private Label lblEstalvisAportats;
	private Label lblNewLabel;
	private Label label;
	private Combo combo_tipusResidencia;
	private Button btnAcceptar;
	private Label lblTipusResidencia;
	private Combo combo_descompte;
	private Label lblDescompte;
	private Text text_edatClient;
	private Text text_anysHipoteca;
	private Label lblEdatClient;
	private Label lblAnysHipoteca;
	private Text text_euriborActual;
	private Label lblEuriborActual;
	private Label label_1;
	private Label label_2;
	private Button btnCalcular;
	private Button btnRestablir;
	private Label lblPossiblesHipoteques;
	private Text text_fixaSenseBonificar;
	private Label lblFitxerSenseBonificar;
	private Label lblNewLabel_1;
	private Text text_fixaBonificada;
	private Label lblFixaBonificada;
	private Label lblNewLabel_2;
	private Text text_variableSenseBonificar;
	private Label lblVariableSenseModificar;
	private Label lblNewLabel_3;
	private Text text_VariableBonificada;
	private Label lblVariableBonificada;
	private Label lblNewLabel_4;
	private Text text_alerta;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CalculaHipoteca window = new CalculaHipoteca();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlClcul.open();
		shlClcul.layout();
		while (!shlClcul.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlClcul = new Shell();
		shlClcul.setModified(true);
		shlClcul.setSize(626, 874);
		shlClcul.setText("Càlcul Hipoteca Mensual per NomCognom");
		
		grpDadesHabitatge = new Group(shlClcul, SWT.NONE);
		grpDadesHabitatge.setText("Dades Habitatge");
		grpDadesHabitatge.setBounds(10, 10, 595, 217);
		
		txtPreuHabitatge = new Text(grpDadesHabitatge, SWT.BORDER);
		txtPreuHabitatge.setToolTipText("Introdueix preu sense impostos del pis/casa/... a adquirir.");
		txtPreuHabitatge.setForeground(SWTResourceManager.getColor(0, 0, 0));
		txtPreuHabitatge.setBounds(149, 41, 147, 26);
		
		lblPreuHabitatge = new Label(grpDadesHabitatge, SWT.NONE);
		lblPreuHabitatge.setText("Preu habitatge");
		lblPreuHabitatge.setBounds(12, 44, 110, 20);
		
		textEstalvisAportats = new Text(grpDadesHabitatge, SWT.BORDER);
		textEstalvisAportats.setToolTipText("Introdueix la quantitat que ja té estalviada el comprador");
		textEstalvisAportats.setBounds(149, 84, 147, 26);
		
		lblEstalvisAportats = new Label(grpDadesHabitatge, SWT.NONE);
		lblEstalvisAportats.setText("Estalvis aportats");
		lblEstalvisAportats.setBounds(12, 87, 110, 20);
		
		lblNewLabel = new Label(grpDadesHabitatge, SWT.NONE);
		lblNewLabel.setText("€");
		lblNewLabel.setBounds(308, 47, 70, 20);
		
		label = new Label(grpDadesHabitatge, SWT.NONE);
		label.setText("€");
		label.setBounds(308, 90, 70, 20);
		
		combo_tipusResidencia = new Combo(grpDadesHabitatge, SWT.NONE);
		combo_tipusResidencia.setToolTipText("Selecciona el tipus de residència");
		combo_tipusResidencia.setItems(new String[] {"habitatge habitual", "segona residència"});
		combo_tipusResidencia.setBounds(149, 129, 171, 28);
		
		btnAcceptar = new Button(grpDadesHabitatge, SWT.NONE);
		btnAcceptar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(validaDadesHabitatge()) {
					disableDadesHabitatge();
					enableDadesHipoteca();
				}
			}
		});
		btnAcceptar.setText("ACCEPTAR");
		btnAcceptar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		btnAcceptar.setBounds(450, 80, 96, 28);
		
		lblTipusResidencia = new Label(grpDadesHabitatge, SWT.NONE);
		lblTipusResidencia.setText("Tipus residència");
		lblTipusResidencia.setBounds(10, 132, 110, 20);
		
		grpDadesHipoteca = new Group(shlClcul, SWT.NONE);
		grpDadesHipoteca.setText("Dades Hipoteca");
		grpDadesHipoteca.setBounds(0, 235, 599, 463);
		
		combo_descompte = new Combo(grpDadesHipoteca, SWT.NONE);
		combo_descompte.setEnabled(false);
		combo_descompte.setToolTipText("Selecciona un descompte");
		combo_descompte.setItems(new String[] {"Funcionari", "Menors de 35 anys", "Col·lectius especials", "Cap: no es modifica l’interès", "ChristoferBenavides"});
		combo_descompte.setBounds(149, 31, 171, 28);
		
		lblDescompte = new Label(grpDadesHipoteca, SWT.NONE);
		lblDescompte.setText("Descompte");
		lblDescompte.setBounds(12, 34, 110, 20);
		
		text_edatClient = new Text(grpDadesHipoteca, SWT.BORDER);
		text_edatClient.setEnabled(false);
		text_edatClient.setToolTipText("Escriu la edat del client");
		text_edatClient.setBounds(149, 77, 85, 26);
		
		text_anysHipoteca = new Text(grpDadesHipoteca, SWT.BORDER);
		text_anysHipoteca.setEnabled(false);
		text_anysHipoteca.setToolTipText("Introdueix el anys de hipoteca");
		text_anysHipoteca.setBounds(149, 123, 85, 26);
		
		lblEdatClient = new Label(grpDadesHipoteca, SWT.NONE);
		lblEdatClient.setText("Edat client");
		lblEdatClient.setBounds(12, 80, 110, 20);
		
		lblAnysHipoteca = new Label(grpDadesHipoteca, SWT.NONE);
		lblAnysHipoteca.setText("Anys hipoteca");
		lblAnysHipoteca.setBounds(12, 126, 110, 20);
		
		text_euriborActual = new Text(grpDadesHipoteca, SWT.BORDER);
		text_euriborActual.setEnabled(false);
		text_euriborActual.setToolTipText("Introdueix el euribor actual");
		text_euriborActual.setBounds(149, 170, 85, 26);
		
		lblEuriborActual = new Label(grpDadesHipoteca, SWT.NONE);
		lblEuriborActual.setText("Euribor actual");
		lblEuriborActual.setBounds(10, 173, 92, 20);
		
		label_1 = new Label(grpDadesHipoteca, SWT.NONE);
		label_1.setText("%");
		label_1.setBounds(240, 176, 70, 20);
		
		label_2 = new Label(grpDadesHipoteca, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(0, 216, 699, 2);
		
		btnCalcular = new Button(grpDadesHipoteca, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (validaDadesHipoteca()) {
					diferentsHipoteques();
				}
			}
		});
		btnCalcular.setText("Calcular");
		btnCalcular.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnCalcular.setEnabled(false);
		btnCalcular.setBounds(423, 56, 159, 47);
		
		btnRestablir = new Button(grpDadesHipoteca, SWT.NONE);
		btnRestablir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				disableDadesHipoteca();
				enableDadesHabitatge();
			}
		});
		btnRestablir.setText("Restablir");
		btnRestablir.setEnabled(false);
		btnRestablir.setBounds(463, 121, 90, 30);
		
		lblPossiblesHipoteques = new Label(grpDadesHipoteca, SWT.NONE);
		lblPossiblesHipoteques.setText("Possibles Hipoteques");
		lblPossiblesHipoteques.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.ITALIC));
		lblPossiblesHipoteques.setAlignment(SWT.CENTER);
		lblPossiblesHipoteques.setBounds(177, 239, 231, 28);
		
		text_fixaSenseBonificar = new Text(grpDadesHipoteca, SWT.BORDER);
		text_fixaSenseBonificar.setEnabled(false);
		text_fixaSenseBonificar.setEditable(false);
		text_fixaSenseBonificar.setBounds(55, 335, 96, 26);
		
		lblFitxerSenseBonificar = new Label(grpDadesHipoteca, SWT.NONE);
		lblFitxerSenseBonificar.setText("Fixa sense bonificar");
		lblFitxerSenseBonificar.setBounds(55, 300, 138, 20);
		
		lblNewLabel_1 = new Label(grpDadesHipoteca, SWT.NONE);
		lblNewLabel_1.setText("€/mes");
		lblNewLabel_1.setBounds(164, 341, 70, 20);
		
		text_fixaBonificada = new Text(grpDadesHipoteca, SWT.BORDER);
		text_fixaBonificada.setEnabled(false);
		text_fixaBonificada.setEditable(false);
		text_fixaBonificada.setBounds(355, 335, 96, 26);
		
		lblFixaBonificada = new Label(grpDadesHipoteca, SWT.NONE);
		lblFixaBonificada.setText("Fixa bonificada");
		lblFixaBonificada.setBounds(355, 300, 110, 20);
		
		lblNewLabel_2 = new Label(grpDadesHipoteca, SWT.NONE);
		lblNewLabel_2.setText("€/mes");
		lblNewLabel_2.setBounds(463, 338, 70, 20);
		
		text_variableSenseBonificar = new Text(grpDadesHipoteca, SWT.BORDER);
		text_variableSenseBonificar.setEnabled(false);
		text_variableSenseBonificar.setEditable(false);
		text_variableSenseBonificar.setBounds(55, 404, 96, 26);
		
		lblVariableSenseModificar = new Label(grpDadesHipoteca, SWT.NONE);
		lblVariableSenseModificar.setText("Variable sense bonificar");
		lblVariableSenseModificar.setBounds(55, 378, 159, 20);
		
		lblNewLabel_3 = new Label(grpDadesHipoteca, SWT.NONE);
		lblNewLabel_3.setText("€/mes");
		lblNewLabel_3.setBounds(164, 407, 70, 20);
		
		text_VariableBonificada = new Text(grpDadesHipoteca, SWT.BORDER);
		text_VariableBonificada.setEnabled(false);
		text_VariableBonificada.setEditable(false);
		text_VariableBonificada.setBounds(355, 401, 96, 26);
		
		lblVariableBonificada = new Label(grpDadesHipoteca, SWT.NONE);
		lblVariableBonificada.setText("Variable bonificada");
		lblVariableBonificada.setBounds(355, 378, 138, 20);
		
		lblNewLabel_4 = new Label(grpDadesHipoteca, SWT.NONE);
		lblNewLabel_4.setText("€/mes");
		lblNewLabel_4.setBounds(463, 404, 70, 20);
		
		grpAlertes = new Group(shlClcul, SWT.NONE);
		grpAlertes.setBounds(10, 721, 595, 102);
		grpAlertes.setEnabled(false);
		grpAlertes.setText("Alertes");
		
		text_alerta = new Text(grpAlertes, SWT.BORDER);
		text_alerta.setEditable(false);
		text_alerta.setBounds(0, 42, 595, 33);

	}
	private boolean validaDadesHabitatge() {
		double estalviLimitAportat = 0.0;
		if(isNumeric(txtPreuHabitatge)) {
			estalviLimitAportat = Double.parseDouble(txtPreuHabitatge.getText()) * 20/100;
		}
		
		if(!isNumeric(txtPreuHabitatge)) {
			showAlerta("El valor del preu de habitatge introduït no es un número",txtPreuHabitatge);
		}else if (Double.parseDouble(txtPreuHabitatge.getText()) <= 0) {
			showAlerta("El valor del preu de habitatge introduït ha de ser positiu",txtPreuHabitatge);
		}else if (!isNumeric(textEstalvisAportats)) {			
			showAlerta("El valor dels estalvis aportats introduït no es un número",textEstalvisAportats);	
		}else if(estalviLimitAportat > Double.parseDouble(textEstalvisAportats.getText())) {
			showAlerta("El valor dels estalvis aportats han de superar el 20% del preu de habitatge",textEstalvisAportats);
		} else if(combo_tipusResidencia.getSelectionIndex() == -1) {
			showAlerta("Selecciona un tipus de residencia ",combo_tipusResidencia);
		}else {
			return true;
		}
		
		return false;
	}
	
	private void showAlerta(String alerta, Text text) {
		text.setFocus();
		text_alerta.setText("Error : " + alerta);
		text.selectAll();
	}
	
	private void showAlerta(String alerta, Combo combo) {
		combo.setFocus();
		text_alerta.setText("Error : " + alerta);
		
	}
	
	private boolean isNumeric(Text text) {
        try {
            Double.parseDouble(text.getText());
            return true;
        } catch (NumberFormatException excepcion) {
            return false;
        }
    }
	
	private void disableDadesHabitatge(){
		txtPreuHabitatge.setEnabled(false);
		textEstalvisAportats.setEnabled(false);
		combo_tipusResidencia.setEnabled(false);
		btnAcceptar.setEnabled(false);
		
	}
	
	private void enableDadesHipoteca() {
		combo_descompte.setEnabled(true);
		text_edatClient.setEnabled(true);
		text_anysHipoteca.setEnabled(true);
		text_euriborActual.setEnabled(true);
		btnCalcular.setEnabled(true);
		btnRestablir.setEnabled(true);
	}
	
	private boolean validaDadesHipoteca() {
		int sumaClientHipoteca = 0;
		if((isNumeric(text_edatClient)) && isNumeric(text_anysHipoteca)) {
			sumaClientHipoteca = Integer.parseInt(text_edatClient.getText()) + Integer.parseInt(text_anysHipoteca.getText());
		}
		
		int maxim = 30;
		if (combo_tipusResidencia.getItem(combo_tipusResidencia.getSelectionIndex()).equals("segona residència")) {
			maxim = 25;
		}
		
		if (combo_descompte.getSelectionIndex() == -1) {
			showAlerta("Selecciona un descompte",combo_descompte);
		}else if(!isNumeric(text_edatClient)){
			showAlerta("L'edat no es un número",text_edatClient);
		}else if (Integer.parseInt(text_edatClient.getText())<18) {
			showAlerta("L'edat ha de ser major que 18",text_edatClient);
		}else if (!isNumeric(text_anysHipoteca)) {
			showAlerta("Els anys de hipoteca no es un número",text_anysHipoteca);	
		}else if (maxim < Integer.parseInt(text_anysHipoteca.getText()) ) {
			showAlerta("Els anys de hipoteca superan el maxim estimat("+ maxim +")" ,text_anysHipoteca);
		}else if (sumaClientHipoteca >= 75) {
			showAlerta("La suma de els anys de hipoteca i la edat del client ha de ser menor a 75",text_edatClient);	
		}else if(!isNumeric(text_euriborActual)){
			showAlerta("El valor del euribor introduït no es un número",text_euriborActual);
		}else {
			return true;
		} 
		return false;
	}
	
	private double descompteHipoteca () {
		double descompte = 0;
		if(combo_descompte.getItem(combo_descompte.getSelectionIndex()).equals("Funcionari")) {
			descompte = -1;
		}else if(combo_descompte.getItem(combo_descompte.getSelectionIndex()).equals("Menors de 35 anys")) {
			descompte = -0.5;
		}else if(combo_descompte.getItem(combo_descompte.getSelectionIndex()).equals("Col·lectius especials")) {
			descompte = -0.75;
		}else if(combo_descompte.getItem(combo_descompte.getSelectionIndex()).equals("ChristoferBenavides")) {
			descompte = -1.75;	
		}else {
			descompte = 0;
		}
		return descompte;
	}
	
	private void diferentsHipoteques() {
		double interesFixaSenseBonificar = (2.95 + descompteHipoteca ())/100;
		text_fixaSenseBonificar.setText(calculaMensualitat(interesFixaSenseBonificar) + "");
		double interesFixaBonificada = (2.55 + descompteHipoteca ())/100;
		text_fixaBonificada.setText(calculaMensualitat(interesFixaBonificada) + " ");
		double interesVariableSenseBonificar = (1.24 + Double.parseDouble(text_euriborActual.getText()) + descompteHipoteca ())/100;
		text_variableSenseBonificar.setText(calculaMensualitat(interesVariableSenseBonificar) + " ");
		double interesVariableBonificada = (0.6 + Double.parseDouble(text_euriborActual.getText()) + descompteHipoteca ())/100;
		text_VariableBonificada.setText(calculaMensualitat(interesVariableBonificada) + " ");
		
	}
	
	private double calculaMensualitat(double interes) {
		double primeraDivisio = interes/12;
		double sumaUno = 1 + primeraDivisio;
		double multiplicar = -((Integer.parseInt(text_anysHipoteca.getText())*12));
		double exponent = Math.pow(sumaUno ,multiplicar);
		double resta = 1 - exponent;
		double a = resta/primeraDivisio;
		double restaMensualititat = Double.parseDouble(txtPreuHabitatge.getText()) - Double.parseDouble(textEstalvisAportats.getText());
		double mensualitat = restaMensualititat/a;
		
		return mensualitat;
	}
	private void disableDadesHipoteca() {
		combo_descompte.setEnabled(false);
		text_edatClient.setEnabled(false);
		text_anysHipoteca.setEnabled(false);
		text_euriborActual.setEnabled(false);
		btnCalcular.setEnabled(false);
		btnRestablir.setEnabled(false);
		combo_descompte.deselectAll();
		text_edatClient.setText("");
		text_anysHipoteca.setText("");
		text_fixaSenseBonificar.setText("");
		text_fixaBonificada.setText("");
		text_variableSenseBonificar.setText("");
		text_VariableBonificada.setText("");
		text_euriborActual.setText("");
		text_alerta.setText("");
		
	}
	private void enableDadesHabitatge(){
		txtPreuHabitatge.setEnabled(true);
		textEstalvisAportats.setEnabled(true);
		combo_tipusResidencia.setEnabled(true);
		txtPreuHabitatge.setText("");
		textEstalvisAportats.setText("");
		combo_tipusResidencia.deselectAll();
		btnAcceptar.setEnabled(true);
	}
}
