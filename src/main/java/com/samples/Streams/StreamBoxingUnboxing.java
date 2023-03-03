package com.samples.Streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamBoxingUnboxing {

	static List<Integer> boxingInteger(IntStream intStream) {
		return intStream // primitive int
				.boxed() // conversion to Integer
				.collect(Collectors.toList());
	}
	
	static int calculateSumUnboxing(List<Integer> list) {
		return list
				.stream()
				.mapToInt(Integer::intValue) // unboxing to IntStream
				.sum();
	}
	
	public static void main(String[] args) {
		IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6);
		intStream.forEach(number -> {
			System.out.print(number + " ");
		});
		System.out.println();
		
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
		System.out.println("Sum: " + calculateSumUnboxing(list));
	}

}
