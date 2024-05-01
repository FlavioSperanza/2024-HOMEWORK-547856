package Comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private String attrezzo;
	private IO io;

	@Override
	public void esegui(Partita partita) {
		this.io = new IOConsole();
		if(attrezzo==null) {io.mostraMessaggio("Inserisci il nome dell'attrezzo che vuoi posare");}
		if(partita.getStanzaCorrente().hasAttrezzo(attrezzo)) {
			this.io.mostraMessaggio("L'attrezzo "+attrezzo+" è non è presente nella borsa");
		}
		for(Attrezzo attrezzoCercato : partita.getGiocatore().getBorsa().getAttrezzi()) {
			if(attrezzoCercato!=null) {
				if(attrezzoCercato.getNome().equals(attrezzo)) {
					partita.getStanzaCorrente().addAttrezzo(attrezzoCercato);
					partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
					this.io.mostraMessaggio("L'attrezzo "+attrezzo+" è stato posato");
				}
			}
		}
		if(attrezzo!=null && !partita.getStanzaCorrente().hasAttrezzo(attrezzo)) {
			this.io.mostraMessaggio("L'attrezzo "+attrezzo+" non è presente nella borsa");
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo=parametro;

	}
	
	@Override
	public void setIo(IO io) {
		this.io=io;
		
	}

	@Override
	public String getNome() {
		return "posa";
	}

	@Override
	public String getParametro() {
		return this.attrezzo;
	}


}
/*public void posa(String nomeAttrezzo) {
if(nomeAttrezzo==null) {System.out.println("Inserisci il nome dell'attrezzo che vuoi posare");}
if(this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
	io.mostraMessaggio("L'attrezzo "+nomeAttrezzo+" è non è presente nella borsa");
}
for(Attrezzo attrezzo : this.partita.getGiocatore().getBorsa().getAttrezzi()) {
	if(attrezzo!=null) {
		if(attrezzo.getNome().equals(nomeAttrezzo)) {
			this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
			this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			io.mostraMessaggio("L'attrezzo "+nomeAttrezzo+" è stato posato");
		}
	}
}
if(nomeAttrezzo!=null && !this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
	io.mostraMessaggio("L'attrezzo "+nomeAttrezzo+" non è presente nella borsa");
}
}*/