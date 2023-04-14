package com.runner.test;

import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.ArrayList;

import org.testng.annotations.Test;

public class PrimitiveStream 
{
	
	@Test
	public void primitiveStream()
	{
		List<Integer>  lst = new ArrayList<>();
		
		Collections.addAll(lst, 1,2,3,4,5,67,8,99);
		
		int sum = lst.stream().mapToInt(i -> i ).sum();
		System.out.println(sum);
		
		IntStream.rangeClosed(0, 100)
		.forEach(i -> System.out.println(i));
				
		
		OptionalInt in =IntStream.rangeClosed(0, 100)
		.filter(i -> i>8)
		.findFirst(); 
		
		System.out.println(in.getAsInt());
		
		OptionalInt in1 =IntStream.rangeClosed(0, 100)
				.filter(i -> i>8)
				.findAny(); 
				
				System.out.println(in1.getAsInt());
	}
}
