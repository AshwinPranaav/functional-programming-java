package com.samples.Streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamMapExample {

	static double mapToDoubleSum() {
		return IntStream.rangeClosed(1, 6)
				.mapToDouble(x -> x)
				.sum();
//		return IntStream.rangeClosed(1, 6)
//				.asDoubleStream()
//				.sum();
		/**
		 * mapToDouble(x -> x) and asDoubleStream() return DoubleStream
		*/
	}
	
	static long mapToLongSum() {
		return IntStream.rangeClosed(1, 6)
				.mapToLong(x -> x)
				.sum();
//		return IntStream.rangeClosed(1, 6)
//				.asLongStream()
//				.sum();
		/**
		 * mapToLong(x -> x) and asLongStream() return DoubleStream
		*/
	}
	
	static List<Integer> mapToObject() {
		return IntStream.rangeClosed(1, 6)
//				.mapToObj(x -> x)  
//				.boxed()
				.boxed().map(x -> x)
				.collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		System.out.println("Map to Double sum: " + mapToDoubleSum());
		System.out.println("Map to Long sum: " + mapToLongSum());
		System.out.println("Map to Object: " + mapToObject());
	}

}
