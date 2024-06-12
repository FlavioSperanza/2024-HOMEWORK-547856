package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	
	private Direzione direzioneBloccata;
	private String attrezzoChiave;

	public StanzaBloccata(String nome, Direzione direzione, String chiave) {
		super(nome);
		this.direzioneBloccata = direzione;
		this.attrezzoChiave = chiave;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(direzioneBloccata) && !this.hasAttrezzo(attrezzoChiave)) {
			return this;
		}
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		String direzione = "La stanza è bloccata nella direzione "+this.direzioneBloccata+", per sbloccarla prendi l'attrezzo "+this.attrezzoChiave+" e posalo nella stanza";
		if (!this.hasAttrezzo(attrezzoChiave)) {return direzione;}
		else {return this.toString();}
	}

}
/*public Stanza getStanzaAdiacente(String direzione) {
    Stanza stanza = null;
	for(int i=0; i<this.numeroStanzeAdiacenti; i++)
    	if (this.direzioni[i].equals(direzione))
    		stanza = this.stanzeAdiacenti[i];
    return stanza;
}*/