package eac3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EAC3TestJunit {

	@Test
	void primerTestEAC3() {
		double resultat = EAC3.souAmbEstadis(7);
		assertEquals(-1, resultat);
	}
	@Test
	void SegonTestEAC3() {
		double resultat = EAC3.souAmbEstadis(10);
		assertEquals(1414, resultat);
	}
	

}
