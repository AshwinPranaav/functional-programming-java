package com.samples.Streams;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamFactoryAggregateMethods {
	
	public static void main(String[] args) {
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
		System.out.println("Plain list sum: " + list.stream().reduce(Integer::sum));
		
		int sum = IntStream.rangeClosed(1, 10).sum();
		System.out.println("Sum is (range): " + sum);
		OptionalInt maxOptional = IntStream.rangeClosed(1, 10).max();
		int max = maxOptional.getAsInt();
		System.out.println("Max is (range): " + max);
		
		IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6);
		List<Integer> integerList = intStream.boxed().collect(Collectors.toList());
		integerList.stream().reduce((a, b) -> a + b);
		System.out.println("Intstream to list and sum: " + integerList.stream().reduce((a, b) -> a + b));
		
		OptionalLong maxOptionalLong = LongStream.rangeClosed(1, 10).max();
		long maxLong = maxOptionalLong.getAsLong();
		System.out.println("Max long is (range): " + maxLong);
		
		OptionalDouble avg = LongStream.rangeClosed(1, 10).average();
		System.out.println("Average long: " + avg.getAsDouble());
	}
}
