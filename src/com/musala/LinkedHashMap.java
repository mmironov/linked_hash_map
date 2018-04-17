package com.musala;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

//TODO: Implement a LinkedHashMap that keeps the order of insertion of the elements
public class LinkedHashMap<K, V> implements Map<K, V> {
	private static final int SIZE = 11;

	private ArrayList<LinkedList<Pair<K,V>>> table;
	private int size;

	private LinkedList<Pair<K, V>> order;

	public LinkedHashMap() {
		table = new ArrayList<>(SIZE);
		order = new LinkedList<>();

		for(int i=0; i < SIZE; ++i) {
			final LinkedList<Pair<K, V>> emptyBucket = new LinkedList<>();
			table.add(emptyBucket);
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public List<K> keySet() {
		return null;
	}

	@Override
	public List<V> valueSet() {
		return null;
	}

	@Override
	public V get(K key) {
		final LinkedList<Pair<K, V>> bucket = table.get(hashIndex(key));

		for(Pair<K, V> pair : bucket) {

			if (pair.key.equals(key)) {
				return pair.value;
			}
		}

		return null;
	}

	@Override
	public boolean contains(K key) {
		final LinkedList<Pair<K, V>> bucket = table.get(hashIndex(key));

		for(Pair<K, V> pair : bucket) {

			if (pair.key.equals(key)) {
				return true;
			}
		}

		return false;
	}

	private int hashIndex(K key) {
		return Math.abs(key.hashCode()) % SIZE;
	}

	@Override
	public void insert(K key, V value) {

		final LinkedList<Pair<K, V>> bucket = table.get(hashIndex(key));

		for(Pair<K, V> pair : bucket) {

			if (pair.key.equals(key)) {
				pair.value = value;
				return;
			}
		}

		final Pair<K, V> newPair = new Pair<>();
		newPair.key = key;
		newPair.value = value;
		bucket.add(newPair);
		order.add(newPair);
		++size;
	}

	@Override
	public String toString() {
		return order.toString();
	}

	@Override
	public boolean remove(K key) {
		final LinkedList<Pair<K, V>> bucket = table.get(hashIndex(key));

		for(Pair<K, V> pair : bucket) {

			if (pair.key.equals(key)) {
				bucket.remove(pair);
				order.remove(pair);
				--size;
				return true;
			}
		}

		return false;
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
