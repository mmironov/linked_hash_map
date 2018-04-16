package com.musala;

import java.util.List;

public interface Map<K, V> {
	
	int size();
	
	List<K> keySet();
	List<V> valueSet();
	
	V get(K key);
	boolean contains(K key);
	
	void insert(K key, V value);
	boolean remove(K key);
}
