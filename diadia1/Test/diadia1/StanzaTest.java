package diadia1;

import static org.junit.Assert.*;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	Stanza s1 = new Stanza("s1");
	Stanza nord = new Stanza("nord");
	Attrezzo matita = new Attrezzo("matita", 2);
	

	@Test
	public void testImpostaStanzaAdiacenteEsistente() {
		s1.impostaStanzaAdiacente(Direzione.nord, nord);
		assertEquals("errore su stanza adiacente esistente",nord, s1.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacenteSuStanzaNonEsistente() {
		assertNull(s1.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacenteConDirezioneInesistente() {
		assertNull(s1.getStanzaAdiacente("nordest"));
	}

	@Test
	public void testHasAttrezzoEsistente() {
		s1.addAttrezzo(matita);
		assertTrue(s1.hasAttrezzo("matita"));
	}
	
	@Test
	public void testHasAttrezzoInesistente() {
		assertFalse(s1.hasAttrezzo("penna"));
	}
	
	@Test
	public void testGetAttrezzoEsistente() {
		s1.addAttrezzo(matita);
		assertEquals(matita, s1.getAttrezzo("matita"));
	}
	
	@Test
	public void testGetAttrezzoInesistente() {
		assertNull(s1.getAttrezzo("penna"));
	}

}
