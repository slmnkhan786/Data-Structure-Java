package HeapDemo;

import java.util.*;

public class HeapGenericClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arr[] = {1,4,5,2,3,7,8,6,10,9 };
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(5);
		list1.add(10);
		list1.add(15);
		list1.add(20);
		list1.add(25);
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list2.add(3);
		list2.add(6);
		list2.add(8);
		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(9);
		list3.add(13);
		list3.add(30);
		list3.add(35);
		ArrayList<Integer> list4 = new ArrayList<>();
		list4.add(25);
		list4.add(40);
		list4.add(45);
		list4.add(50);
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		lists.add(list4);
		kLargestElement(arr,4);
		//System.out.println(mergeKSortedList(lists));
	}

	public static void kLargestElement(int[] arr, int k) {
		HeapGeneric<Integer> heap = new HeapGeneric<>();
		for (int i = 0; i < k; i++) {
			heap.add(arr[i]);
		}
		for (int i = k; i < arr.length; i++) {
			int num = heap.remove();
			if (num < arr[i]) {
				heap.add(arr[i]);
			} else
				heap.add(num);
		}
		while (!heap.isEmpty())
			System.out.print(heap.remove() + " ");
	}
    private static class Pair implements Comparable<Pair>
    {
    	int data;
    	int idx;
    	int list;
    	@Override
    	public int compareTo(Pair o)
    	{
    		return this.data-o.data;
    	}
    }
	public static ArrayList<Integer> mergeKSortedList(ArrayList<ArrayList<Integer>> lists) {
     ArrayList<Integer> ans=new ArrayList<>();
     HeapGeneric<Pair> heap=new HeapGeneric<>();
    
     for(int i=0;i<lists.size();i++)
     {
    	 Pair np = new Pair();
    	 np.data=lists.get(i).get(0);
    	 np.idx=0;
    	 np.list=i;
    	 heap.add(np);
     }
     while(!heap.isEmpty())
     {
    	 Pair rp=heap.remove();
    	 ans.add(rp.data);
    	 rp.idx++;
    	 if(lists.get(rp.list).size()>rp.idx)
    	 {
    		 rp.data=lists.get(rp.list).get(rp.idx);
    		 heap.add(rp);
    	 }
     }
     return ans;
	}
}
