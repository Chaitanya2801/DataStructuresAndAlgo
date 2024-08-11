package lec39;

import java.util.HashMap;
import java.util.Scanner;

public class Trie_Contacts {
	class Node {
		char val;
		HashMap<Character, Node> child = new HashMap<>();
		boolean isterminal;
		int count = 1;
	}
	
	private Node root;
	
	public Trie_Contacts() {
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
				curr.count++;
			} else { // add new key when not present in trie
				Node n = new Node();
				n.val = ch;
				curr.child.put(ch, n);
				curr = n;
			}
		}
		curr.isterminal = true;
	}
	
	public int startsWith(String prefix) {
		Node curr = root;
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			if(curr.child.containsKey(ch)) { // cheek if the key already exists
				curr = curr.child.get(ch);
			} else { //if letter does not exist
				return 0;
			}
		}
		return curr.count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Trie_Contacts trie = new Trie_Contacts();
		while(t-- > 0) {
			String s = sc.next();
			String p = sc.next();
			if(s.equals("add")) {
				trie.insert(p);
			} else {
				System.out.println(trie.startsWith(p));
			}
		}
	}
}
