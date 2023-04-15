package com.runner.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Optional;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class Java11Test 
{
	@Test
	public void java11Test() throws IOException
	{
		//fileops
		Files.writeString(Paths.get("./testfile.txt"),"test message \n test 2\n");
		Files.writeString(Paths.get("./testfile.txt"),"test message3 \n test 4",StandardOpenOption.APPEND);
		
		var stdata= Files.readString(Paths.get("./testfile.txt"));
		
		stdata.lines().forEach(System.out::println);
		
		//string ops
		var str ="      \n     ";
		System.out.println(str.isEmpty());
		
		var format ="*";
		System.out.println(format.repeat(10));
		
		var bulky = "  \t   gghh     \n ";
		System.out.println(bulky.stripTrailing());
		
		//optional isempty
		Optional<Integer> op= Stream.of(1,2,3,4,5)
				.filter(i -> i>6)
				.findAny();
		
		System.out.println(op.isEmpty());
		
	}

}
