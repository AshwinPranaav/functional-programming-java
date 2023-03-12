package com.samples.ParallelStream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamWhenNotToUse {

	static long sequentialCalculation(List<Integer> list) {
		long start = System.currentTimeMillis();
		int sum = list
				.stream()
				.reduce(0, Integer::sum);
		long end = System.currentTimeMillis();
		System.out.println("Time taken for sequentialCalculation: " + (end - start));
		return sum;
	}
	
	static long parallelCalculation(List<Integer> list) {
		long start = System.currentTimeMillis();
		int sum = list
				.parallelStream()
				.reduce(0, Integer::sum);
		long end = System.currentTimeMillis();
		System.out.println("Time taken for parallelCalculation: " + (end - start));
		return sum;
	}
	
	public static void main(String[] args) {
		
		/**
		 * When we are modifying data intermediately, in this case addition, sequentialStream seems to be faster than
		 * parallelStream
		 */
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 
				26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 
				51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 
				76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100);
		List<Integer> list1 = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
		
		System.out.println("Sum using sequentialCalculation: " + sequentialCalculation(list));
		System.out.println("Sum using parallelCalculation: " + parallelCalculation(list));
		
		System.out.println("Sum using sequentialCalculation list1: " + sequentialCalculation(list1));
		System.out.println("Sum using parallelCalculation list1: " + parallelCalculation(list1));
	}

}
