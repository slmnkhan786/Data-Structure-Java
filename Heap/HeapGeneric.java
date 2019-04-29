package HeapDemo;

import java.util.*;

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
