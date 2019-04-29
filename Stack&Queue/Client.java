package L9_sep16;

public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        Stack s=new DyStack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60);
        s.push(70);
        s.display();
        System.out.println(s.pop());
        System.out.println(s.size());  
        System.out.println(s.peek());
        System.out.println(s.isEmpty());
        System.out.println(s.isFull());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
	}

}
