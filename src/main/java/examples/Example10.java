package examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Example10 {

	void rawTypeMethod(List list) {}
	void genericTypeMethod(List<?> list) {}
	void nestedRawInGeneric(List<Supplier> list) {}
	void nestedGenericInGeneric(List<Supplier<?>> list) {}

	{
		// cannot use List<Supplier<String>> where List<Supplier> is expected
		Supplier<String> stringSupplier = () -> "when in the course of human events";
		List<Supplier<String>> stringSupplierList = Arrays.asList(stringSupplier);

		rawTypeMethod(stringSupplierList);
		genericTypeMethod(stringSupplierList);
		nestedRawInGeneric(stringSupplierList); // don't want to add a raw type supplier to a list containing very specific generic types
		nestedGenericInGeneric(stringSupplierList); // same


		// cannot use List<Supplier<String>> where List<Supplier> is expected
		Supplier rawTypeSupplier = () -> "it becomes necessary for one people";
		List<Supplier> rawTypeSupplierList = Arrays.asList(rawTypeSupplier);

		rawTypeMethod(rawTypeSupplierList);
		genericTypeMethod(rawTypeSupplierList);
		nestedRawInGeneric(rawTypeSupplierList);
		nestedGenericInGeneric(rawTypeSupplierList);
	}

}
