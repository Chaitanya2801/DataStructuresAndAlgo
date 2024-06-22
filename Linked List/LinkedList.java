package lec29;

public class LinkedList {
	private class Node {
		int data;
		Node next;
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	//O(1)
	public void addFirst(int item) {
		Node newNode = new Node();
		newNode.data = item;
		if(size == 0) {
			head = newNode;
			tail = newNode;
			size++;
		} else {
			newNode.next = head;
			head = newNode;
			size++;
		}
	}
	
	//O(1)
	public void addLast(int item) {
		if(size == 0) {
			addFirst(item);
		} else {
			Node newNode = new Node();
			newNode.data = item;
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	
	//o(n)
	public void addAtIndex(int item, int k) throws Exception{
		if(k == 0) {
			addFirst(item);
		} else if(k == size) {
			addLast(item);
		} else {
			Node newNode = new Node();
			newNode.data = item;
			Node prev = getNode(k-1);
			newNode.next = prev.next;
			prev.next = newNode;
			size++;
		}
	}
	
	public void Display() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.println();
	}
	
	private Node getNode(int k) throws Exception{
		if(k<0 || k>=size) {
			throw new Exception("k galat hai");
		}
		Node temp = head;
		for (int i = 0; i < k; i++) {
			temp = temp.next;
		}
		return temp;
	}
	
	//O(1)
	public int getFirst() {
		return head.data;
	}
	
	//O(1)
	public int getLast() {
		return tail.data;
	}
	
	//O(n)
	public int getAtIndex(int k) throws Exception{
		return getNode(k).data;
	}
	
	//O(1)
	public int removeFirst() {
		Node temp = head;
		if(size == 1) {
			head = null;
			tail = null;
			size--;
		} else {
			head = head.next;
			temp.next = null;
			size--;
		}
		return temp.data;
	}
	
	//O(n)
	public int removeLast() throws Exception{
		Node temp = head;
		if(size == 1) {
			return removeFirst();
		} else {
			Node prev = getNode(size-2);
			int val = tail.data;
			tail = prev;
			tail.next = null;
			size--;
			return val;
		}
	}
	
	//O(n)
	public int removeAtIndex(int k) throws Exception{
		Node temp = head;
		if(k == 0) {
			return removeFirst();
		} else if(k == size-1) {
			return removeLast();
		} else {
			Node prev = getNode(k-1);
			Node curr = prev.next;
			int val = curr.data;
			prev.next = curr.next;
			curr.next = null;
			size--;
			return val;
		}
	}
}
