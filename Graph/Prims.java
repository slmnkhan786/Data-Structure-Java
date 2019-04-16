import java.util.*;

import HeapDemo.HeapGeneric;

public class Graph {
	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	private HashMap<String, Vertex> vtces = new HashMap<>();
  public void addVertex(String vname) {
		Vertex vtx = new Vertex();
		vtces.put(vname, vtx);
	}
  
  public void addEdge(String vname1, String vname2, int cost) {
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);
		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2))
			return;
		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);
	}
  
  private class PrimsPair implements Comparable<PrimsPair> {
		String vname;
		String acqname;
		int cost;

		@Override
		public int compareTo(PrimsPair o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}

	public Graph prims() {
		Graph mst = new Graph();
		HashMap<String, PrimsPair> map = new HashMap<>();
		HeapGeneric<PrimsPair> heap = new HeapGeneric<>();

		for (String key : vtces.keySet()) {
			PrimsPair np = new PrimsPair();
			np.vname = key;
			np.acqname = null;
			np.cost = Integer.MAX_VALUE;
			heap.add(np);
			map.put(key, np);
		}

		// till the heap is not empty keep on removing the pairs
		while (!heap.isEmpty()) {
			// remove a pair
			PrimsPair rp = heap.remove();
			map.remove(rp.vname);

			// add to mst
			if (rp.acqname == null)
			{
				mst.addVertex(rp.vname);
			}
			else {
				mst.addVertex(rp.vname);
				mst.addEdge(rp.acqname, rp.vname, rp.cost);
			}

			// nbrs
			for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {
 
				// work for nbrs which are in heap
				if (map.containsKey(nbr)) {
					
					// get the old cost and new cost
					int oc = map.get(nbr).cost;
					int nc = vtces.get(rp.vname).nbrs.get(nbr);

					// update the pair when new cost is less
					if (nc < oc) {
						PrimsPair p = map.get(nbr);
						p.cost = nc;
						p.acqname = rp.vname;
						heap.updatePriority(p);
					}

				}

			}

		}
		return mst;

	}
  
  
  public class HeapGeneric<T extends Comparable<T>> {
	ArrayList<T> data = new ArrayList<>();
    HashMap<T,Integer> map = new HashMap<>();
	public int size() {
		return this.data.size();
	}
	public boolean isEmpty()
	{
		return this.data.size()==0;
	}
	public void add(T item)
	{
		this.data.add(item);
		map.put(item,this.data.size()-1);
		upheapify(this.data.size()-1);
	}
	private void upheapify(int ci)
	{
		int pi=(ci-1)/2;
		if(isLarger(this.data.get(pi),this.data.get(ci))>0)
		{
			swap(pi,ci);
			upheapify(pi);
		}
	}
	private void swap(int pi, int ci) {
		T pnum=this.data.get(pi);
		T cnum=this.data.get(ci);
		this.data.set(pi,cnum);
		this.data.set(ci,pnum);
		
		map.put(pnum, ci);
		map.put(cnum, pi);
		
	}
	public T remove()
	{
		T val=this.data.get(0);
		swap(0,this.data.size()-1);
		 T rv = this.data.remove(this.data.size()-1);
		
		downheapify(0);
		map.remove(rv);
		return val; 
	}
	private void downheapify(int i) {
		int mini=i;
		int lci=2*i+1;
		int rci=2*i+2;
		if(lci<this.data.size()&&isLarger(this.data.get(mini),this.data.get(lci))>0)
			mini=lci;
		if(rci<this.data.size()&&isLarger(this.data.get(mini),this.data.get(rci))>0)
			mini=rci;
		if(mini!=i)
		{
			swap(i,mini);
			downheapify(mini);
			
		}
	}
	
	public void updatePriority(T pair)
	{
		int ind = map.get(pair);
		 upheapify(ind);
	}
	
	public T getHP()
	{
		return this.data.get(0);
	}
	public void display()
	{
		System.out.println(this.data);
	}
	private int isLarger(T t,T o)
	{
		return t.compareTo(o);
	}
}

  
  public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addEdge("A", "B", 2);
		graph.addEdge("A", "D", 6);
		graph.addEdge("B", "C", 3);
		graph.addEdge("C", "D", 1);
		graph.addEdge("D", "E", 8);
		graph.addEdge("E", "F", 5);
		graph.addEdge("F", "G", 7);
		graph.addEdge("E", "G", 4);
    
		graph.prims().display();
	}
  
  }
