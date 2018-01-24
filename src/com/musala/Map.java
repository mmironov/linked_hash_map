package com.musala;

import java.util.List;

public interface Map<K, V> {
	
	int size();
	
	List<K> keyset();
	List<V> valueset();
	
	V get(K key);
	boolean contains(K key);
	
	void insert(K key, V value);
}
