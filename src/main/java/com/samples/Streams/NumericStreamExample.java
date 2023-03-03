package com.samples.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreamExample {

	static BinaryOperator<Integer> bo = (a, b) -> a + b;
	
	static int calculateSum(List<Integer> list) {
		return list.stream().reduce(0, bo); // can also be reduce(0, Integer::sum);
	}
	
	static int calculateSumIntStream(IntStream intStream) {
		return intStream.sum();
	}
	
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);
		System.out.println("Sum: " + calculateSum(list1));
		
		IntStream intStream1 = IntStream.rangeClosed(1, 6);
		System.out.println("IntStream rangeClosed sum: " + calculateSumIntStream(intStream1));
		
		IntStream intStream2 = list1.stream().mapToInt(x -> x); // IntStream of list mapToInt(Integer::intValue)
		System.out.println("IntStream list sum: " + calculateSumIntStream(intStream2));
	}

}
