package com.lambda.calculator;
import java.util.Map;
import java.util.HashMap;

public class SimpleCalculator 
{
	private static CalculatorOperation addition = (num1,num2) -> num1+num2;
	private static CalculatorOperation substraction = (num1,num2) -> num1-num2;
	private static CalculatorOperation multiplication = (num1,num2) -> num1*num2;
	private static CalculatorOperation division = (num1,num2) -> num1/num2;
	
	private static Map <String, CalculatorOperation> operationMap = new HashMap<>();
	
	static 
	{
		operationMap.put("+", addition);
		operationMap.put("-", substraction);
		operationMap.put("*", multiplication);
		operationMap.put("/", division);
	}
	
	public void addOperation(String symbol,  CalculatorOperation newOp)
	{
		operationMap.put(symbol, newOp);
	}
	
	public int calculate(String operation, int num1, int num2)
	{
		return operationMap.get(operation).calculate(num1, num2);
	}
}
