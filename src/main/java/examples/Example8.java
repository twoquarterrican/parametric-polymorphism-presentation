package examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Example8 {
	private interface MySupplier<T> extends Supplier<T> {}

	void addMyNumberSupplier(List<Supplier<?>> list) {
		MySupplier<Number> numberSupplier = () -> 42L;
		list.add(numberSupplier);
	}

	{
		// surprise! this works because the inferred type from Arrays.asList is List<Supplier<?>>
		MySupplier<String> stringSupplier = () -> "David Numberman";
		addMyNumberSupplier(Arrays.asList(stringSupplier));

		// this fails because the type is not a sub type of List<Supplier<?>>
		List<MySupplier<String>> mySupplierList = Arrays.asList(stringSupplier);
		addMyNumberSupplier(mySupplierList);
	}
}
