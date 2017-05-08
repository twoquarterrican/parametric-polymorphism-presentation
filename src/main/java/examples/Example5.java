package examples;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Example5 {
	void add12(List<? extends Number> list) {
		list.add(12); // '?' may be Integer, may be Long, may be Float, may be Number
		list.add(12.0); // Doubles not allowed either
		list.add(null); // the only thing we can add (intersection of subtypes of Number)

		Number x = list.get(0); // recall that this will not work for List<? super Number>
	}

	{
		List<Integer> listI = new ArrayList<>();
		add12(listI);

		List<Number> listN = new ArrayList<>();
		add12(listN);

		List<Object> listO = new ArrayList<>();
		add12(listO); // not allowed because list.get(0) must be castable to a number

		List<Serializable> listS = new ArrayList<>();
		add12(listS); // not allowed because list.get(0) must be castable to a number

		List<Comparable<? super Integer>> listC = new ArrayList<>();
		add12(listC); // not allowed because list.get(0) must be castable to a number
	}

}
