package com.samples.Samples;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

	static void consumerExample() {
		List<String> alphabets = List.of("a   ", "aa   ", "aaa   ");
		Consumer<String> c1 = a -> a.trim();
		Consumer<String> c2 = a -> System.out.println(a);
		Consumer<String> consumer = alphabet -> {
			if(alphabet.contains("a")) {
				c1.andThen(c2).accept(alphabet);;
			}
		};
		alphabets.forEach(consumer);
	}
	
	public static void main(String[] args) {
		consumerExample();
	}

}
