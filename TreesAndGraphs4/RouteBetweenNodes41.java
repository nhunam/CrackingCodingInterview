/*
 * 4.1 Route Between Nodes: Given a directed graph, design an algorithm to fnd out whether there is a
route between two nodes.
Input: Adjacency List; or Adjacency Matrix
Algorithm: DFS or BFS
 */

package TreesAndGraphs4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class RouteBetweenNodes41 {
	
	private Map<String, List<String>> adjVertices;
	private Set<String> visit;
	
	public RouteBetweenNodes41() {
		adjVertices = new HashMap<>();
		visit = new HashSet<>();
		createGraphByAdjList();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create Graph by adjacency list
		RouteBetweenNodes41 rbn = new RouteBetweenNodes41();
		System.out.println(rbn.advDFSList("A", "E"));
		System.out.println(rbn.advBFSList("A", "E"));
	}
	
	boolean advDFSList(String ver1, String ver2) {
		DFSList(ver1);
		if(visit.contains(ver2)) return true;
		return false;
	}
	
	boolean advBFSList(String ver1, String ver2) {
		BFSList(ver1);
		if(visit.contains(ver2)) return true;
		return false;
	}
	
	void DFSList(String ver1) {
		visit.add(ver1);
		List<String> l1 = adjVertices.get(ver1);
		if(l1 != null) {
			for (int i = 0; i < l1.size(); i++) {
				String des = l1.get(i);
				if(!visit.contains(des)) {
					visit.add(des);
					DFSList(des);
				}
			}
		}
	}
	
	void BFSList(String ver1) {
		visit.add(ver1);
		Queue<String> q = new LinkedList<String>();
		q.offer(ver1);
		while (q.size() > 0) {
			int size = q.size();
			for (int i = 0; i <= size; i++) {
				String ver = q.poll();
				List<String> l = adjVertices.get(ver);
				if(l != null) {
					for(int j = 0; j < l.size(); j++) {
						visit.add(l.get(j));
						q.offer(l.get(j));
					}
				}
					
			}
		}
	}
	
	void createGraphByAdjList() {
		List<String> lA = new ArrayList<>();
		lA.add("B");
		lA.add("C");
		adjVertices.put("A", lA);
		List<String> lC = new ArrayList<>();
		lC.add("D");
		adjVertices.put("C", lC);
		List<String> lD = new ArrayList<>();
		lD.add("E");
		adjVertices.put("D", lD);
		List<String> lE = new ArrayList<>();
		lE.add("B");
		adjVertices.put("E", lE);
	}
	
	
	
	
}
