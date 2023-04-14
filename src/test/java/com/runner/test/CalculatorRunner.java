package com.runner.test;

import org.testng.annotations.Test;

import com.lambda.calculator.SimpleCalculator;


public class CalculatorRunner 
{
	@Test
	public void testCalculator()
	{
		SimpleCalculator calc= new SimpleCalculator();
		
		System.out.println
		(
				calc.calculate("+", 1, 5)				
		);
		
		//add new operation
		calc.addOperation("%", (a,b) -> a%b);
		calc.addOperation("^", (a,b) -> (int) Math.pow(a, b));
		
		System.out.println
		(
				calc.calculate("%", 100, 55)
		);
		
		System.out.println
		(
				calc.calculate("^", 5, 2)
		);
		
	}
}


