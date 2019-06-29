package Graph;

public class GraphClient {

	public static void main(String args[]) {
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addEdge("A", "B", 10);
		graph.addEdge("A", "D", 20);
		graph.addEdge("B", "C", 5);
		graph.addEdge("C", "D", 3);
		graph.addEdge("D", "E", 1);
		graph.addEdge("E", "F", 2);
		graph.addEdge("F", "G", 30);
		graph.addEdge("E", "G", 50);

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
		
		graph.removeEdge("D","E");
		System.out.println(graph.connected_Component());
		
//		System.out.println(graph.isByPartite());

	}
}
