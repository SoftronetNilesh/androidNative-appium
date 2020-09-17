package com.sarafu.pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.sarafu.base.TestBase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DashBoard extends TestBase {

	public DashBoard() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]")
	private AndroidElement services;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[3]")
	private AndroidElement topCategories;
	
	@AndroidFindAll(value = {@AndroidBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")},priority=1)
	private List<AndroidElement> topCategoriesList;
	
	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private AndroidElement allowLocationAccess;
	
	@AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"Maskani, tab, 1 of 4\"]/android.widget.TextView")
	private AndroidElement tent;
	
	@AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"Bidhaa, tab, 2 of 4\"]/android.widget.TextView")
	private AndroidElement products;
	
	@AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"Arifa, tab, 3 of 4\"]/android.widget.TextView[2]")
	private AndroidElement notification;
	
	@AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"Oda, tab, 4 of 4\"]/android.widget.TextView[2]")
	private AndroidElement order;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
	private AndroidElement leftMenu;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[3]")
	private AndroidElement settings;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[10]")
	private AndroidElement logOut;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]")
	private AndroidElement confirmlogOut;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup")
	private AndroidElement settingsPanel;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]")
	private AndroidElement startScrollPoint;
	
	
	
	public AndroidElement getSettingsPanel() {
		return settingsPanel;
	}

	public AndroidElement getStartScrollPoint() {
		return startScrollPoint;
	}

	public AndroidElement getConfirmlogOut() {
		return confirmlogOut;
	}

	public AndroidElement getLogOut() {
		return logOut;
	}

	public AndroidElement getLeftMenu() {
		return leftMenu;
	}

	public AndroidElement getSettings() {
		return settings;
	}

	public AndroidElement getServices() {
		return services;
	}

	public AndroidElement getTopCategories() {
		return topCategories;
	}

	public List<AndroidElement> getTopCategoriesList() {
		return topCategoriesList;
	}

	public AndroidElement getAllowLocationAccess() {
		return allowLocationAccess;
	}

	public AndroidElement getTent() {
		return tent;
	}

	public AndroidElement getProducts() {
		return products;
	}

	public AndroidElement getNotification() {
		return notification;
	}

	public AndroidElement getOrder() {
		return order;
	}

	
	
}
