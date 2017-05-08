package examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Example7 {

	void useSuppliers(List<Supplier<Object>> list) {}
	void useSuppliersQ(List<Supplier<?>> list) {}
	void useQSuppliers(List<? extends Supplier<Object>> list) {}
	void useQSuppliersQ(List<? extends Supplier<?>> list) {}
	void useSuppliersRaw(List list) {}

	{
		Supplier<String> stringSupplier = () -> "in the world is";
		List<Supplier<?>> qSupplierList = Arrays.asList(stringSupplier);
		useSuppliersQ(qSupplierList);
		useQSuppliers(qSupplierList);
		useQSuppliersQ(qSupplierList);
		useQSuppliersRaw(qSupplierList);

		List<Supplier<String>> stringSupplierList = Arrays.asList(stringSupplier);
		useSuppliersQ(stringSupplierList);
		useQSuppliers(stringSupplierList);
		useQSuppliersQ(stringSupplierList);
		useQSuppliersRaw(stringSupplierList);

		Supplier<Object> objectSupplier = () -> "carmen sandiego";
		List<Supplier<Object>> objectSupplierList = Arrays.asList(objectSupplier);
		useSuppliersQ(objectSupplierList);
		useQSuppliers(objectSupplierList);
		useQSuppliersQ(objectSupplierList);

		List<Supplier> rawSupplierList = Arrays.asList(objectSupplier);
		useSuppliersQ(rawSupplierList);
		useQSuppliers(rawSupplierList);
		useQSuppliersQ(rawSupplierList);
	}
}
