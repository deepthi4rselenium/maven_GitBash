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
import org.testng.annotations.AfterClass;

public class WomenStrore extends StaticVariables {

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
		cfn.openURL("http://automationpractice.com/index.php?id_category=3&controller=category");
		int rannum = cfn.randomNumber(7);
		System.out.println("Random Number is:" + rannum);
		cfn.moveToOnElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+rannum+"]/div/div[1]/div/a[1]/img"));
		cfn.implicitwait(10);
		cfn.clickByAnyLocator(By.xpath("//*[@id=\"center_column\"]/ul/li["+rannum+"]/div/div[2]/div[2]/a[1]/span"));
		
		
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		cfn.takeScreenshot("WomenStrore");
	}

	//@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
