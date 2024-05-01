package diadia1;

import static org.junit.Assert.*;

import org.junit.Test;

import Comandi.ComandoPosa;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {
	Partita partita = new Partita();
	Attrezzo matita = new Attrezzo("matita",2);
	ComandoPosa comando = new ComandoPosa();
	IOConsole io = new IOConsole();
	
	public void setUp() {
		this.comando.setIo(io);
	}

	@Test
	public void testPosaAttrezzoEsistente() {
		partita.getGiocatore().getBorsa().addAttrezzo(matita);
		comando.setParametro("matita");
		comando.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("matita"));
	}
	
	@Test
	public void testPosaAttrezzoInesistente() {
		comando.setParametro("penna");
		comando.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("penna"));
	}

}
