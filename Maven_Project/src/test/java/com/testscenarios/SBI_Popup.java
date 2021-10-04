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

public class SBI_Popup extends StaticVariables {

	Locators loc = new Locators();
	CommonFunctions cfn = new CommonFunctions();

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(@Optional("Edge") String browserName) {

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
		cfn.openURL("https://retail.onlinesbi.com/retail/login.htm");
		//Click on CONTINUE TO LOGIN Link
		cfn.clickByAnyLocator(By.linkText("CONTINUE TO LOGIN"));
		cfn.implicitwait(10);
		//Click on New User
		cfn.clickByAnyLocator(By.partialLinkText("Register "));
		//Click on alert
		cfn.alertHandleByAccept();
		//Switch to popup page and do click on Next button
		cfn.navigateToPopupWindow();
		//Click on Next Button on popup window(Child)
		cfn.clickByAnyLocator(By.name("nextStep"));
		
	}

	@AfterMethod
	public void afterMethod(ITestResult res) throws Exception {
		//cfn.takeScreenshot("SBI_Popup");
		cfn.screenshotwithstatus(res);
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
