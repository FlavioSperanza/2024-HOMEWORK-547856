package diadia1;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	Labirinto labirinto = new Labirinto();
	Partita p = new Partita(labirinto);
	Stanza s1 = new Stanza("s1");
	
	@Test
	public void testGetStanzaCorrenteEsistente() {
		p.setStanzaCorrente(s1);
		assertEquals(s1, p.getStanzaCorrente());
		}
	
	@Test
	public void testGetStanzaCorrenteDefault() {
		assertEquals("Atrio", p.getStanzaCorrente().getNome());
	}

}
