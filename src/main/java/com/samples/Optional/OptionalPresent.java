package com.samples.Optional;

import java.util.Optional;

public class OptionalPresent {

	public static void main(String[] args) {
		Optional<String> ofNullable = Optional.ofNullable("Java 8");
		System.out.println(ofNullable.isPresent() ? ofNullable.get() : Optional.empty());
		ofNullable.ifPresent(s -> System.out.println(s));
		ofNullable.ifPresentOrElse(s -> System.out.println(s), () -> System.out.println(Optional.empty()));
	}

}
