package examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Example9 {
	private interface MySupplier<T> extends Supplier<T> {}

	void addMyNumberSupplier(List<? extends Supplier<?>> list) {
		MySupplier<Number> numberSupplier = () -> 42L;
		// note that error moved compared to previous example
		// previously, the error was at the call site for this function
		// now the error is in the function
		list.add(numberSupplier);

		// the api is restricted: this is just about all we can do:
		Object o0 = list.get(0).get();
		Object o1 = list.get(1).get();
		Object o2 = list.get(2).get();
		// ... and so on ...
	}

	{
		MySupplier<String> stringSupplier = () -> "David Numberman";
		addMyNumberSupplier(Arrays.asList(stringSupplier));

		List<MySupplier<String>> mySupplierList = Arrays.asList(stringSupplier);
		addMyNumberSupplier(mySupplierList);
	}
}
