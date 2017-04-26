package examples;

import java.util.ArrayList;
import java.util.List;

public class Example1 {
	void add12(List<Object> list) {
		list.add(12);
	}

	{
		List<Integer> listI = new ArrayList<>();
		add12(listI); // method cannot be applied

		List<String> listS = new ArrayList<>();
		add12(listS); // method cannot be applied
	}

}
