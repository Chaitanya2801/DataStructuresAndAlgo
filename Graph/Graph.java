package lec43;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*
 * Implementing undirected weighted graph using HashMap.
 */

public class Graph {
	
	private HashMap<Integer, HashMap<Integer, Integer>> map;
	
	public Graph(int v) {
		map = new HashMap<>();
		for (int i = 1; i <=v ; i++) {
			map.put(i, new HashMap<>());
		}
	}
	
	public void AddEdge(int v1, int v2, int cost) {
		map.get(v1).put(v2, cost);
		map.get(v2).put(v1, cost);
	}
	
	//check whether the edge is present between v1 and v2
	public boolean ContainsEdge(int v1, int v2) {
		return map.get(v1).containsKey(v2);
	}
	
	// check whether vertex v1 exists
	public boolean containsVertex(int v1) {
		return map.containsKey(v1);
	}
	
	//total no. of edges
	public int noOfEdge() {
		int count = 0;
		for(int key: map.keySet()) {
			count += map.get(key).size();
		}
		return count / 2;
	}
	
	public void removeEdge(int v1, int v2) {
		map.get(v1).remove(v2);
		map.get(v2).remove(v1);
	}
	
	// remove the vertex by removing the edges of the neighbor then removing the vertex
	public void removeVertex(int v1) {
		for(int v2: map.get(v1).keySet()) {
			map.get(v2).remove(v1);
		}
		map.remove(v1);
	}
	
	public void Display() {
		for(int key: map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}
	}
	
	//check whether path exists between two vertex
	public boolean hasPath(int src, int des, HashSet<Integer> visited) {
		if(src == des) {
			return true;
		}
		visited.add(src);
		for (int nbrs: map.get(src).keySet()) {
			if(!visited.contains(nbrs)) {
				boolean ans = hasPath(nbrs, des, visited);
				if(ans) {
					return ans;
				}
			}
			
		}
		visited.remove(src);
		return false;
	}
	
	public void printAllPath(int src, int des, HashSet<Integer> visited, String s) {
		if(src == des) {
			System.out.println(s+src);
			return;
		}
		visited.add(src);
		for (int nbrs: map.get(src).keySet()) {
			if(!visited.contains(nbrs)) {
				printAllPath(nbrs, des, visited, s+src);
			}
			
		}
		visited.remove(src);
	}
	
	public boolean BFS(int src, int des) {
		Queue<Integer> q = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();
		q.add(src);
		while(!q.isEmpty()) {
			//remove
			int rv = q.poll();
			
			//Ignore if already visited
			if(visited.contains(rv)) {
				continue;
			}
			
			//mark visited
			visited.add(rv);
			
			//self work
			if(rv == des) {
				return true;
			}
			
			//add unvisited nbrs
			for (int nbrs: map.get(rv).keySet()) {
				if(!visited.contains(nbrs)) {
					q.add(nbrs);
				}
			}
		}
		
		return false;
	}
	
	public boolean DFS(int src, int des) {
		Stack<Integer> st = new Stack<>();
		HashSet<Integer> visited = new HashSet<>();
		st.push(src);
		while(!st.isEmpty()) {
			//remove
			int rv = st.pop();
			
			//Ignore if already visited
			if(visited.contains(rv)) {
				continue;
			}
			
			//mark visited
			visited.add(rv);
			
			//self work
			if(rv == des) {
				return true;
			}
			
			//add unvisited nbrs
			for (int nbrs: map.get(rv).keySet()) {
				if(!visited.contains(nbrs)) {
					st.push(nbrs);
				}
			}
		}
		
		return false;
	}
	
	public void BFT() {
		Queue<Integer> q = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();
		for (int src : map.keySet()) {
			if(visited.contains(src)) {
				continue;
			}
			q.add(src);
			while(!q.isEmpty()) {
				//remove
				int rv = q.poll();
				
				//Ignore if already visited
				if(visited.contains(rv)) {
					continue;
				}
				
				//mark visited
				visited.add(rv);
				
				//self work
				System.out.print(rv);
				
				//add unvisited nbrs
				for (int nbrs: map.get(rv).keySet()) {
					if(!visited.contains(nbrs)) {
						q.add(nbrs);
					}
				}
			}
		}
	}
}
