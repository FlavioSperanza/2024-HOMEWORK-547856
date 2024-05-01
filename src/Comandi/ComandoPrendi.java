package Comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private String attrezzo;
	private IO io;

	@Override
	public void esegui(Partita partita) {
		this.io = new IOConsole();
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		int capacitaBorsa = partita.getGiocatore().getBorsa().getPesoMax()-partita.getGiocatore().getBorsa().getPeso();
		if(attrezzo==null) {io.mostraMessaggio("Inserisci il nome dell'attrezzo che vuoi prendere");}
		if(stanzaCorrente.getNumeroAttrezzi()==0) {this.io.mostraMessaggio("La stanza è vuota");}
		if(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo)) {this.io.mostraMessaggio("L'attrezzo "+attrezzo+" è già presente nella borsa");}
		for(Attrezzo attrezzoCercato : partita.getStanzaCorrente().getAttrezzi()) {
			if(attrezzoCercato!=null) {
				if(attrezzoCercato.getNome().equals(attrezzo)) {
					if(attrezzoCercato.getPeso()<capacitaBorsa) {
					partita.getGiocatore().getBorsa().addAttrezzo(attrezzoCercato);
					partita.getStanzaCorrente().removeAttrezzo(attrezzoCercato);
					if(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo)) {this.io.mostraMessaggio("L'attrezzo "+attrezzo+" è stato preso");}
					}
					else {io.mostraMessaggio("L'attrezzo che vuoi prendere è troppo pesante");}
				}
			}
		}
		if(attrezzo!=null && !partita.getStanzaCorrente().hasAttrezzo(attrezzo) && !partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo)) {
			this.io.mostraMessaggio("L'attrezzo "+attrezzo+" non è presente nella stanza corrente");
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
		return "prendi";
	}

	@Override
	public String getParametro() {
		return this.attrezzo;
	}


}
/*public void prendi(String nomeAttrezzo) {
	if(nomeAttrezzo==null) {System.out.println("Inserisci il nome dell'attrezzo che vuoi prendere");}
	if(this.partita.getStanzaCorrente().getNumeroAttrezzi() == 0) {
		io.mostraMessaggio("La stanza è vuota");
	}
	if(this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
		io.mostraMessaggio("L'attrezzo "+nomeAttrezzo+" è già presente nella borsa");
	}
	for(Attrezzo attrezzo : this.partita.getStanzaCorrente().getAttrezzi()) {
		if(attrezzo!=null) {
			if(attrezzo.getNome().equals(nomeAttrezzo)) {
				this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
				this.partita.getStanzaCorrente().removeAttrezzo(attrezzo);
				io.mostraMessaggio("L'attrezzo "+nomeAttrezzo+" è stato preso");
			}
		}
	}
	if(nomeAttrezzo!=null && !this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
		io.mostraMessaggio("L'attrezzo "+nomeAttrezzo+" non è presente nella stanza corrente");
	}
}*/