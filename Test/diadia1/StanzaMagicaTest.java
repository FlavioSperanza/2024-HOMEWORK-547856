package diadia1;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {
	StanzaMagica sm = new StanzaMagica("Stanza magica", 1);
	Attrezzo matita = new Attrezzo("matita", 2);
	Attrezzo gomma = new Attrezzo("gomma", 1);

	@Test
	public void testAddAttrezzoConNumeroAttrezziMinoriDellaSoglia() {
		sm.addAttrezzo(matita);
		assertEquals("matita (2kg)", sm.getAttrezzo("matita").toString());
	}
	@Test
	public void testAddAttrezzoConSogliaSuperata() {
		sm.addAttrezzo(matita);
		sm.addAttrezzo(gomma);
		assertEquals("ammog (2kg)", sm.getAttrezzo("ammog").toString());
	}

}
