package examples;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Example4 {
	void add12(List<? super Integer> list) {
		list.add(12); // '?' may be String
		list.add(12.0); // Doubles not allowed
		list.add("12"); // Strings not allowed

		Integer x = list.get(0); // can't assume upper bound on type
		Object y = list.get(0); // 'get' always returns an object
	}

	{ // List<T> where T is a superclass of Integer
		List<Integer> listI = new ArrayList<>();
		add12(listI);

		List<Number> listN = new ArrayList<>();
		add12(listN);

		List<Object> listO = new ArrayList<>();
		add12(listO);

		List<Serializable> listS = new ArrayList<>();
		add12(listS);

		List<Comparable<? super Integer>> listC = new ArrayList<>();
		add12(listC);
	}

}
