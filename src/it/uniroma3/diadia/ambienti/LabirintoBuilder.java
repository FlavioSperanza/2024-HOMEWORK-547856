package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	private Labirinto labirinto;
	private Stanza ultimaStanzaInserita;
	private Map<String, Stanza> stanza;
	
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.stanza = new HashMap<String, Stanza>();
	}
	
	public Map<String, Stanza> getNomeStanza() {
		return this.stanza;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public void ultimaStanzaInserita(Stanza s) {
		this.ultimaStanzaInserita = s;
	}

	public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
		Stanza i = new Stanza(stanzaIniziale);
		this.labirinto.setStanzaCorrente(i);
		this.UltimaStanzaAggiuntaAggiornata(i);
		return this;
	}

	public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
		Stanza s = new Stanza(stanzaVincente);
		this.labirinto.setStanzaVincente(s);
		this.UltimaStanzaAggiuntaAggiornata(s);
		return this;
	}

	public LabirintoBuilder addStanza(String stanza) {
		Stanza s = new Stanza(stanza);
		this.UltimaStanzaAggiuntaAggiornata(s);
		return this;
	}	

	public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
		Attrezzo a = new Attrezzo(attrezzo, peso);
		if(this.ultimaStanzaInserita==null)
			return this;
		this.ultimaStanzaInserita.addAttrezzo(a);
		return this;
	}

	public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiecente, String direzione) {
		Stanza c = this.stanza.get(stanzaCorrente);
		Stanza a = this.stanza.get(stanzaAdiecente);
		c.impostaStanzaAdiacente(direzione, a);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nome) {
		Stanza stanza = new StanzaMagica(nome);
		this.UltimaStanzaAggiuntaAggiornata(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String nome, String attrezzoPerVedere) {
		Stanza stanza = new StanzaBuia(nome,attrezzoPerVedere);
		this.UltimaStanzaAggiuntaAggiornata(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String nome, String attrezzoSbloccante, String direzioneBloccata) {
		Stanza stanza = new StanzaBloccata(nome, attrezzoSbloccante, direzioneBloccata);
		this.UltimaStanzaAggiuntaAggiornata(stanza);
		return this;
	}
	
	public void UltimaStanzaAggiuntaAggiornata(Stanza stanza) {
		this.ultimaStanzaInserita = stanza;
		this.stanza.put(stanza.getNome(), stanza);
	}

}
