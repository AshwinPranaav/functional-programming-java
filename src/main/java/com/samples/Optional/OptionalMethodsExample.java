package com.samples.Optional;

import java.util.Optional;

public class OptionalMethodsExample {

	public static void main(String[] args) {
		Optional<String> ofNullable = Optional.ofNullable("Java 8");
		System.out.println(ofNullable.isPresent() ? ofNullable.get() : Optional.empty());
		
		Optional<String> of = Optional.of("Java 8");
		System.out.println(of.isPresent() ? of.get() : Optional.empty());
	}

}
