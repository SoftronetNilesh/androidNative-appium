package com.sarafu.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.*;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sarafu.base.TestBase;
import com.sarafu.testcases.LoginValidation;

public class Helpers extends TestBase {

	private final static Logger log = LoggerHelper.getLogger(Helpers.class);

	public Helpers() {
		super();
	}

	public static String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();

			arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];

			for (int i = 1; i < totalNoOfRows; i++) {

				for (int j = 0; j < totalNoOfCols; j++) {
					arrayExcelData[i - 1][j] = sh.getCell(j, i).getContents();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}

		return arrayExcelData;

	}

	public static void waitTillElementVisible(WebElement element, String elementName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			log.info("Waited till " + elementName + " is visible ");
		} catch (Exception e) {
			log.error(e.getMessage());

		}
	}

	public static void waitTillElementClickable(WebElement element, String elementName) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			log.info("Waited till " + elementName + " is visible ");
		} catch (Exception e) {
			log.error(e.getMessage());

		}
	}

	public static void waitTillElementSelectable(WebElement element, String elementName) {
		try {
			wait.until(ExpectedConditions.elementToBeSelected(element));
			log.info("Waited till " + elementName + " is visible ");
		} catch (Exception e) {
			log.error(e.getMessage());

		}
	}

	public static void scroll() {

	      int  x = driver.manage().window().getSize().width / 2;
	      int start_y = (int) (driver.manage().window().getSize().height * 0.2);
	      int end_y = (int) (driver.manage().window().getSize().height * 0.8);
	        TouchAction dragNDrop = new TouchAction(driver)
	                        .press(PointOption.point(x,start_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
	                        .moveTo(PointOption.point(x, end_y))
	                        .release();
	        dragNDrop.perform();

	}

	public static void scrolltoElement(String text) {

		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + text + "\").instance(0));"));
	}

}
