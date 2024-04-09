package diadia1;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
	
	Borsa b = new Borsa();
	Attrezzo matita = new Attrezzo("matita", 2);
	Attrezzo macchina = new Attrezzo("macchina", 300);

	@Test
	public void testAddAttrezzoLeggero() {
		assertTrue(b.addAttrezzo(matita));
	}
	
	@Test
	public void testAddAttrezzoTroppoPesante() {
		assertFalse(b.addAttrezzo(macchina));
	}
	
	@Test
	public void testGetAttrezzoEsistente() {
		b.addAttrezzo(matita);
		assertEquals("matita (2kg)", b.getAttrezzo("matita").toString());
	}
	
	@Test
	public void testGetAttrezzoInesistente() {
		assertNull(b.getAttrezzo("matita"));
	}
	
	@Test
	public void testGetPesoBorsaVuota() {
		assertEquals(0, b.getPeso());
	}
	
	@Test
	public void testGetPesoConAttrezzo() {
		b.addAttrezzo(matita);
		assertEquals(2, b.getPeso());
	}
	
	@Test
	public void testHasAttrezzoEsistente() {
		b.addAttrezzo(matita);
		assertTrue(b.hasAttrezzo("matita"));
	}
	
	@Test
	public void testHasAttrezzoInesistente() {
		assertFalse(b.hasAttrezzo("matita"));
	}

}
