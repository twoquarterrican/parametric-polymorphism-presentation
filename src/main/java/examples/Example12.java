package examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Example12 {

	void twoWildcards(List<? extends Supplier<?>> list) {}

	{
		// cannot use List<Supplier<String>> where List<Supplier> is expected
		Supplier<String> stringSupplier = () -> "when in the course of human events";
		List<Supplier<String>> stringSupplierList = Arrays.asList(stringSupplier);

		twoWildcards(stringSupplierList);

		// cannot use List<Supplier<String>> where List<Supplier> is expected
		Supplier rawTypeSupplier = () -> "it becomes necessary for one people";
		List<Supplier> rawTypeSupplierList = Arrays.asList(rawTypeSupplier);

		twoWildcards(rawTypeSupplierList);
	}

}
