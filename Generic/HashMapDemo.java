package Generic;
import java.util.*;
public class HashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner sc=new Scanner(System.in);
      int arr[]= {1,5,2,9,6,45,11,34,14,16,17,15,18,19,10,13};
      System.out.println(longestConsecutiveSeq(arr));
	}
   public static ArrayList<Integer> longestConsecutiveSeq(int []arr)
   {
	   HashMap<Integer,Boolean> map=new HashMap<>();
	   for(int i=0;i<arr.length;i++)
	   {
		   int num=arr[i];
		   if(map.containsKey(num-1))
		   {
			   map.put(num,false );
		   }
		   else
		   {
			   map.put(num,true);
		   }
		   if(map.containsKey(num+1))
		   {
			   map.put(num+1, false);
		   }
	   }
	   int count=0;
	   int start=0;
	   for(Integer val:map.keySet())
	   {
		   if(map.get(val))
		   {
			   int c=0;
			   while(map.containsKey(val+c))
			   {
				   c++;
			   }
			   if(c>count)
				   count=c;
			   start=val;
		   }
	   }
	   ArrayList<Integer> list=new ArrayList<>();
	   for(int i=0;i<count;i++)
		   list.add(start+i);
	   return list;
   }
}
