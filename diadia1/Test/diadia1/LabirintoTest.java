package diadia1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {
	Labirinto l;
	Stanza biblioteca;
	Stanza DS1;

	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		l = Labirinto.newBuilder("labirinto2.txt").getLabirinto();

		biblioteca = new Stanza("Biblioteca");
		DS1 = new Stanza("DS1");

	}


	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", l.getStanzaVincente().getNome());
	}


	@Test
	public void testSetStanzaCorrente() {
		l.setStanzaCorrente(DS1);
		assertEquals(DS1, l.getStanzaCorrente());
	}
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", l.getStanzaCorrente().getNome());
	}

}
