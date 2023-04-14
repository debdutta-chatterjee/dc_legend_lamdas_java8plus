package com.lambda.checkboxtable;

import java.util.Map;
import java.util.HashMap;
import java.util.function.BiPredicate;
import org.openqa.selenium.WebElement;

public class SelectionRules 
{
	private static BiPredicate<WebElement,String> genderRule = (e,s) -> e.getText().equalsIgnoreCase(s);
	private static BiPredicate<WebElement,String> NameRule = (e,s) -> e.getText().equalsIgnoreCase(s);
	private static BiPredicate<WebElement,String> CountryRule = (e,s) -> e.getText().equalsIgnoreCase(s);
	
	private static Map<String,BiPredicate<WebElement,String>> map = new HashMap<>();
	
	static
	{
		map.put("gender", genderRule);
		map.put("name", NameRule);
		map.put("country", CountryRule);
	}
	
	public static BiPredicate<WebElement, String> getRules(String rule)
	{
		return map.get(rule);
	}
	
}
