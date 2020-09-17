package com.sarafu.pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.sarafu.base.TestBase;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductHomePage extends TestBase {
	
	public ProductHomePage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindAll(value = {@AndroidBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")},priority=1)
	private List<AndroidElement> productList;

	public List<AndroidElement> getProductList() {
		return productList;
	}
	
}
