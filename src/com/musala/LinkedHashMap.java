package com.musala;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

//TODO: Implement a LinkedHashMap that keeps the order of insertion of the elements
public class LinkedHashMap<K, V> implements Map<K, V> {

	private static final int SIZE = 11;
	
	private ArrayList<LinkedList<Pair<K, V>>> table;
	private int size;
	
	public LinkedHashMap() {
		table = new ArrayList<>(SIZE);
		
		for(int i=0; i < SIZE; ++i) {
			table.add(null);
		}
		
		size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public List<K> keyset() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<V> valueset() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V get(K key) {
		if (contains(key)) {
			LinkedList<Pair<K,V>> values = table.get(hashIndex(key));
			
			for(Pair<K,V> pair : values) {
				if (pair.key.equals(key)) {
					return pair.value;
				}
			}
		}
		
		return null;
	}

	@Override
	public boolean contains(K key) {
		int index = hashIndex(key);
		
		if (table.get(index) == null || table.get(index).size() == 0) {
			return false;
		}
		
		return true;
	}

	private int hashIndex(K key) {
		int hash = key.hashCode();
		hash = (hash >= 0) ? hash : hash * (-1);
		int index = hash % SIZE;
		return index;
	}
	
	@Override
	public void insert(K key, V value) {
		
		int index = hashIndex(key);
		
		LinkedList<Pair<K, V>> values = table.get(index);
		
		if (values == null) {
			values = new LinkedList<>();
			table.set(index, values);
		}
		
		Pair<K, V> pair = new Pair<>();
		pair.key = key;
		pair.value = value;
		values.add(pair);
		
		++size;
	}

	//TODO: Implement this method. It should return true if something was removed from the map.
	public boolean remove(K key) {
		return false;
	}

	//TODO: This implementation should return the Map in a way that the elements are enumerated
	//TODO: in the same order as inserted.
	@Override
	public String toString() {
		return "";
	}
	
	public static class Pair<K, V> {
		public K key;
		public V value;
		
		@Override
		public String toString() {
			return String.format("{%s: %s}", key.toString(), value.toString());
		}
	}
}
