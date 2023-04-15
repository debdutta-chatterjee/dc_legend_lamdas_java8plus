package com.runner.test;

import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class Java10Test 
{
	@Test
	public void java10Test()
	{
		var lst = List.of(1,2,3,4);
		
		var lst_new = lst.stream()
		.map(i->i+2)
		.collect(Collectors.toUnmodifiableList());
		
		System.out.println(lst_new);
	}

}
