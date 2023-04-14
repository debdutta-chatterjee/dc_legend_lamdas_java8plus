package com.runner.test;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.lambda.weblinks.LinkRules;
import com.runner.base.BaseTest;
import com.util.WebResponseUtil;

public class BrokenLinkTest extends BaseTest
{
	
	
	@Test
	public void googleBrokenLinktest()
	{
		driver.get("https://google.com");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		long start = System.currentTimeMillis();
		
		System.out.println
		( 		
				links.stream()
				.parallel()
				.filter(e -> LinkRules.getAllrules().get(0).test(e))
				.filter(e -> LinkRules.getAllrules().get(1).test(e))
				.map(e -> e.getAttribute("href"))
				.filter(url -> WebResponseUtil.getResponseCode(url)==200)
				//.collect(Collectors.toList())
				.count()
		);
		
		long end = System.currentTimeMillis();
		System.out.println("Time taken::"+ (end-start));
	}
	
	 
}
