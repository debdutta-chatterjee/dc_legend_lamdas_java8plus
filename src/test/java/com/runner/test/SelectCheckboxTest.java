package com.runner.test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.lambda.checkboxtable.SelectionRules;
import com.runner.base.BaseTest;

public class SelectCheckboxTest extends BaseTest
{

	@Test
	public void selectCheckbox()
	{
		driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");
		List<WebElement> rows = driver.findElements(By.cssSelector("table tr"));
		
		rows.stream()
		.skip(1)
		.map(e -> e.findElements(By.tagName("td")))
		.filter(e -> e.size()>=4)
		.filter(e -> SelectionRules.getRules("gender").test(e.get(1), "male"))
		.peek(e -> System.out.println("peek1"+e.get(0).getText()))	
		.filter(e -> SelectionRules.getRules("name").test(e.get(0), "John"))
		.peek(e -> System.out.println("peek2"+e.get(0).getText()))	
		.filter(e -> SelectionRules.getRules("country").test(e.get(2), "USA"))
		.peek(e -> System.out.println("peek3"+e.get(0).getText())).peek(e -> System.out.println(e.get(0).getText()))		
		.map(e -> e.get(3))
		.map(e -> e.findElement(By.tagName("input")))
		.forEach(e -> e.click());
		
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
	}	
}
