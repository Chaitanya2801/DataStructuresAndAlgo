package lec44;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Is_graph_BiPartite {
	public boolean isBiPartite(int[][] graph) {
		Queue<BipartitePair> q = new LinkedList<>();
		HashMap<Integer, Integer> visited = new HashMap<>();
		for (int src = 0; src < graph.length; src++) {
			if(visited.containsKey(src)) {
				continue;
			}
			q.add(new BipartitePair(src, 0));
			while(!q.isEmpty()) {
				//remove
				BipartitePair rv = q.poll();
				
				//Ignore if already visited
				if(visited.containsKey(rv.vtx)) {
					if(visited.get(rv.vtx) != rv.dis) {
						return false;
					}
					continue;
				}
				
				//mark visited
				visited.put(rv.vtx, rv.dis);
				
				//add unvisited nbrs
				for(int nbrs: graph[rv.vtx]) {
					if(!visited.containsKey(nbrs)) {
						q.add(new BipartitePair(nbrs, rv.dis +1))
					}
				}
			}
	}
	}
	
}

class BipartitePair {
	int vtx;
	int dis;
	
	public BipartitePair(int v, int d) {
		this.vtx = v;
		this.dis = d;
	}
}
