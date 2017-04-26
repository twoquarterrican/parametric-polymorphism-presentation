package examples;

import java.util.ArrayList;
import java.util.List;

public class Example2 {
	// tell the compiler to complain if you use
	// List.add for any non-null value
	void add12(List<?> list) {
		list.add(12); // '?' may be String
		list.add(null); // always compiles
	}
	
	{ // note that error has shifted from Example1
		List<Integer> listI = new ArrayList<>();
		add12(listI);
		
		List<String> listS = new ArrayList<>();
		add12(listS);
	}

}
