package com.samples.ParallelStream;

import java.util.stream.IntStream;

public class ParallelStreamWhenNotToUse1 {

	public static void main(String[] args) {
		
		// sequential and parallel will return different results when updating
		Calculation cal = new Calculation();
		
		IntStream.rangeClosed(1, 100).forEach(cal::calculate);
		System.out.println("Sequential:" + cal.getTotal());
		
		IntStream.rangeClosed(1, 100).parallel().forEach(cal::calculate);
		System.out.println("Parallel:" + cal.getTotal());
	}

}

class Calculation {
	private int total;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public void calculate(int integer) {
		total += integer;
	}
}
