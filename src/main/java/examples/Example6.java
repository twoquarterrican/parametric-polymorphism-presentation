package examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Supplier;

public class Example6 {
	void useSuppliers(List<Supplier<Object>> list) {}

	{
		// inferred type of each supplier is Supplier<Object>
		useSuppliers(Arrays.asList(
				() -> 10,
				() -> new ArrayList<>(),
				() -> "where",
				HashSet::new));

		// cannot use List<Supplier<String>> where List<Supplier<Object>> is expected
		Supplier<String> stringSupplier = () -> "in the world is";
		useSuppliers(Arrays.asList(stringSupplier));

		// seems silly, right?
		Supplier<Object> objectSupplier = () -> "carmen sandiego";
		useSuppliers(Arrays.asList(objectSupplier));
	}
}
