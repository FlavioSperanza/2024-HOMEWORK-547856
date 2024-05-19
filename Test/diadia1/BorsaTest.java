package diadia1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezzi;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
	
	Borsa b = new Borsa();
	Attrezzo matita = new Attrezzo("matita", 2);
	Attrezzo macchina = new Attrezzo("macchina", 300);
	Attrezzo penna = new Attrezzo("penna", 2);
	Attrezzo zaino = new Attrezzo("zaino", 5);

	@Test
	public void testAddAttrezzoLeggero() {
		assertTrue(b.addAttrezzo(matita));
	}
	
	@Test
	public void testAddAttrezzoTroppoPesante() {
		assertFalse(b.addAttrezzo(macchina));
	}
	
	@Test
	public void testGetAttrezzoEsistente() {
		b.addAttrezzo(matita);
		assertEquals("matita (2kg)", b.getAttrezzo("matita").toString());
	}
	
	@Test
	public void testGetAttrezzoInesistente() {
		assertNull(b.getAttrezzo("matita"));
	}
	
	@Test
	public void testGetPesoBorsaVuota() {
		assertEquals(0, b.getPeso());
	}
	
	@Test
	public void testGetPesoConAttrezzo() {
		b.addAttrezzo(matita);
		assertEquals(2, b.getPeso());
	}
	
	@Test
	public void testHasAttrezzoEsistente() {
		b.addAttrezzo(matita);
		assertTrue(b.hasAttrezzo("matita"));
	}
	
	@Test
	public void testHasAttrezzoInesistente() {
		assertFalse(b.hasAttrezzo("matita"));
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoAttrezziStessoPeso() {
		b.addAttrezzo(penna);
		b.addAttrezzo(matita);
		Set<Attrezzo> expected = new TreeSet<>(new ComparatoreAttrezzi());
		expected.add(penna);
		expected.add(matita);
		assertArrayEquals(expected.toArray(), b.getSortedSetOrdinatoPerPeso().toArray());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoAttrezziDiversiPesoDiverso() {
		b.addAttrezzo(matita);
		b.addAttrezzo(zaino);
		Set<Attrezzo> e = new TreeSet<>(new ComparatoreAttrezzi());
		e.add(matita);
		e.add(zaino);
		assertArrayEquals(e.toArray(), b.getSortedSetOrdinatoPerPeso().toArray());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoStessoPeso() {
		b.addAttrezzo(matita);
		b.addAttrezzo(penna);
		List<Attrezzo> e = new ArrayList<>();
		e.add(matita);
		e.add(penna);
		assertTrue(this.controllaList(e, b.getContenutoOrdinatoPerPeso()));
	}
	
	
	public boolean controllaList(List<?> c1, List<?> c2) {
		if(c1.size()!=c2.size())
			return false;
		for(int i = 0; i<c1.size(); i++ ) {
			if(!c1.get(i).equals(c2.get(i)) )
				return false;
		}
		return true;
	}
	
	public boolean controllaSet(Set<Attrezzo> m1, Set<Attrezzo> m2) {
		if(m1.size()!=m2.size())
			return false;
		Iterator<Attrezzo> iter1 = m1.iterator();
		Iterator<Attrezzo> iter2 = m2.iterator();
		while(iter1.hasNext() && iter2.hasNext()) {
			if(!iter1.next().equals(iter2.next()))
				return false;
		}
		return true;
	}
	
	@Test
	public void testControllaSet() {
		Set<Attrezzo> e = new TreeSet<>(new ComparatoreAttrezzi());
		e.add(matita);
		e.add(penna);
		assertTrue(this.controllaSet(e, e));
	}
	
	@Test
	public void testgetContenutoOrdinatoPerNomeStessoPeso() {
		b.addAttrezzo(matita);
		b.addAttrezzo(penna);

		Set<Attrezzo> e = new TreeSet<>(new ComparatoreAttrezzi());
		e.add(matita);
		e.add(penna);
		assertTrue(this.controllaSet(e, b.getSortedSetOrdinatoPerPeso()));
	}
	
	@Test
	public void testgetContenutoOrdinatoPerNomePesoDiverso() {
		b.addAttrezzo(matita);
		b.addAttrezzo(zaino);

		Set<Attrezzo> e = new TreeSet<>(new ComparatoreAttrezzi());
		e.add(matita);
		e.add(zaino);
		
		assertTrue(this.controllaSet(e, b.getSortedSetOrdinatoPerPeso()));
	}

	public boolean controllaMap(Map<Integer, Set<Attrezzo>> m1, Map<Integer, Set<Attrezzo>> m2) {
		if(m1.size()!=m2.size())
			return false;
		
		Iterator<Integer> iter1 = m1.keySet().iterator();
		Iterator<Integer> iter2 = m2.keySet().iterator();
		while(iter1.hasNext() && iter2.hasNext()) {
			if(!this.controllaSet(m1.get(iter1.next()), m2.get(iter2.next()))) {
				return false;
			}
		}
		return true;
	}
	
	@Test
	public void testControllaMap() {
		Map<Integer, Set<Attrezzo>> e = new TreeMap<>();
		Set<Attrezzo> sing1 = new TreeSet<>(new ComparatoreAttrezzi());
		Set<Attrezzo> sing2 = new TreeSet<>(new ComparatoreAttrezzi());
		
		sing1.add(penna);
		sing2.add(zaino);
		
		e.put(2, sing1);
		e.put(3, sing2);
		assertTrue(this.controllaMap(e, e));
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoPesiDiversiSingleton() {
		b.addAttrezzo(penna);
		b.addAttrezzo(zaino);

		Map<Integer, Set<Attrezzo>> e = new TreeMap<>();
		Set<Attrezzo> sing1 = new TreeSet<>(new ComparatoreAttrezzi());
		Set<Attrezzo> sing2 = new TreeSet<>(new ComparatoreAttrezzi());
		
		sing1.add(penna);
		sing2.add(zaino);
		
		e.put(2, sing1);
		e.put(3, sing2);
		
		System.out.println(e);
		System.out.println(b.getContenutoRaggruppatoPerPeso());
		assertTrue(this.controllaMap(e, b.getContenutoRaggruppatoPerPeso()));
	}
	
}


