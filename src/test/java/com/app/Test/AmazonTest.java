package com.app.Test;


import org.testng.annotations.Test;

import com.app.Screen.AmazonPage;
import com.core.Framework.BaseClass;

import io.appium.java_client.AppiumDriver;

public class AmazonTest extends BaseClass{

	//Utilities utilis= new Utilities();
	@Test(description = "Validate Add 55 Inch TV and Checkout Feature")

	public void validateAddToCartFeature() throws Exception

	{	
		try {
	AppiumDriver<?> driver=capabilities();
     AmazonPage amazonPage=new AmazonPage();
     amazonPage.validateLaunchScreenUI();
   //  amazonPage.validateLoginFeature();
     amazonPage.validateDashboardScreen();
     amazonPage.validateSearchResult();
     amazonPage.getProductName();
     amazonPage.getPriceValue();
     amazonPage.clickOnProductBasedonIndex();
     amazonPage.useMYGeoLocation();
   amazonPage.swipeToFindAddCart();
     amazonPage.validateCartNumberIsChanged();
     amazonPage.validateCheckOutPage();
    
	}catch (Exception e) {
		// TODO: handle exception
		e.getMessage();
		throw e;
	}
	}
	}







