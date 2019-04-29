package HeapDemo;

public class HeapClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        HeapGeneric<Integer> hp=new HeapGeneric<>();
        for(int i=5;i>=1;i--)
        {
        	hp.add(10*i);
        	hp.display();
        }
        for(int i=0;i<5;i++)
        {
        	System.out.println(hp.remove());
        	hp.display();
        }
	}

}
