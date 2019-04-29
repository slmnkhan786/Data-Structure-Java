package Generic;

public class Car implements Comparable<Car> {
	int price;
	String col;
	int avg;

	public Car(int price, int avg, String col) {
		this.price = price;
		this.avg = avg;
		this.col = col;
	}

	public String toString() {
		return "Price :" + this.price + " Avg :" + this.avg + " Color :" + this.col;
	}
	public int compareTo(Car o) {
		return  this.avg-o.avg;
		// return o.price-this.price;
		// return this.col.compareTo(o.col);
	}
	
}
