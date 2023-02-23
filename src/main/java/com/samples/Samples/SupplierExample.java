package com.samples.Samples;

import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

	public static void supplier() {
		Supplier<List<Person>> s = () -> PersonRepository.getAllPersons();
		// like you can use for db connections
		System.out.println("Supplier: " + s.get());
	}
	
	public static void main(String[] args) {
		supplier();
	}

}
