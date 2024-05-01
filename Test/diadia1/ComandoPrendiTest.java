package diadia1;

import static org.junit.Assert.*;

import org.junit.Test;

import Comandi.ComandoPrendi;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {
	Partita partita = new Partita();
	Attrezzo matita = new Attrezzo("matita",2);
	Attrezzo nave = new Attrezzo("nave",900);
	ComandoPrendi comando = new ComandoPrendi();
	IOConsole io = new IOConsole();
	
	public void setUp() {
		this.comando.setIo(io);
	}
	
	@Test
	public void testPrendiAttrezzoEsistente() {
		partita.getStanzaCorrente().addAttrezzo(matita);
		comando.setParametro("matita");
		comando.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("matita"));
	}
	
	@Test
	public void testPrendiAttrezzoInesistente() {
		comando.setParametro("asdf");
		comando.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("asdf"));
	}
	
	@Test
	public void testPrendiAttrezzoTroppoPesante() {
		partita.getStanzaCorrente().addAttrezzo(nave);
		comando.setParametro("nave");
		comando.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("nave"));
	}
}
