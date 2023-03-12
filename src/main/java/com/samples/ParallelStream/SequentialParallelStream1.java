package com.samples.ParallelStream;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class SequentialParallelStream1 {

	static int sumUsingSequential() {
		return IntStream.rangeClosed(1, 1000000).sum();
	}
	
	static int sumUsingParallel() {
		return IntStream.rangeClosed(1, 1000000).parallel().sum();
	}
	
	static long checkPerformance(Supplier<Integer> sumMethod, int numOfTimes) {
		long start = System.currentTimeMillis();
		for(int i = 0; i < numOfTimes; i++) {
			sumMethod.get();
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
	
	public static void main(String[] args) {
		System.out.println("Sum using sequential: " + sumUsingSequential());
		System.out.println("Sum using parallel: " + sumUsingParallel());
		
		System.out.println("Sum using sequential: " + checkPerformance(SequentialParallelStream1::sumUsingSequential, 100));
		System.out.println("Sum using parallel: " + checkPerformance(SequentialParallelStream1::sumUsingParallel, 100));
	}

}
