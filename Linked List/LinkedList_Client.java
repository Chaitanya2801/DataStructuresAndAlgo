package lec29;


public class LinkedList_Client {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		ll.addFirst(10);
		ll.addFirst(20);
		ll.addFirst(30);
		ll.Display();
		ll.addLast(40);
		ll.Display();
		ll.addAtIndex(50, 2);
		ll.Display();
		System.out.println((ll.getFirst()));
		System.out.println(ll.getLast());
		System.out.println(ll.getAtIndex(3));
		System.out.println(ll.removeFirst());
		System.out.println(ll.removeLast());
		System.out.println(ll.removeAtIndex(2));
		ll.Display();
	}
	
	

}
