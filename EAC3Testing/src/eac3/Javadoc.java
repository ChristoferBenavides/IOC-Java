package eac3;

public class Javadoc {
	public static double operacionsEsfera (double radi, String operacio){
		
		 double resultat=0;
	
		 if(radi <0) {
			 resultat = -1;
		 }else
		
		 if(operacio.equals("perimetre")){

			 resultat= 2 * Math.PI * radi; 
			 
		 }else
		 
		 if(operacio.equals("superficie")){

			 resultat= 4 * Math.PI * Math.pow(radi, 2); 
		 }		
		 else if (operacio.equals("volum")){
			 resultat= 4 / 3 * Math.PI * Math.pow(radi, 3); 
		 }
	
		 return resultat;
	}
}
