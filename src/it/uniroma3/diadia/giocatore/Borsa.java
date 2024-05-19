package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezzi;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
public class Borsa {


	private Map<String, Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	private int peso;

	// int size() di List restituisce il numero di elementi

	public Borsa() {
		this.pesoMax = 10;
		this.attrezzi = new TreeMap<>();
	}


	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new TreeMap<>();
		this.numeroAttrezzi = 0;
		this.peso =0;
	}


	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.peso + attrezzo.getPeso()<this.pesoMax) {
			this.attrezzi.put(attrezzo.getNome(), attrezzo);
			this.numeroAttrezzi++;
			this.peso += attrezzo.getPeso();
		return true;
		}
		else
			return false;
	}


	public int getPesoMax() {
		return pesoMax;
	}


	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		if(nomeAttrezzo!=null && this.attrezzi.containsKey(nomeAttrezzo)) {
			return this.attrezzi.get(nomeAttrezzo);
		}
		else
			return null;
	}


	public int getPeso() {
		return this.peso;
	}


	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}


	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}


	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		if(nomeAttrezzo!=null) {
			return this.attrezzi.remove(nomeAttrezzo);
		}
		else
			return null;
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> l = new ArrayList<>();
		l.addAll(this.attrezzi.values());
		Collections.sort(l, new ComparatoreAttrezzi());
		return l;
	}
	
	SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		return new TreeSet<Attrezzo>(this.attrezzi.values());
	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Map<Integer, Set<Attrezzo>> p = new TreeMap<>();
		for(Attrezzo a : this.attrezzi.values()) {
			if(p.containsKey(a.getPeso())) {
				p.get(a.getPeso()).add(a);
			}
			else {
				Set<Attrezzo> s = new HashSet<Attrezzo>();
				s.add(a);
				p.put(a.getPeso(), s);
			}
		}
		return p;
	}


	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): \n");
			s.append(this.getContenutoOrdinatoPerNome().toString() + "\n");
			s.append(this.getContenutoRaggruppatoPerPeso().toString()+"\n");
			s.append(this.getContenutoOrdinatoPerPeso().toString());
		}
		else
			s.append("La borsa è vuota");
		return s.toString();
	}

	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		SortedSet<Attrezzo> s = new TreeSet<Attrezzo>(new ComparatoreAttrezzi());
		s.addAll(this.attrezzi.values());
		return s;
	}

	

	public int getNumeroAttrezzi() {
		return numeroAttrezzi;
	}


	public Collection<Attrezzo> getAttrezzi() {
		return this.attrezzi.values();
	}



	public void setPeso(int peso) {
		this.peso = peso;
	}


	public void setNumeroAttrezzi(int numeroAttrezzi) {
		this.numeroAttrezzi = numeroAttrezzi;
	}


	public void setPesoMax(int pesoMax) {
		this.pesoMax = pesoMax;
	}




}