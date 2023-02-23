package com.samples.Samples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Iterators;

public class ForEachRemaining {
	public static void main(String[] args) {
		List<String> siteCodes = new ArrayList<>();
		/*siteCodes.add("1");
		siteCodes.add("2");
		siteCodes.add("3");
		siteCodes.add("4");
		siteCodes.add("5");
		siteCodes.add("6");
		
		Iterator<String> listIterator = siteCodes.iterator();
		
		while(listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}
		
		listIterator.forEachRemaining((item) -> {
			System.out.println(item);
			System.out.println("I don't print");
		});
		
		Iterators.partition(siteCodes.stream().iterator(), 2).forEachRemaining((list) -> {
			System.out.println(list);
		}); */
		for(int i=1; i<=1005; i++) {
			String str = "\"" + i + "\"";
			siteCodes.add(str);
		}
		System.out.println(siteCodes);
	}
}
