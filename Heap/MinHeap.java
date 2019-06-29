package Heap;

import java.util.*;

public class MinHeap {

	private ArrayList<Integer> data = new ArrayList<>();

	public void add(int item) {

		this.data.add(item);
		upHeapify(this.data.size() - 1);

	}

	private void upHeapify(int ci) {

		int pi = (ci - 1) / 2;
		if (this.data.get(ci) < this.data.get(pi)) {
			this.swap(ci, pi);
			this.upHeapify(pi);

		}
	}

	private void swap(int ci, int pi) {

		int ith = this.data.get(ci);
		int jth = this.data.get(pi);

		this.data.set(ci, jth);
		this.data.set(pi, ith);

	}

	public void display() {
		System.out.println(this.data);
	}

	public int size() {
		return this.data.size();
	}

	public boolean isEmpty() {

		if (this.data.size() == 0)
			return true;

		return false;

	}

	public int get() {

		return this.data.get(0);

	}

	public int remove() {

		int rv = this.data.get(0);

		this.swap(0, this.data.size() - 1);
		this.data.remove(this.data.size() - 1);

		this.downHeapify(0);

		return rv;

	}

	private void downHeapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int mini = pi;

		if (lci < this.data.size() && this.data.get(mini) > this.data.get(lci))
			mini = lci;

		if (rci < this.data.size() && this.data.get(mini) > this.data.get(rci))
			mini = rci;

		if (mini != pi) {
			this.swap(pi, mini);
			this.downHeapify(mini);
		}

	}
	

}
