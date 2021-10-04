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
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class WebTable_Demo extends StaticVariables {

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
		cfn.openURL(p.getProperty("WebTable_URL"));
		cfn.clickByAnyLocator(By.xpath("//table/tbody/tr[2]/td[5]"));
		Thread.sleep(2000);
		cfn.sendKeyByAnyLocator(By.name("fname"), "Deepthi");
		cfn.sendKeyByAnyLocator(By.id("ln"), "E");
		cfn.sendKeyByAnyLocator(By.id("mn"), "dhjd");
		cfn.clickByAnyLocator(By.id("up"));
		
	}

	@AfterMethod
	public void afterMethod(ITestResult res) throws Exception {
		//cfn.takeScreenshot("WebTable_Demo");
		cfn.screenshotwithstatus(res);
	}

	//@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
