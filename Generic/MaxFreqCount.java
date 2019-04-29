package Generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MaxFreqCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    int arr1[]= {10,20,50,10,10,20,50,60};
    int arr2[]= {20,200,10,60,50,20};
    //String str=sc.next();
//    HashMap<Character,Integer> map=new HashMap<>();
//    maxFrequencyCount(str,map);
    intersection(arr1,arr2);
	}
  
	 public static void maxFrequencyCount(String str,HashMap<Character,Integer> map)
	   {
		   for(int i=0;i<str.length();i++)
		    {
		    	char ch=str.charAt(i);
		    	if(map.get(ch)==null)
		    	{
		    	map.put(ch,1);
		    	}
		    	else
		    	{
		    		int val=map.get(ch);
		    		map.put(ch,val+1);
		    	}
		    }
		    ArrayList<Character> list=new ArrayList<>(map.keySet()); 
		    int max=0;
		    char ans = 0;
		    for(Character val:list)
		    {
		    	int count=map.get(val);
		    	if(max<count)
		    	{
		    		ans=val;
		    		max=count;
		    	}
		    }
		    System.out.println(ans+" "+max);
	   }
	 public static void intersection(int []arr1,int []arr2)
	 {
		 ArrayList<Integer> list=new ArrayList<>();
		 HashMap<Integer,Integer> map=new HashMap<>();
		 for(int i=0;i<arr1.length;i++)
		 {
			 if(map.get(arr1[i])==null)
		    	{
		    	map.put(arr1[i],1);
		    	}
		    	else
		    	{
		    		int val=map.get(arr1[i]);
		    		map.put(arr1[i],val+1);
		    	}
		 }
		 for(int i=0;i<arr2.length;i++)
		 {
			 if(map.containsKey(arr2[i]))
			 {
				 
				 int count=map.get(arr2[i]);
				 if(count>0)
				 {
				 list.add(arr2[i]);
				 map.put(arr1[i], count-1);
				 }
			 }
		 }
		 
		 System.out.println(list);
	 }
}
