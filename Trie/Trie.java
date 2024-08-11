package lec39;

import java.util.HashMap;

public class Trie {
	class Node {
		char val;
		HashMap<Character, Node> child = new HashMap<>();
		boolean isterminal;
	}
	
	private Node root;
	
	public Trie() {
		Node n = new Node();
		n.val = '*';
		root = n;
	}
	
	public void insert(String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if(curr.child.containsKey(ch)) { // cheek if the key already exists
				curr = curr.child.get(ch);
			} else { // add new key when not present in trie
				Node n = new Node();
				n.val = ch;
				curr.child.put(ch, n);
				curr = n;
			}
		}
		curr.isterminal = true;
	}
	
	public boolean search(String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if(curr.child.containsKey(ch)) { // cheek if the key already exists
				curr = curr.child.get(ch);
			} else { //if letter does not exist
				return false;
			}
		}
		return curr.isterminal;
	}
	
	public boolean startsWith(String prefix) {
		Node curr = root;
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			if(curr.child.containsKey(ch)) { // cheek if the key already exists
				curr = curr.child.get(ch);
			} else { //if letter does not exist
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("Raj");
		t.insert("Rajesh");
		t.insert("Ankit");
		t.insert("Ankita");
	}
}
