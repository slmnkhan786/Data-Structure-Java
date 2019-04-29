package Generic;

import java.util.Comparator;

public class carAvgComparator implements Comparator<Car>{

	@Override
	public int compare(Car o1, Car o2) {
		return o1.avg-o2.avg;
	}
}
