package it.uniroma3.diadia;

import Comandi.Comando;
import Comandi.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	private Partita partita;
	private IO io;

	public DiaDia(IO console) {
		this.io= console;
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */

	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
				comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())

			io.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())

			io.mostraMessaggio("Hai esaurito i CFU...");

		return this.partita.isFinita();
	}
	
	public static void main(String[] argc) {
		IO console = new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}
}
/*private boolean processaIstruzione(String istruzione) {
Comando comandoDaEseguire = new Comando(istruzione);

if (comandoDaEseguire.getNome() == null) {
	io.mostraMessaggio("inserisci uno di questi comandi: ");
	this.aiuto();
	return false;
}

if (comandoDaEseguire.getNome().equals("fine")) {
	this.fine(); 
	return true;
} else if (comandoDaEseguire.getNome().equals("vai"))
	this.vai(comandoDaEseguire.getParametro());
else if (comandoDaEseguire.getNome().equals("aiuto"))
	this.aiuto();
else if (comandoDaEseguire.getNome().equals("prendi"))
	this.prendi(comandoDaEseguire.getParametro());
else if (comandoDaEseguire.getNome().equals("posa"))
	this.posa(comandoDaEseguire.getParametro());
else
	io.mostraMessaggio("Comando sconosciuto");
if (this.partita.vinta()) {
	io.mostraMessaggio("Hai vinto!");
	return true;
} else
	return false;
}   */

// implementazioni dei comandi dell'utente:

/**
* Stampa informazioni di aiuto.
*/
/*private void aiuto() {
for(int i=0; i< elencoComandi.length; i++) 
	io.mostraMessaggio(elencoComandi[i]+" ");
io.mostraMessaggio("");
}*/

/**
* Cerca di andare in una direzione. Se c'e' una stanza ci entra 
* e ne stampa il nome, altrimenti stampa un messaggio di errore
*/
/*private void vai(String direzione) {
if(direzione==null)
	io.mostraMessaggio("Dove vuoi andare ?");
Stanza prossimaStanza = null;
prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
if (prossimaStanza == null)
	io.mostraMessaggio("Direzione inesistente");
else {
	this.partita.setStanzaCorrente(prossimaStanza);
	int cfu = this.partita.getGiocatore().getCfu();
	this.partita.getGiocatore().setCfu(cfu--);
}
io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
}*/

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

/**
* Comando "Fine".
*/
/*private void fine() {
io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
}*/
