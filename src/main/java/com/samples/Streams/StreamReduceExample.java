package com.samples.Streams;

import java.util.Arrays;
import java.util.List;

public class StreamReduceExample {

	public static void main(String[] args) {
		List<Integer> listofNumbers = Arrays.asList(1, 2, 3, 4, 5);
		
		int sum = listofNumbers.stream().mapToInt(num -> num).sum(); // intenally sum() uses reduce() which uses evaluate()
		System.out.println("Sum using existing methods: " + sum);
		
		long count = listofNumbers.stream().mapToInt(num -> num).count();
		System.out.println("Count using existing methods: " + count); // internally count() uses evaluate()
		
		int mul = listofNumbers.stream().reduce(1, (a, b) -> a * b);
		System.out.println("Multiplication: " + mul);
	}

}
