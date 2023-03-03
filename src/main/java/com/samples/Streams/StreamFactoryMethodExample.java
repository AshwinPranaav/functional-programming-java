package com.samples.Streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StreamFactoryMethodExample {

	static UnaryOperator<Integer> add = x -> x + x;
	
	public static void main(String[] args) {
		Stream<Integer> streamIterate = Stream.iterate(1, add).limit(10);
		System.out.println("Stream Iterate:");
		streamIterate.forEach(System.out::println);
		
		Stream<Double> streamGenerate = Stream.generate(Math::random).limit(10);
		System.out.println("Stream Generate:");
		streamGenerate.forEach(System.out::println);
		
		System.out.println("Stream Generate:");
		Stream.generate(new Random()::nextInt).limit(10).forEach(System.out::println);
		
		System.out.println("Stream Of:");
		Stream<String> streamOf = Stream.of("One", "Two", "Three");
		streamOf.forEach(System.out::println);
	}

}
