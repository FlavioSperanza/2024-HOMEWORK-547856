package Comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	private IO io;

	@Override
	public void esegui(Partita partita) {
		this.io = new IOConsole();
		this.io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
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
		return "fine";
	}


	@Override
	public String getParametro() {
		return null;
	}


}