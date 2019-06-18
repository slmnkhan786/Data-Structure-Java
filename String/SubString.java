package String;

import java.util.*;

public class SubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		subString(str);

	}

	public static void subString(String str) {
      
		int n=str.length();
		
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<=n;j++)
				System.out.println(str.substring(i,j));
		}
		
	}

}
