package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.CommonFunctions;
import com.utilities.StaticVariables;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Frames extends StaticVariables {
	Locators loc = new Locators();
	CommonFunctions cfn = new CommonFunctions();

	@BeforeClass
	public void beforeClass() {
		cfn.chromeBrowserLaunch();
	}

	@Test
	public void frames() throws Exception {

		Properties p = new Properties();
		FileInputStream fi = new FileInputStream("./src/test/resources/testdata/td.properties");
		p.load(fi);

		cfn.openURL((p.getProperty("FRAMES_URL")));
		// To move to the Frame/IFrame
		driver.switchTo().defaultContent();
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		int numberOfFrames = 0;
		numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of frames on the page are: " + numberOfFrames);
		//driver.switchTo().frame(1);
		// driver.switchTo().frame("MENU");
 
		// click on webelement
		//cfn.clickByAnyLocator(loc.FRAME_ZONAL_LINK);
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		cfn.takeScreenshot("Frames");
	}

	// @AfterClass
	// public void afterClass() {
	// driver.quit();
	// }
}
