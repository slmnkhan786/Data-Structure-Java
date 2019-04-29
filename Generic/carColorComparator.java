package Generic;

import java.util.Comparator;

public class carColorComparator implements Comparator<Car>{

	@Override
	public int compare(Car o1, Car o2) {
		return o1.col.compareTo(o2.col);
	}
}
