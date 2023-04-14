package com.runner.test;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;

public class FlatMapTest 
{
	@Test
	public void flatMapTest()
	{
		List<Integer> lst_a =new ArrayList<>();
		lst_a.add(1);
		lst_a.add(2);
		lst_a.add(3);
		
		List<Integer> lst_b =new ArrayList<>();
		lst_b.add(4);
		lst_b.add(5);
		lst_b.add(6);
		
		List<Integer> lst_c =new ArrayList<>();
		lst_c.add(7);
		lst_c.add(8);
		lst_c.add(9);
		
		List<List<Integer>> lst = new ArrayList<>();
		lst.add(lst_a);
		lst.add(lst_b);
		lst.add(lst_c);
		
		lst.stream()
		.flatMap(l -> l.stream())
		.map(i -> "num-"+i)
		.forEach(s -> System.out.println(s));
		
		
		//grouping
		Map<Object, List<Integer>> map = lst.stream()
		.flatMap(l -> l.stream())
		.collect(Collectors.groupingBy(i -> i<4));
		
		System.out.println(map);
		
		//sort
		System.out.println("::    SORT     ::");
		Optional<String> min=lst.stream()
				.flatMap(l -> l.stream())
				.map(i -> "num-"+i)
				.peek(s -> System.out.println(s))
				.min(Comparator.naturalOrder());
				
				System.out.println(min.get());
	}
}
