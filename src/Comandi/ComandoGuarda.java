package Comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
	private IO io;

	@Override
	public void esegui(Partita partita) {
		this.io = new IOConsole();
		io.mostraMessaggio("stanza corrente: "+partita.getStanzaCorrente().toString());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		io.mostraMessaggio("cfu rimanenti: "+partita.getGiocatore().getCfu());
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void setIo(IO io) {
		this.io=io;
		
	}

	@Override
	public String getNome() {
		return "guarda";
	}

	@Override
	public String getParametro() {
		return null;
	}


}
