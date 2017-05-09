package examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Example11 {

	void rawTypeInGenericType(List<Supplier> list) {}
	void wildcardInGeneric(List<Supplier<?>> list) {}

	{
		// cannot use List<Supplier<String>> where List<Supplier> is expected
		Supplier<String> stringSupplier = () -> "when in the course of human events";
		List<Supplier<String>> stringSupplierList = Arrays.asList(stringSupplier);

		rawTypeInGenericType(stringSupplierList); // don't want to add a raw type supplier to a list containing very specific generic types
		wildcardInGeneric(stringSupplierList); // same

		// cannot use List<Supplier<String>> where List<Supplier> is expected
		Supplier rawTypeSupplier = () -> "it becomes necessary for one people";
		List<Supplier> rawTypeSupplierList = Arrays.asList(rawTypeSupplier);

		rawTypeInGenericType(rawTypeSupplierList);
		wildcardInGeneric(rawTypeSupplierList);
	}
}
