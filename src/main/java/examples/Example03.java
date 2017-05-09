package examples;

import java.util.ArrayList;
import java.util.List;

public class Example03 {
	void addFirst(List<?> list) {
		Object x = list.get(0);
		list.add(x); // ??????

		? t = list.get(0); // ? is not a valid identifier
	}

	<T> void addFirstCapture(List<T> list) {
		Object x = list.get(0);
		list.add(x); // still doesn't work

		T t = list.get(0); // T is a valid identifier
		list.add(t); // works, thanks to capture
	}

}
