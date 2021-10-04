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

import org.testng.annotations.AfterClass;

public class FramesSample extends StaticVariables {

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
		cfn.openURL(p.getProperty("FRAMES_URL"));
		cfn.loopAllFramesForElement(loc.FRAME_ZONAL_LINK);
		cfn.clickByAnyLocator(loc.FRAME_ZONAL_LINK);
		//get the data
		cfn.loopAllFramesForElement(loc.FRAME_LASTUPDATEDATE_TEXT);
		System.out.println(driver.findElement(loc.FRAME_LASTUPDATEDATE_TEXT).getText());
		
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		cfn.takeScreenshot("FramesSample");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
