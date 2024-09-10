package eac3;

/**

* Calcula el sou dels treballadors.
* @author IOC
* @version 2022
*/

public class EAC3 {
	/**
	* Rep una antiguitat i retorna el resultat d’aplicar-li diferents augments de sou.
	* @param antiguitat són els anys treballats.
	* @return sou és la quantitat que rep un treballador depenent de la seva antiguitat.
	*/
	public static double souAmbEstadis (int antiguitat){
		double souBase=1400;
		double sou=souBase+souBase*1/100; //Extreure una variable local : sou s'estava repetint a cada if, doncs l'he tret.
		
		if (antiguitat<9) {
			return -1;
		}		
		if (antiguitat >=9 && antiguitat <=14) {
			//El sou es el mateix.
		}
		if (antiguitat >=15 && antiguitat <=20) {
			sou=calculaSou(2,sou); // En cas que l'augment sigui diferent, només cal canviar el primer paràmetre.
		}
		if (antiguitat >=21 && antiguitat <=26) {
			sou=calculaSou(5,sou);
		}
		else if (antiguitat>26){	
			sou=calculaSou(8,sou);
		}
		return sou;
	}
	/**
	* El mètode rep una antiguitat i retorna el resultat d’aplicar-li diferents augments de sou.
	* @param augment es el porcentatge que s'afegeix de sou.
	* @param sou és el sou actual sense augments.
	* @return SouAmbAugment és el sou amb el augment depenent de la antiguitat
	*/
	private static double calculaSou( double augment, double sou){ // Extreure un mètode: He creat un metode pel càlcul del sou.
		double SouAmbAugment = sou+sou*augment/100;
		return SouAmbAugment;
	}

}
