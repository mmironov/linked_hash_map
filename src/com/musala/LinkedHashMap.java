package com.musala;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

//TODO: Implement a LinkedHashMap that keeps the order of insertion of the elements
public class LinkedHashMap<K, V> implements Map<K, V> {

	private static final int SIZE = 11;
	
	private ArrayList<LinkedList<Pair<K, V>>> table;
	private int size;

	private Pair<K, V> first;
	private Pair<K, V> last;

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
	public List<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<V> valueSet() {
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

		if (first == null && last == null) {
			first = pair;
		} else if (last != null) {
			last.next = pair;
		}

		pair.previous = last;
		last = pair;
	}

	//TODO: Implement this method. It should return true if something was removed from the map.
	@Override
	public boolean remove(K key) {

		int index = hashIndex(key);

		LinkedList<Pair<K, V>> values = table.get(index);

		if (values == null) {
			return false;
		}

		for(Pair<K, V> pair : values) {

			if (pair.key.equals(key)) {
				values.remove(pair);
				--size;
				removeFromOrderList(pair);
				return true;
			}
		}

		return false;
	}

	private void removeFromOrderList(Pair<K, V> pair) {

		if (pair == first && pair == last) {
			first = null;
			last = null;
			return;
		}

		if (pair == first) {
			first = first.next;
			return;
		}

		if (pair == last) {
			last = last.previous;
			return;
		}

		pair.previous.next = pair.next;
		pair.next.previous = pair.previous;
	}

	public void clear() {

		for(LinkedList<Pair<K, V>> values : table) {

			if (values != null) {
				values.clear();
			}
		}

		for(int i=0; i < table.size(); ++i) {
			table.set(i, null);
		}

		size = 0;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder("[");

		Pair<K, V> pair = first;

		while (pair.next != null) {
			builder.append(pair + ", ");
			pair = pair.next;
		}

		builder.append(pair + "]");

		return builder.toString();
	}
	
	public static class Pair<K, V> {
		public K key;
		public V value;

		Pair<K, V> next;
		Pair<K, V> previous;

		@Override
		public String toString() {
			return String.format("{%s: %s}", key.toString(), value.toString());
		}
	}
}
