package diadia1;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	
	Giocatore g = new Giocatore();
	Borsa b = new Borsa();

	@Test
	public void testGetCfu() {
		assertEquals(20, this.g.getCfu());
	}
	
	@Test
	public void testGetBorsa() {
		g.setBorsa(b);
		assertEquals(b, this.g.getBorsa());
	}
	
	@Test
	public void testGetBorsaVuota() {
		assertEquals(0, this.g.getBorsa().getNumeroAttrezzi());
	}

}
