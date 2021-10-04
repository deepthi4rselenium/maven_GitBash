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

public class DragAndDrop extends StaticVariables {

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
		cfn.openURL("https://jqueryui.com/droppable/");
		cfn.loopAllFramesForElement(By.xpath("//p[contains(text(),'Drag me to my target')]"));
		cfn.loopAllFramesForElement(By.xpath("//p[contains(text(),'Drop here')]"));
		cfn.implicitwait(10);
		cfn.dragandDrop(By.xpath("//p[contains(text(),'Drag me to my target')]"), By.xpath("//p[contains(text(),'Drop here')]"));
		
		
		
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		cfn.takeScreenshot("DragAndDrop");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
