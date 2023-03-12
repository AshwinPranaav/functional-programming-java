package com.samples.ParallelStream;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.stream.Stream;

public class SequentialParallelStream {

	static void printStream(Stream<String> stream) {
		stream.forEach(s -> {
			System.out.println(LocalTime.now() + " -- Value: " + s + " -- Thread: " + Thread.currentThread().getName());
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	public static void main(String[] args) {
		System.out.println("Number of processors: " + Runtime.getRuntime().availableProcessors());
		String str[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		System.out.println("--- Sequential ---");
		printStream(Arrays.stream(str).sequential()); // by default it is sequential
		
		System.out.println("--- Parallel ---");
		printStream(Arrays.stream(str).parallel());
	}

}
