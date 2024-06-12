package Comandi;


import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {
	static final public String[] ELENCO_COMANDI = {"vai", "aiuto", "fine","prendi", "posa", "guarda","saluta","interagisci","regala"};

	private final static String NOME = "aiuto";

	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< ELENCO_COMANDI.length; i++) 
			this.getIo().mostraMessaggio(ELENCO_COMANDI[i]+" ");
		this.getIo().mostraMessaggio("");
	}

	@Override
	public String getNome() {
		return NOME;
	}


}
/*private void aiuto() {
for(int i=0; i< elencoComandi.length; i++) 
	io.mostraMessaggio(elencoComandi[i]+" ");
io.mostraMessaggio("");
}*/