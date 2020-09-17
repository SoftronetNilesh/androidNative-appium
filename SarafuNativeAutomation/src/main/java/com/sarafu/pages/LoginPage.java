package com.sarafu.pages;

import org.openqa.selenium.support.PageFactory;

import com.sarafu.base.TestBase;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends TestBase {
	
	public LoginPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
	private AndroidElement countryListTab;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText")
	private AndroidElement searchCountry;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
	private AndroidElement resultCountry;

	@AndroidFindBy(xpath="//android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView")
	private AndroidElement closeCountrySelectModal;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[1]")
	private AndroidElement userName;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[2]")
	private AndroidElement password;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]")
	private AndroidElement signIn;

	@AndroidFindBy(xpath="//android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[4]")
	private AndroidElement userNameValidationMsg;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[7]")
	private AndroidElement passwordValidationMsg;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")
	private AndroidElement AlertMsg;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup")
	private AndroidElement removeAlert;
	
	public AndroidElement getUserNameValidationMsg() {
		return userNameValidationMsg;
	}

	public AndroidElement getPasswordValidationMsg() {
		return passwordValidationMsg;
	}

	public AndroidElement getAlertMsg() {
		return AlertMsg;
	}

	public AndroidElement getRemoveAlert() {
		return removeAlert;
	}

	public AndroidElement getCountryListTab() {
		return countryListTab;
	}

	public AndroidElement getSearchCountry() {
		return searchCountry;
	}

	public AndroidElement getResultCountry() {
		return resultCountry;
	}

	public AndroidElement getCloseCountrySelectModal() {
		return closeCountrySelectModal;
	}

	public AndroidElement getUserName() {
		return userName;
	}

	public AndroidElement getPassword() {
		return password;
	}

	public AndroidElement getSignIn() {
		return signIn;
	}

}
