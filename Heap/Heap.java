package HeapDemo;

import java.util.*;

public class Heap {
	ArrayList<Integer> data = new ArrayList<>();

	public int size() {
		return this.data.size();
	}
	public boolean isEmpty()
	{
		return this.data.size()==0;
	}
	public void add(int item)
	{
		this.data.add(item);
		unheapify(this.data.size()-1);
	}
	private void unheapify(int ci)
	{
		int pi=(ci-1)/2;
		if(this.data.get(pi)>this.data.get(ci))
		{
			swap(pi,ci);
			unheapify(pi);
		}
	}
	private void swap(int pi, int ci) {
		int pnum=this.data.get(pi);
		int cnum=this.data.get(ci);
		this.data.set(pi,cnum);
		this.data.set(ci,pnum);
		
	}
	public int remove()
	{
		int val=this.data.get(0);
		swap(0,this.data.size()-1);
		this.data.remove(this.data.size()-1);
		downheapify(0);
		return val;
	}
	private void downheapify(int i) {
		int mini=i;
		int lci=2*i+1;
		int rci=2*i+2;
		if(lci<this.data.size()&&this.data.get(mini)>this.data.get(lci))
			mini=lci;
		if(rci<this.data.size()&&this.data.get(mini)>this.data.get(rci))
			mini=rci;
		if(mini!=i)
		{
			swap(i,mini);
			downheapify(mini);
			
		}
	}
	public int getHP()
	{
		return this.data.get(0);
	}
	public void display()
	{
		System.out.println(this.data);
	}
}
