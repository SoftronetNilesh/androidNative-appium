package com.sarafu.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sarafu.base.TestBase;
import com.sarafu.pages.DashBoard;
import com.sarafu.pages.HomePage;
import com.sarafu.pages.LoginPage;
import com.sarafu.utilities.Helpers;
import com.sarafu.utilities.LoggerHelper;

import io.appium.java_client.functions.ExpectedCondition;

public class LoginValidation extends TestBase {

	public LoginValidation() {
		super();
	}

	HomePage home;
	LoginPage loginpage;
	DashBoard dashBoard;
	private final static Logger log = LoggerHelper.getLogger(LoginValidation.class);

	@BeforeTest
	public void baseSetup() throws MalformedURLException {
		try {
			initialisation();
		} catch (Exception e) {
			log.error("Issue with app setup");
			e.printStackTrace();
		}

	}

	@BeforeMethod
	public void setupObjects() {
		home = new HomePage();
		dashBoard = new DashBoard();
		loginpage = new LoginPage();
	}

	@Test(dataProvider = "loginValidUser", priority = 0)
	public void LoginValidationWithValidData(String countryName, String userName, String password, String status)
			throws MalformedURLException, InterruptedException {
		System.out.println(countryName);

		try {

			Helpers.waitTillElementClickable(home.getIngiaTab(), "Signin button");

			home.getIngiaTab().click();
			log.info("Clicked on Sign in to continue");

			Helpers.waitTillElementClickable(loginpage.getCountryListTab(), "Country list button");

			log.info("Navigated to Sign in Page");
			loginpage.getCountryListTab().click();
			Helpers.waitTillElementVisible(loginpage.getSearchCountry(), "Country List");

			log.info("Clicked on country list");
			loginpage.getSearchCountry().sendKeys(countryName);
			log.info("Searching for specific country");
			Helpers.waitTillElementClickable(loginpage.getResultCountry(), "country Name");

			loginpage.getResultCountry().click();
			log.info("Selected searched country from list");
			Helpers.waitTillElementVisible(loginpage.getUserName(), "UserName ");

			loginpage.getUserName().sendKeys(userName);
			log.info("Username Value inserted");
			Helpers.waitTillElementVisible(loginpage.getPassword(), "Password");

			loginpage.getPassword().sendKeys(password);
			log.info("password value inserted");
			loginpage.getSignIn().click();
			log.info("Clicked on sign in button");
			Helpers.waitTillElementClickable(dashBoard.getAllowLocationAccess(), "Location Access button");
			dashBoard.getAllowLocationAccess().click();
			log.info("Location access is allowed");
			Helpers.waitTillElementClickable(dashBoard.getLeftMenu(), "Left Menu");
			dashBoard.getLeftMenu().click();
			log.info("Clicked on left menu");
			Helpers.waitTillElementClickable(dashBoard.getSettings(), "settings Button");
			dashBoard.getSettings().click();
			log.info("Clicked on setting");

			Helpers.waitTillElementVisible(dashBoard.getStartScrollPoint(), "Scroll Point");
			/*
			 * log.info("Scrolled to logout button");
			 * Helpers.scrolltoElement(dashBoard.getStartScrollPoint(),
			 * dashBoard.getLogOut());
			 */

			Helpers.scrolltoElement("ONDOKA");;

			Helpers.waitTillElementVisible(dashBoard.getLogOut(), "Log out button");
			log.info("Scrolled to webelement");

			dashBoard.getLogOut().click();

			log.info("Clicked on logout option");
			
			Helpers.waitTillElementClickable(dashBoard.getConfirmlogOut(), "Logout confirmation message");
			dashBoard.getConfirmlogOut().click();
			log.info("Confirming logout");
			Helpers.waitTillElementVisible(loginpage.getUserName(), "Username");

		} catch (Exception e) {
			log.info(e.getMessage());
		}

	}

	@Test(dataProvider = "loginInvalidUser", priority = 1, dependsOnMethods = "LoginValidationWithValidData")
	public void LoginValidationWithInvalidData(String countryName, String userName, String password, String status,
			String message) throws MalformedURLException, InterruptedException {

		try {
/*			Helpers.waitTillElementClickable(home.getIngiaTab(), "Signin button");

			home.getIngiaTab().click();
			log.info("Clicked on Sign in to continue");*/
			
			Helpers.waitTillElementClickable(loginpage.getCountryListTab(), "Country list button");

			log.info("Navigated to Sign in Page");
			loginpage.getCountryListTab().click();
			Helpers.waitTillElementVisible(loginpage.getSearchCountry(), "Country List");

			log.info("Clicked on country list");
			loginpage.getSearchCountry().sendKeys(countryName);
			log.info("Searching for specific country");
			Helpers.waitTillElementClickable(loginpage.getResultCountry(), "country Name");

			loginpage.getResultCountry().click();
			log.info("Selected searched country from list");
			Helpers.waitTillElementVisible(loginpage.getUserName(), "UserName ");

			loginpage.getUserName().sendKeys(userName);
			log.info("Username Value inserted");
			Helpers.waitTillElementVisible(loginpage.getPassword(), "Password");

			loginpage.getPassword().sendKeys(password);
			log.info("password value inserted");
			loginpage.getSignIn().click();
			log.info("Clicked on sign in button");

		} catch (Exception e) {
			log.info(e.getMessage());
		}

	}

	@DataProvider(name = "loginValidUser")
	public String[][] loginValidUser() throws IOException {
		log.info("Reading data from Sheet sarafuValidTestdata");
		String[][] arrayObject = Helpers.getExcelData(

				System.getProperty("user.dir") + "\\src\\test\\java\\com\\sarafu\\testdata\\Sarafu.xls",
				"SarafuLoginValidTestData");
		return arrayObject;
	}

	@DataProvider(name = "loginInvalidUser")
	public String[][] loginInvalidUser() throws IOException {
		log.info("Reading data from Sheet sarafuValidTestdata");
		String[][] arrayObject = Helpers.getExcelData(

				System.getProperty("user.dir") + "\\src\\test\\java\\com\\sarafu\\testdata\\Sarafu.xls",
				"SarafuLoginInvalidTestData");
		return arrayObject;
	}

}
