package com.runner.test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class Java9 
{

	@Test
	public void java9Test()
	{
		Stream<Integer> stInt = Stream.of(4,6,7,9,1,3,5,10,5,9,0,1);
		
		stInt.takeWhile(i -> i<10)
		.collect(Collectors.toList())
		.forEach(System.out::print);
		
		System.out.println();
		Stream<Integer> stInt2 = Stream.of(4,6,7,9,1,3,5,10,5,9,0,1);
		
		stInt2.dropWhile(i -> i<10)
		.collect(Collectors.toList())
		.forEach(System.out::print);
		
		
	}
	
	
	@Test
	public void immutableColelctions()
	{
		List<Integer> lst = List.of(1,3,8,6,7);
		Set<String> set = Set.of("ab","bc","deee");
		Map<String,Integer> map = Map.of(
				"k1",1,
				"k2",2,
				"k3",3
				);
		
		System.out.println(lst);
		System.out.println(set);
		System.out.println(map);
		
		
		List<Integer> lst1 = List.of(1,3,8,6,7,null); //not allowed null
		Set<String> set1 = Set.of("ab","bc","bc","deee"); //not allowed duplicate
		lst.add(80); //mutation(adding/removing element) not allowed
		
		
	}
}
