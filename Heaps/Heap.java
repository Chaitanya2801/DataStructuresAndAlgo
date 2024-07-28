package lec36;

import java.util.ArrayList;

public class Heap {
	ArrayList<Integer> ll = new ArrayList<>();
	
	public void add(int item) {
		ll.add(item);
		upheapify(ll.size() - 1);
	}
	
	private void upheapify(int ci) { //ci = child index
		int pi = (ci - 1)/2;
		if(ll.get(pi) > ll.get(ci)) {
			swap(pi, ci);
			upheapify(pi);
		}
	}
	
	private void swap(int pi, int ci) {
		int pth = ll.get(pi);
		int cth = ll.get(ci);
		
		ll.set(pi, cth);
		ll.set(ci, pth);
	}
	
	public int remove() {
		int rv = ll.get(0);
		swap(0, ll.size()-1);
		ll.remove(ll.size()-1);
		downheapify(0);
		return rv;
	}
	
	private void downheapify(int pi) {
		int lci = pi*2 + 2;
		int rci = pi*2 + 1;
		int mini = pi; // assuming pi is min
		if(lci < ll.size() && ll.get(lci) < ll.get(mini)) {
			mini = lci;
		}
		if(rci < ll.size() && ll.get(rci) < ll.get(mini)) {
			mini = rci;
		}
		if(mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}
		
	}
	
	public int get() {
		return ll.get(0);
	}
	
	public void display() {
		System.out.println(ll);
	}
}
