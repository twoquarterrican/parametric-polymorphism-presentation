package examples;

import java.util.ArrayList;
import java.util.List;

public class Example5a {
	// why do we get warnings about raw types and unchecked conversions?
	// Because they are telling us when bad things could be happening
	void cheatTheSystem() {
		List<Integer> listI = new ArrayList<>();

		List rawList = listI; // raw type warning here

		rawList.add("this is not an integer"); // unchecked warning here

		List<Double> listD = rawList; // another raw type warning here

		listD.get(0); // what?
	}
}
