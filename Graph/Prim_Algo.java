package lec44;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim_Algo {
	
	private HashMap<Integer, HashMap<Integer, Integer>> map;
	
	public Prim_Algo(int v) {
		map = new HashMap<>();
		for (int i = 1; i <= v; i++) {
			map.put(i, new HashMap<>());
		}
	}
	
	public void AddEdge(int v1, int v2, int cost) {
		map.get(v1).put(v2, cost);
		map.get(v2).put(v1, cost);
	}
	
	public void Prim_Algorithm() {
		HashSet<Integer> visited = new HashSet<>();
		PriorityQueue<PrimsPair> pq = new PriorityQueue<>(new Comparator<PrimsPair>() {

			@Override
			public int compare(PrimsPair o1, PrimsPair o2) {
				// TODO Auto-generated method stub
				return o1.cost - o2.cost;
			}
			
		});
		int sum = 0;
		pq.add(new PrimsPair(1,1,0));
		while(!pq.isEmpty()) {
			PrimsPair rp = pq.poll();
			if(visited.contains(rp.vtx)) {
				continue;
			}
			visited.add(rp.vtx);
			//System.out.println(rp);
			sum += rp.cost;
			for(int nbrs: map.get(rp.vtx).keySet()) {
				if(!visited.contains(nbrs)) {
					int cost = map.get(rp.vtx).get(nbrs);
					pq.add(new PrimsPair(nbrs, rp.vtx, cost));
				}
			}
		}
		System.out.println(sum);
	}
	
	class PrimsPair { 
		int vtx;
		int acqvtx;
		int cost;
		
		public PrimsPair(int vtx, int acq, int cost) {
			this.vtx = vtx;
			this.acqvtx = acq;
			this.cost = cost;
		}
		
		@Override
		public String toString() {
			return vtx + " " + acqvtx + " " + " @ " + cost;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		Prim_Algo p = new Prim_Algo(v);
		for (int i = 0; i < e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int cost = sc.nextInt();
			p.AddEdge(v1, v2, cost);
		}
		p.Prim_Algorithm();
	}
}
