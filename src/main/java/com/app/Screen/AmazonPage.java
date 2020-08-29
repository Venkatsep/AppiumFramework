package com.app.Screen;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.core.Framework.Utilities;
import com.core.Framework.BaseClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSBy;

// All th objects belonging to one page will be defined in java class
public class AmazonPage<E> extends BaseClass {
	private Utilities utils = new Utilities();
	Properties prop = new Properties();
	private WebElement element;
	private String amazonLogo = "com.amazon.mShop.android.shopping:id/sso_splash_logo";
	private String alreadyCustomer = "com.amazon.mShop.android.shopping:id/sign_in_button";
	private String newCustomer = "com.amazon.mShop.android.shopping:id/new_user";
	private String skipSignIn = "com.amazon.mShop.android.shopping:id/skip_sign_in_button";
	private String continueButton = "com.amazon.mShop.android.shopping:id/sso_continue";
	private String helloLabel = "com.amazon.mShop.android.shopping:id/sso_welcome";
	private String emailBox = "//android.widget.EditText";
	private String continueEmailButtonXpath = "//android.widget.Button[@text='Continue']";
	private String usernameLabel = "//android.webkit.WebView/android.view.View/android.widget.TextView[1]";
	private String passwordBox = "//android.widget.EditText[@text='Amazon password']";
	private String passwordLoginButton ="//android.widget.Button[@text='Login']";
private String useMyGeoLocation="com.amazon.mShop.android.shopping:id/loc_ux_gps_auto_detect";
private String allowButton="com.android.packageinstaller:id/permission_allow_button";
	private String dashboardScreenMike = "com.amazon.mShop.android.shopping:id/voice_btn_icon";
	private String dashboardScreenLogo = "com.amazon.mShop.android.shopping:id/action_bar_home_logo";
	private String dashboardBurgerIcon = "com.amazon.mShop.android.shopping:id/action_bar_burger_icon";
	private String searchButton = "com.amazon.mShop.android.shopping:id/rs_search_src_text";
	private String resultsCount = "com.amazon.mShop.android.shopping:id/rs_results_count_text";
	private String getlistProductCount = "com.amazon.mShop.android.shopping:id/list_product_description_layout";
	private String getProductNameDescription = "com.amazon.mShop.android.shopping:id/item_title";
	private String getProductPrice = "com.amazon.mShop.android.shopping:id/rs_results_price";
	private String addToCart = "//android.widget.Button[@text='Add to Cart']";
	private String addToCartCount = "com.amazon.mShop.android.shopping:id/action_bar_cart_count";
	private String checkOutProductDescription = "//android.view.View[2]/android.view.View/android.view.View[3]/android.view.View";
	private String checkOutPrice = "//android.widget.ListView/android.view.View[1]";
	private String addressPage = "//android.view.View/android.view.View/android.view.View[2]/android.view.View[1]";
private  String getPriceProduct;
	private String getProductName;
	private String getPriceOfProduct;

	/**** Validate Launch Screen UI ****/
	public void validateLaunchScreenUI() throws Exception {

		try {
			utils.waitForIDElement(amazonLogo);
			utils.isElementPresentID(alreadyCustomer);
			utils.isElementPresentID(newCustomer);
			utils.isElementPresentID(skipSignIn);
			utils.clickOnElementUsingID(skipSignIn);
			utils.waitForIDElement(dashboardScreenLogo);

		} catch (Exception e) {

			e.getMessage();
			throw e;
		}
	}

	/**** Validate Login Feature ****/
	public void validateLoginFeature() throws Exception {

		try {
			utils.isElementPresent(emailBox);
			utils.clickOnElementUsingXpath(emailBox);
			utils.clearTextBox();
			Thread.sleep(3000);
			if(driver.findElementByXPath("//android.widget.RelativeLayout[1]/android.widget.TextView").isDisplayed()) {
			driver.navigate().back();
			}
			utils.sendKeysToTextBox(UserName);
			Thread.sleep(3000);
			utils.clickOnElementUsingXpath(continueEmailButtonXpath);
			utils.waitForXpathElement(passwordBox);
			String getusername = driver.findElement(By.xpath(usernameLabel)).getAttribute("text");
			Thread.sleep(3000);
			Assert.assertEquals(getusername.equalsIgnoreCase(UserName), true);
			utils.clickOnElementUsingXpath(passwordBox);
			Thread.sleep(3000);
			utils.sendUserNameKeysToTextBox(Password);
			utils.clickOnElementUsingXpath(passwordLoginButton);
			utils.waitForIDElement(dashboardScreenMike);
		} catch (Exception e) {

			e.getMessage();
			throw e;
		}
	}

	/**** Validate DashBoard Screen UI ****/
	public void validateDashboardScreen() throws Exception {

		try {
			utils.waitForIDElement(dashboardScreenLogo);
			utils.isElementPresentID(dashboardScreenLogo);
			utils.isElementPresentID(dashboardBurgerIcon);
			utils.isElementPresentID(searchButton);

		} catch (Exception e) {

			e.getMessage();
			throw e;
		}
	}

	/**** Validate Search Bar ****/
	public void validateSearchResult() throws Exception {

		try {
		
			utils.clickOnElementUsingID(searchButton);
			Thread.sleep(3000);
			
			utils.clickOnElementUsingXpath(emailBox);
			Thread.sleep(3000);
			utils.sendKeysToTextBox(TvDetails);
			utils.waitForIDElement(resultsCount);

		} catch (Exception e) {

			e.getMessage();
			throw e;
		}
	}

	/**** Validate Product Description ****/
	public void getProductName() throws Exception {

		try {

			WebElement element= driver.findElementsById("com.amazon.mShop.android.shopping:id/item_title").get(3);
	
			getProductName = element.getAttribute("text");
			Thread.sleep(3000);
			
		} catch (Exception e) {

			e.getMessage();
			throw e;
		}
	}

	/**** Validate Price Description ****/
	public void getPriceValue() throws Exception {

		try {

			WebElement element= driver.findElementsById("com.amazon.mShop.android.shopping:id/rs_results_price").get(3);
			getPriceOfProduct = element.getAttribute("content-desc");
		 getPriceProduct=getPriceOfProduct.replace("₹", "");
		 getPriceProduct=getPriceProduct.replace("   ", "");
			Thread.sleep(3000);

		} catch (Exception e) {

			e.getMessage();
			throw e;
		}
	}

	/**** Click on a product based on the index ****/
	public void clickOnProductBasedonIndex() throws Exception {

		try {

			WebElement element= driver.findElementsById("com.amazon.mShop.android.shopping:id/list_product_description_layout").get(3);
element.click();
			} catch (Exception e) {

			e.getMessage();
			throw e;
		}
	}

	/**** Swipe to bottom to find Add Cart Button ****/
	public void swipeToFindAddCart() throws Exception {

		try {
		
		for(int i=0; i<9; i++) {

			utils.swipeusingdownCoordinates();
/* if(driver.findElementByXPath("//android.widget.Button[@text='Add to Cart']").isDisplayed()){
	break;
} */
		}
			/*
		while(!driver.findElementByXPath("//android.widget.Button[@text='Add to Cart']").isDisplayed())
		{
				utils.swipeusingdownCoordinates();
			}  */

		}  
		catch (Exception e) {

			e.getMessage();
			throw e;
		}
	}
	/**** Validate Auto Pick Geo Location Number is Chan ****/
	public void useMYGeoLocation() throws Exception {

		try {
			utils.waitForIDElement(useMyGeoLocation);
	utils.clickOnElementUsingID(useMyGeoLocation);
	Thread.sleep(3000);
	if(driver.findElementById("com.android.packageinstaller:id/permission_allow_button").isDisplayed()) {
		utils.clickOnElementUsingID(allowButton);
	}

		}  
		catch (Exception e) {

			e.getMessage();
			throw e;
		}
	}



	/**** Validate Cart Number is Changed ****/
	public void validateCartNumberIsChanged() throws Exception {

		try {
			String getCartNumber = driver
					.findElement(By.id("com.amazon.mShop.android.shopping:id/action_bar_cart_count"))
					.getAttribute("text");
			Thread.sleep(3000);

			utils.clickOnElementUsingXpath(addToCart);
			Thread.sleep(3000);

			String getUpdatedCartNumber = driver
					.findElement(By.id("com.amazon.mShop.android.shopping:id/action_bar_cart_count"))
					.getAttribute("text");
			Thread.sleep(3000);
			Assert.assertEquals(getCartNumber.equalsIgnoreCase(getUpdatedCartNumber), false);
			Thread.sleep(3000);

		} catch (Exception e) {
			e.getMessage();
			throw e;
		}
	}

	/**** Validate Checkout Page Product Value ****/
	public void validateCheckOutPage() throws Exception {

		try {
			utils.clickOnElementUsingID(addToCartCount);
			validateProductDescriptionInCheckOutScreen();
			validatePriceDescriptionInCheckOutScreen();
			
		} catch (Exception e) {
			e.getMessage();
			throw e;
		}
	}

	/**** Click on a product Description in Check Out Screen ****/
	public void validateProductDescriptionInCheckOutScreen() throws Exception {

		try {
			List<E> listElements =  (List<E>) driver.findElementsByXPath("//android.view.View[2]/android.view.View/android.view.View[3]/android.view.View");
int getelementCount=listElements.size();
if(getelementCount == 1) {
	WebElement element =  driver.findElementsByXPath("//android.view.View[2]/android.view.View/android.view.View[3]/android.view.View").get(0);
	
	String getProductDescriptioninCheckoutPage = element.getAttribute("content-desc");
	String getProductDescriptioninCheckoutPageModified=getProductDescriptioninCheckoutPage.replace("...", "");
	Thread.sleep(3000);
	if(getProductName.contains(getProductDescriptioninCheckoutPageModified)) {
		Assert.assertTrue(true);

	} else {
		Assert.assertTrue(false);

	}
}
else {

	WebElement element =  driver.findElementsByXPath("//android.view.View[2]/android.view.View/android.view.View[3]/android.view.View").get(1);
	String getProductDescriptioninCheckoutPage = element.getAttribute("content-desc");
	Thread.sleep(3000);
	String getProductDescriptioninCheckoutPageModified=getProductDescriptioninCheckoutPage.replace("...", "");
	Thread.sleep(3000);
	System.out.println(""+getProductDescriptioninCheckoutPage);
	System.out.println(""+getProductName);
	Thread.sleep(3000);

	if(getProductName.contains(getProductDescriptioninCheckoutPageModified)) {
	Assert.assertTrue(true);

} else {
	Assert.assertTrue(false);

}

}
		} catch (Exception e) {

			e.getMessage();
			throw e;
		}
	}

	/**** Click on a product Description in Check Out Screen ****/
	public void validatePriceDescriptionInCheckOutScreen() throws Exception {

		try {
			List<E> listElements =  (List<E>)  driver.findElementsByXPath("//android.view.View[3]/android.widget.ListView/android.view.View[1]");
			int getelementCount=listElements.size();
			if(getelementCount == 1) {
			WebElement element =  driver
					.findElementsByXPath("//android.view.View[3]/android.widget.ListView/android.view.View[1]").get(0);
			String getProductPriceinCheckoutPage = element.getAttribute("text");
			String getProductDescriptioninCheckoutPageModified=getProductPriceinCheckoutPage.replace("   ", "");
			getProductDescriptioninCheckoutPageModified=getProductDescriptioninCheckoutPageModified.replace(".00", "");
			Thread.sleep(3000);
			if(getPriceProduct.contains(getProductDescriptioninCheckoutPageModified)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}
			else {
				WebElement element =  driver
						.findElementsByXPath("//android.view.View[3]/android.widget.ListView/android.view.View[1]").get(1);
				String getProductPriceinCheckoutPage = element.getAttribute("text");
				String getProductDescriptioninCheckoutPageModified=getProductPriceinCheckoutPage.replace("   ", "");
				getProductDescriptioninCheckoutPageModified=getProductDescriptioninCheckoutPageModified.replace(".00", "");

				Thread.sleep(3000);
				if(getPriceProduct.contains(getProductDescriptioninCheckoutPageModified)) {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
				}
				
			}
			catch (Exception e) {
			e.getMessage();
			throw e;
		}
	}

}
