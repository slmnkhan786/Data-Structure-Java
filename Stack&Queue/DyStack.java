package L9_sep16;

import java.util.*;

public class DyStack extends Stack {
	
	public DyStack()
	{
	
	}
	
	public DyStack(int cap)
	{
	super(cap);
	}
	
	public void push(int item) throws Exception {
		if(isFull())
		{
			int[] arr=new int[2*this.data.length];
			for(int i=0;i<data.length;i++)
				arr[i]=data[i];
			this.data=arr;
		}
		super.push(item);
	}
}
