package com.sarafu.pages;

import org.openqa.selenium.support.PageFactory;

import com.sarafu.base.TestBase;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends TestBase {
	
	public HomePage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]")
	private AndroidElement ingiaTab;

	public AndroidElement getIngiaTab() {
		return ingiaTab;
	}

}
