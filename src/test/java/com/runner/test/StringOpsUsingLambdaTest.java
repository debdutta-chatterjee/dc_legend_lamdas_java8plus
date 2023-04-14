package com.runner.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class StringOpsUsingLambdaTest 
{

	@Test
	public void stringOpsAssignments()
	{
		Path path = Paths.get("./Names.txt");
        try {
			List<String> list = Files.readAllLines(path);
			
			// create a list of names which start with C and contains 's' in it
			List<String> lst_filter1=list.stream()
			.filter(s -> s.startsWith("C"))
			.filter(s -> s.contains("s"))
			.collect(Collectors.toList());
			
			System.out.println("names which start with C and contains 's' in it "+lst_filter1);
			
			// print the total number of chars for all the names starting with M
			int length= list.stream()
					.filter(s -> s.startsWith("M"))
					.map(s ->s.length())
					.mapToInt(i -> i)
					.sum();
					
					System.out.println("total number of chars for all the names starting with M "+length);
					
			
			// Jo-Ann => Jo Ann
	        // find the names containing - in it and replace it with a space; collect them into a list
			lst_filter1=list.stream()
							.filter(s -> s.contains("-"))
							.map(s -> s.replaceAll("-"," "))
							
							.collect(Collectors.toList());
							
							System.out.println("find the names containing - in it and replace it with a space "+lst_filter1);
			
			// find the name which has most number of chars
							Optional<Integer> len =list.stream()
										.map(s -> s.length())
										.max(Comparator.naturalOrder());
							System.out.println("find the name which has most number of chars "+len.get());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
