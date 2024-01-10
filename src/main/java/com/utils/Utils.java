package com.utils;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {

	// Store all commonly used methods for method reusablity purpose

	public static void clickElementWithJavascript(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void windowhandles(WebElement element, WebDriver driver) {
		String parentwindow = driver.getWindowHandle();
		element.click();
//		driver.findElement(By.id("newWindowBtn")).click();
		Set<String> ids = driver.getWindowHandles();

		for (String windowids : ids) {
			System.out.println(windowids);

			if (!parentwindow.equals(windowids)) {
				driver.switchTo().window(windowids);
				driver.manage().window().maximize();
				
			}
		}
	}

}
