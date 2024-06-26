package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparatoreAttrezzi implements Comparator<Attrezzo> {
	
	public int compare(Attrezzo a, Attrezzo b) {
		if(a.getPeso()-b.getPeso()==0) {
			return a.getNome().compareTo(b.getNome());
		}
		return a.getPeso()-b.getPeso();
	}

}
