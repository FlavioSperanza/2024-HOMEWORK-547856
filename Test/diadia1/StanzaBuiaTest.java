package diadia1;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	StanzaBuia stanzaBuia = new StanzaBuia("stanza buia", "torcia");
	Attrezzo torcia = new Attrezzo("torcia", 4);

	@Test
	public void testGetDescrizioneConAttrezzoLuminoso() {
		stanzaBuia.addAttrezzo(torcia);
		assertEquals(stanzaBuia.toString(),stanzaBuia.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneSenzaAttrezzoLuminoso() {
		assertEquals("qui c'è buio pesto", stanzaBuia.getDescrizione());
	}

}
