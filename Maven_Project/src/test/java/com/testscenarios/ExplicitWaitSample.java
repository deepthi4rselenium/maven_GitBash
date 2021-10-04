package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.CommonFunctions;
import com.utilities.StaticVariables;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class ExplicitWaitSample extends StaticVariables {

	Locators loc = new Locators();
	CommonFunctions cfn = new CommonFunctions();

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(@Optional("Chrome") String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {
			cfn.chromeBrowserLaunch();

		} else if (browserName.equalsIgnoreCase("Edge")) {
			cfn.edgeBrowserLaunch();

		} else if (browserName.equalsIgnoreCase("Firefox")) {
			cfn.firefoxBrowserLaunch();

		} else {
			System.out.println("please give valid browser name");
		}

	}

	@Test
	public void f() throws Exception {
		Properties p = new Properties();
		FileInputStream fi = new FileInputStream("./src/test/resources/testdata/td.properties");
		p.load(fi);
		
		/******** Develop the code from here ******************/
		cfn.openURL("https://demoqa.com/alerts");
		cfn.clickByAnyLocator(By.id("timerAlertButton"));
		//explicit wait
		WebDriverWait ww = new WebDriverWait(driver, 50);
		ww.until(ExpectedConditions.alertIsPresent());
		cfn.alertHandleByAccept();
		
		driver.navigate().to("https://www.seleniumeasy.com/test/generate-file-to-download-demo.html");
		//type something on editbox
		cfn.sendKeyByAnyLocator(By.id("textbox"), "fgfdgg");
		ww.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("create"))));
		System.out.println("********* Generate File Button Activated ***********");
		
	}

	@AfterMethod
	public void afterMethod(ITestResult res) throws Exception {
		//cfn.takeScreenshot("Name of the class");
		cfn.screenshotwithstatus(res);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
