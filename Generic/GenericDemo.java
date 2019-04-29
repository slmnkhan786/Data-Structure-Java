package Generic;

import java.util.Comparator;

public class GenericDemo {
	public static void main(String args[]) {
		Car[] cr = new Car[5];
		display(cr);
		cr[0] = new Car(150, 50, "Black");
		cr[1] = new Car(400, 60, "Green");
		cr[2] = new Car(950, 60, "White");
		cr[3] = new Car(650, 70, "Red");
		cr[4] = new Car(150, 80, "Blue");
		display(cr);
		
		//bubbleSort(cr);
		System.out.println();

		bubbleSort(cr, new carPriceComparater());
		display(cr);
		
	}

	public static <G> void display(G[] cr) {
		for (G val : cr)
			System.out.println(val);
	}

	public static <G extends Comparable<G>> void bubbleSort(G[] car) {

		for (int counter = 0; counter < car.length - 1; counter++) {
			for (int i = 0; i < car.length - counter - 1; i++) {
				if (car[i].compareTo(car[i + 1]) > 0) {
					G temp = car[i];
					car[i] = car[i + 1];
					car[i + 1] = temp;
				}
			}
		}
	}

	public static<G> void bubbleSort(G[] car,Comparator<G> comparator )
	   {
		   
		   for(int counter=0;counter<car.length-1;counter++)
		   {
			   for(int i=0;i<car.length-counter-1;i++)
			   {
				   if(comparator.compare(car[i],car[i+1])>0)
				   {
					  G temp=car[i];
					  car[i]=car[i+1];
					  car[i+1]=temp;
				   }
			   }
		   }
	   }
}
