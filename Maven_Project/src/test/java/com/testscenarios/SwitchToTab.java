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
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class SwitchToTab extends StaticVariables {

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
          cfn.openURL("https://www.toyota.co.uk/");
          cfn.implicitwait(10);
          cfn.clickByAnyLocator(By.id("tgbgdpr-overlay-agree"));
          cfn.implicitwait(10);
          cfn.loopAllFramesForElement(By.xpath("(//*[contains(@class,'calculator')])[9]"));
          cfn.clickByAnyLocator(By.xpath("(//*[contains(@class,'calculator')])[9]"));
          cfn.implicitwait(10);
          ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
          System.out.println("allTabs.size() is :" +allTabs.size());
          Thread.sleep(5000);
          //Switch to new tab
          //cfn.switchToNewTab(1);
          driver.switchTo().window(allTabs.get(1));
          //Do Actions on child window
          Thread.sleep(5000);
          Select carModel = new Select(driver.findElement(By.id("codeweaversModels")));
          carModel.selectByVisibleText("Aygo");
          Thread.sleep(5000);
          //To close the child tab
          driver.close();
          //Switch to main tab
          driver.switchTo().window(allTabs.get(0));
          //click on UsedCars Link on Parent Page
          cfn.clickByAnyLocator(By.xpath("//a[contains(text(),'Used cars')]"));
		
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		cfn.takeScreenshot("SwitchToTab");
	}

	//@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
