package Comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {
	private String direzione;

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(direzione==null) {
			this.getIo().mostraMessaggio("Dove vuoi andare?\nDevi specificare una direzione");
			this.getIo().mostraMessaggio(stanzaCorrente.toString());
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza==null) {
			this.getIo().mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		this.getIo().mostraMessaggio(partita.getStanzaCorrente().toString());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}

	@Override
	public String getNome() {
		return "vai";
	}


}