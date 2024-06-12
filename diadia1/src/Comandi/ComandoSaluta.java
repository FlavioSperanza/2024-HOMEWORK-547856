package Comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando {

	private IO io;
	@Override
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().getPersonaggio()!=null)
			io.mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().saluta());
		else 
			io.mostraMessaggio("Non c'e' nessuno in questa stanza");
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}

}
