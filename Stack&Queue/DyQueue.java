package L9_sep16;
import java.util.*;
public class DyQueue extends Queue{
	public void queue(int item) throws Exception {
		if (isFull()) {
			int[] arr=new int[2*size];
			for(int i=0;i<size;i++)
			  {
				  arr[i]=data[(i+this.f)%data.length];
			  }
			this.data=arr;
			this.f=0;
		}
		super.queue(item);
		
	}

	
}
