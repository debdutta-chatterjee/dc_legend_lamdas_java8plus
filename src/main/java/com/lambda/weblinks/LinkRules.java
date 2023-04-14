package com.lambda.weblinks;

import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;

public class LinkRules 
{
	private static Predicate<WebElement> isBlank = we -> we.getText().length() > 1;
	private static Predicate<WebElement> hasSpace = we -> !we.getText().contains(" ");
	public static BiPredicate<WebElement,String> containsString = (we,s) -> we.getText().toLowerCase().contains(s.toLowerCase());
	
	public static List<Predicate<WebElement>> getAllrules()
	{
		List<Predicate<WebElement>> rules = new ArrayList<>();
		
		rules.add(isBlank);
		rules.add(hasSpace);
		return rules;
	}
	
}
