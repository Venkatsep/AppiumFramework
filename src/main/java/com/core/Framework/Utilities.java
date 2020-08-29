package com.core.Framework;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Utilities extends BaseClass {

	WebElement element;
	WebDriver webDriver;

	public void clickOnElementUsingXpath(String elementLocator) {
		try {

			System.out.println(elementLocator);
			element = driver.findElement(By.xpath(elementLocator));
			element.click();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void isElementPresent(String elementLocator) throws Exception {
		try {
			// waitForSpecificElement(elementLocator, 40);
			System.out.println(elementLocator);
			boolean element = driver.findElement(By.xpath(elementLocator)) != null;
			if (element == true) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return;
		}
	}

	public void isElementPresentID(String elementLocator) throws Exception {
		try {
			// waitForSpecificElement(elementLocator, 40);
			System.out.println(elementLocator);
			boolean element = driver.findElement(By.id(elementLocator)) != null;
			if (element == true) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return;
		}
	}
	public void clickOnElementUsingID(String elementLocator) {
		try {
			System.out.println(elementLocator);
			element = driver.findElement(By.id(elementLocator));
			element.click();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void clickOnElementUsingClassName(String elementLocator) {
		try {
			System.out.println(elementLocator);
			element = driver.findElement(By.className(elementLocator));
			element.click();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void waitForXpathElement(String elementLocator) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementLocator)));
			Assert.assertTrue(true);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	public void waitForIDElement(String elementLocator) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementLocator)));
			Assert.assertTrue(true);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	public void sendKeysToTextBox(String elementLocator) {
		try {
			element.sendKeys(elementLocator);
		//	driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).perform();


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void sendUserNameKeysToTextBox(String elementLocator) {
		try {
			element.sendKeys(elementLocator);
		//	driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
		

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void clearTextBox() {
		try {
			element.clear();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


	public void scrollAtPositon(int startx, int starty, int endx, int endy) {
		try {

			AndroidTouchAction touch= new AndroidTouchAction(driver);
			touch.longPress(PointOption.point(startx,starty)).moveTo(PointOption.point(endx,endy)).release().perform();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}

	public void swipeusingdownCoordinates() throws Exception {
		try {
			Dimension windowSize = driver.manage().window().getSize();
			int startx=(int) (windowSize.width /2);
			int starty=(int) (windowSize.height *0.80);
			int endy=(int) (windowSize.height *0.70);		
			scrollAtPositon(startx, starty, startx, endy);

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
			throw e;
		}
	}

	public void swipeusingUpCoordinates() throws Exception {
		try {
			Dimension windowSize = driver.manage().window().getSize();
			int startx=(int) (windowSize.width * 0.50);
			int starty=(int) (windowSize.height *0.30);
			double endValue=windowSize.height*(0.80);
			int endy=(int) (windowSize.height *0.70);		
			scrollAtPositon(startx, starty, startx, endy);
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
			throw e;
		}
	}

}
