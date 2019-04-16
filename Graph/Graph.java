package Graph;

import java.util.*;

import com.sun.tools.sjavac.server.SysInfo;

public class Graph {
	public class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<String, Integer>();
	}

	private static final Boolean True = null;

	HashMap<String, Vertex> vtces;

	Graph() {
		vtces = new HashMap<String, Vertex>();
	}

	public int num_vertex() {
		return vtces.size();
	}

	public boolean contains_vertex(String vname) {
		if (vtces.containsKey(vname))
			return true;
		return false;
	}

	public void add_vertex(String vname) {
		Vertex vertex = new Vertex();
		vtces.put(vname, vertex);
	}

	public void remove_vertex(String vname) {
		if (vtces.containsKey(vname)) {
			for (String key : vtces.get(vname).nbrs.keySet()) {
				Vertex vertex = vtces.get(key);
				vertex.nbrs.remove(vname);
			}
			vtces.remove(vname);
		}
	}

	public int num_Edges() {
		int sum = 0;

		for (String key : vtces.keySet()) {
			sum += vtces.get(key).nbrs.size();
		}
		return sum / 2;
	}

	public boolean contains_edge(String vname1, String vname2) {
		Vertex vt1 = vtces.get(vname1);
		Vertex vt2 = vtces.get(vname2);
		if (vt1 == null || vt2 == null || !vt1.nbrs.containsKey(vname2))
			return false;
		return true;
	}

	public void add_edge(String vname1, String vname2, int weight) {
		Vertex vt1 = vtces.get(vname1);
		Vertex vt2 = vtces.get(vname2);
		if (vt1 == null || vt2 == null || vt1.nbrs.containsKey(vname2))
			return;
		vt1.nbrs.put(vname2, weight);
		vt2.nbrs.put(vname1, weight);
	}

	public void remove_edge(String vname1, String vname2) {
		Vertex vt1 = vtces.get(vname1);
		Vertex vt2 = vtces.get(vname2);
		if (vt1 == null || vt2 == null || !vt1.nbrs.containsKey(vname2))
			return;
		vt1.nbrs.remove(vname2);
		vt2.nbrs.remove(vname1);
	}

	public void display() {
		for (String key : vtces.keySet()) {
			System.out.println(key + " - " + vtces.get(key).nbrs);
		}
	}

	// Check if path exist b/w two vertex or not

	public boolean hasPath(String vname1, String vname2, HashMap<String, Boolean> processed) {
		processed.put(vname1, True);
		if (contains_edge(vname1, vname2))
			return true;
		Vertex vtx = vtces.get(vname1);
		for (String key : vtx.nbrs.keySet()) {
			if (!processed.containsKey(key) && hasPath(key, vname2, processed))
				return true;

		}
		return false;
	}

	// Breadth First Search

	private static class Pair {
		String vname;
		String psf;
	}

	public boolean BFS(String src, String dst) {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();

		// Create a new pair
		Pair npr = new Pair();
		npr.vname = src;
		npr.psf = src;

		// put pair queue
		queue.addLast(npr);

		// Work while queue is not empty
		while (!queue.isEmpty()) {

			// Remove a pair from queue
			Pair rp = queue.removeFirst();

			if (processed.containsKey(rp.vname))
				continue;
			// Put in processed hashmap
			processed.put(rp.vname, True);

			// Check for direct edge
			if (contains_edge(rp.vname, dst)) {
				System.out.println("Path is " + (rp.psf + dst));
				return true;
			}

			// nbrs
			Vertex rpvertex = vtces.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(rpvertex.nbrs.keySet());

			for (String nbr : nbrs) {
				// Process only unprocessed vertex
				if (!processed.containsKey(nbr)) {
					// Create a new pair and put in queue
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;

					queue.addLast(np);
				}
			}

		}
		return false;
	}

	// Depth First Search

	public boolean DFS(String src, String dst) {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();

		// Create a new pair
		Pair npr = new Pair();
		npr.vname = src;
		npr.psf = src;

		// put pair queue
		stack.addFirst(npr);

		// Work while queue is not empty
		while (!stack.isEmpty()) {

			// Remove a pair from stack
			Pair rp = stack.removeFirst();

			if (processed.containsKey(rp.vname))
				continue;

			// Put in processed hashmap
			processed.put(rp.vname, True);

			// Check for direct edge
			if (contains_edge(rp.vname, dst)) {
				System.out.println("Path is " + (rp.psf + dst));
				return true;
			}

			// nbrs
			Vertex rpvertex = vtces.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(rpvertex.nbrs.keySet());

			for (String nbr : nbrs) {
				// Process only unprocessed vertex
				if (!processed.containsKey(nbr)) {
					// Create a new pair and put in stack
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;

					stack.addLast(np);
				}
			}

		}
		return false;
	}

	// Breadth First Traversal

	public void BFT() {

		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> list = new ArrayList<>(vtces.keySet());

		for (String key : list) {
			if (processed.containsKey(key))
				continue;

			// Create a new pair
			Pair npr = new Pair();
			npr.vname = key;
			npr.psf = key;

			// put pair queue
			queue.addLast(npr);

			// Work while queue is not empty
			while (!queue.isEmpty()) {

				// Remove a pair from queue
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname))
					continue;

				// Put in processed hashmap
				processed.put(rp.vname, True);

				// print removed vertex and path so far
				System.out.println(rp.vname + " via " + rp.psf);

				// nbrs
				Vertex rpvertex = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvertex.nbrs.keySet());

				for (String nbr : nbrs) {
					// Process only unprocessed vertex
					if (!processed.containsKey(nbr)) {
						// Create a new pair and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}
		}
	}

	// Depth First Traversal

	public void DFT() {

		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();
		ArrayList<String> list = new ArrayList<>(vtces.keySet());

		for (String key : list) {
			if (processed.containsKey(key))
				continue;

			// Create a new pair
			Pair npr = new Pair();
			npr.vname = key;
			npr.psf = key;

			// put pair stack
			stack.addFirst(npr);

			// Work while queue is not empty
			while (!stack.isEmpty()) {

				// Remove a pair from stack
				Pair rp = stack.removeFirst();

				if (processed.containsKey(rp.vname))
					continue;

				// Put in processed hashmap
				processed.put(rp.vname, True);

				// print removed vertex and path so far
				System.out.println(rp.vname + " via " + rp.psf);

				// nbrs
				Vertex rpvertex = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvertex.nbrs.keySet());

				for (String nbr : nbrs) {
					// Process only unprocessed vertex
					if (!processed.containsKey(nbr)) {
						// Create a new pair and put in stack
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						stack.addFirst(np);
					}
				}

			}
		}
	}

	// Check whether a cycle is present or not

	public boolean isCyclic() {

		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> list = new ArrayList<>(vtces.keySet());

		for (String key : list) {
			if (processed.containsKey(key))
				continue;

			// Create a new pair
			Pair npr = new Pair();
			npr.vname = key;
			npr.psf = key;

			// put pair queue
			queue.addLast(npr);

			// Work while queue is not empty
			while (!queue.isEmpty()) {

				// Remove a pair from queue
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname))
					return true;

				// Put in processed hashmap
				processed.put(rp.vname, True);

				// nbrs
				Vertex rpvertex = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvertex.nbrs.keySet());

				for (String nbr : nbrs) {
					// Process only unprocessed vertex
					if (!processed.containsKey(nbr)) {
						// Create a new pair and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}
		}
		return false;
	}

	// Check whether graph is connected
	
	public boolean isConnected() {

		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> list = new ArrayList<>(vtces.keySet());
		int count = 0;
		for (String key : list) {
			if (processed.containsKey(key))
				continue;
			count++;
			// Create a new pair
			Pair npr = new Pair();
			npr.vname = key;
			npr.psf = key;

			// put pair queue
			queue.addLast(npr);

			// Work while queue is not empty
			while (!queue.isEmpty()) {

				// Remove a pair from queue
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname))
					continue;

				// Put in processed hashmap
				processed.put(rp.vname, True);

				// nbrs
				Vertex rpvertex = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvertex.nbrs.keySet());

				for (String nbr : nbrs) {
					// Process only unprocessed vertex
					if (!processed.containsKey(nbr)) {
						// Create a new pair and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}
			if (count > 1)
				return false;
		}
		return true;
	}

	// Check if Graph is Tree or not

	public boolean isTree() {
		if (isConnected() && !isCyclic())
			return true;
		return false;
	}

	//Get Connected Components 
	
	public ArrayList<ArrayList<String>> connected_Component() {

		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> list = new ArrayList<>(vtces.keySet());
        ArrayList<ArrayList<String>> list_ans=new ArrayList<>();
		for (String key : list) {
			if (processed.containsKey(key))
				continue;
             ArrayList<String> list1=new ArrayList<>();
			// Create a new pair
			Pair npr = new Pair();
			npr.vname = key;
			npr.psf = key;

			// put pair queue
			queue.addLast(npr);

			// Work while queue is not empty
			while (!queue.isEmpty()) {

				// Remove a pair from queue
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname))
					continue;

				// Put in processed hashmap
				processed.put(rp.vname, True);
				
				list1.add(rp.vname);

				// nbrs
				Vertex rpvertex = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvertex.nbrs.keySet());

				for (String nbr : nbrs) {
					// Process only unprocessed vertex
					if (!processed.containsKey(nbr)) {
						// Create a new pair and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}
			list_ans.add(list1);
		}
		return list_ans;
	}
	public static void main(String args[]) {
		Graph graph = new Graph();
		graph.add_vertex("A");
		graph.add_vertex("B");
		graph.add_vertex("C");
		graph.add_vertex("D");
		graph.add_vertex("E");
		graph.add_vertex("F");
		graph.add_vertex("G");
		graph.add_edge("A", "B", 10);
		graph.add_edge("A", "D", 20);
		graph.add_edge("B", "C", 5);
		graph.add_edge("C", "D", 3);
		graph.add_edge("D", "E", 1);
		graph.add_edge("E", "F", 2);
		graph.add_edge("F", "G", 30);
		graph.add_edge("E", "G", 50);

//		graph.display();

//		 System.out.println(graph.hasPath("A", "F", new HashMap<>()));
//		 graph.remove_edge("E", "F");
//		 System.out.println(graph.hasPath("A", "F", new HashMap<>()));

//		System.out.println(graph.BFS("A", "F"));
//		graph.remove_edge("D", "E");
//		System.out.println(graph.BFS("A", "F"));

//		System.out.println(graph.DFS("A", "F"));
//		graph.remove_vertex("B");
//		graph.add_vertex("H");
//		graph.add_edge("A", "H", 10);
//		graph.add_edge("H", "C", 20);
//		System.out.println(graph.DFS("A", "F"));

//		graph.BFT();
//		graph.remove_edge("D", "E");
//		graph.BFT();

//		graph.DFT();
//		graph.remove_edge("D", "E");
//		graph.DFT();

//		System.out.println(graph.getcc());

//		System.out.println(graph.isCyclic());

//		System.out.println(graph.isConnected());

//	    System.out.println(graph.isTree());
		
		graph.remove_edge("D","E");
		System.out.println(graph.connected_Component());
		
//		System.out.println(graph.isByPartite());

	}
}
