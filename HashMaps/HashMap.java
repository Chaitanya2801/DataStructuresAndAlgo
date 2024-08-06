package practise;
/*
 * Creating Generic HashMap using ArrayList and LinkedList.
 * It contains put(), containsKey(), get(), remove() functions
 */

import java.util.ArrayList;

public class HashMap<K, V> {
	class Node {
		K key;
		V value;
		Node next;
	}
	
	private int size;
	ArrayList<Node> bucket;
	
	public HashMap() {
		this(4);
	}
	
	//initializing HashMap bucket and assigning initial address as null
	public HashMap(int n) {
		bucket = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			bucket.add(null);
		}
	}
	
	public void put(K key, V value) {
		int idx = hashFun(key);
		Node temp = bucket.get(idx);
		
		// if the key already exists then we just update the value and return
		while(temp != null) {
			if(temp.key.equals(key)) {
				temp.value = value;
				return;
			}
			temp = temp.next;
		}
		
		//creating the key value pair
		temp = bucket.get(idx);
		Node node = new Node();
		node.key = key;
		node.value = value;
		node.next = temp;
		bucket.set(idx, node); // setting the node address in the index
		size++;
		
		double threshold = 2.0; // setting threshold value which is the limit of the bucket hashmap
		double loadFactor = (1.0*size)*bucket.size();
		if(loadFactor > threshold) { // if the threshold is crossed then increase the bucket capacity
			rehashing(); // increasing the bucket capacity by multiple of 2
		}
	}
	
	public boolean containsKey(K key) {
		int idx = hashFun(key);
		Node temp = bucket.get(idx);
		while(temp != null) {
			if(temp.key.equals(key)) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	public V get(K key) {
		int idx = hashFun(key);
		Node temp = bucket.get(idx);
		while(temp != null) {
			if(temp.key.equals(key)) {
				return temp.value;
			}
			temp = temp.next;
		}
		return null;
	}
	
	// removing key value pair in hashMap
	public V remove(K key) {
		int idx = hashFun(key);
		Node curr = bucket.get(idx);
		Node prev = null;
		while(curr != null) {
			if(curr.key.equals(key)) {
				break;
			}
			prev = curr;
			curr = curr.next;
		}
		
		if(curr == null) {
			return null;
		} else if(prev == null) {
			bucket.set(idx, curr.next);
			size--;
		} else {
			prev.next = curr.next;
			size--;
		}
		
		return curr.value;
	}
	
	@Override
	public String toString() {
		String s = "{";
		for(Node temp: bucket) {
			while(temp != null) {
				s = s + temp.key + "=" + temp.value + ", ";
				temp=temp.next;
			}
		}
		
		return s + "}";
	}
	
	// increasing hashmap capacity and redistributing the pair with different linked list chains
	public void rehashing() {
		ArrayList<Node> newBucket = new ArrayList<>();
		for (int i = 0; i < 2 * bucket.size(); i++) { // it is due to 
			newBucket.add(null);
		}
		ArrayList<Node> oba = bucket;
		newBucket = bucket;
		for (Node node : oba) {
			while(node != null) {
				put(node.key, node.value);
				node = node.next;
			}
		}
	}
	
	public int hashFun(K key) {
		int idx = key.hashCode()%bucket.size();
		if(idx < 0) {
			idx += bucket.size();
		}
		return idx;
	}
	

}
