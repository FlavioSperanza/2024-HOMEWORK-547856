package diadia1;

import static org.junit.Assert.*;

import org.junit.Test;

import Comandi.Comando;
import Comandi.ComandoNonValido;
import Comandi.ComandoVai;
import Comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;

public class FabbricaDiComandiFisarmonicaTest {
	Labirinto labirinto = new Labirinto();
	FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica();
	Comando comando;
	Partita partita = new Partita(labirinto);


	@Test
	public void testComandoEsistente() {
		comando = new ComandoVai();
		comando.setParametro("nord");
		assertEquals(comando.getParametro(), fabbrica.costruisciComando("vai nord").getParametro());
	}
	
	@Test
	public void testComandoNonValido() {
		comando = new ComandoNonValido();
		assertEquals(comando.getNome(), fabbrica.costruisciComando("asdf").getNome());
	}
	
	@Test
	public void testComandoNullo() {
		comando = new ComandoNonValido();
		assertEquals(comando.getNome(), fabbrica.costruisciComando("").getNome());
	}

}
