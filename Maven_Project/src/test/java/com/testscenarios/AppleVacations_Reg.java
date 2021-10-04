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

public class AppleVacations_Reg extends StaticVariables {

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
		cfn.openURL(p.getProperty("AppleVacations_URL"));
		cfn.implicitwait(50);
		driver.findElement(By.id("orgAC_value")).sendKeys("lo");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"orgAC_dropdown\"]/div[4]/div")).click();
		driver.findElement(By.id("desAC_value")).sendKeys("lo");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"desAC_dropdown\"]/div[4]/div")).click();
		//choose date
		driver.findElement(By.id("depDT_value")).click();
		driver.findElement(By.xpath("(//table[@role='grid'])[2]/tbody/tr[4]/td[6]")).click();
		//choose return date
		driver.findElement(By.id("retDT_value")).click();
		cfn.implicitwait(20);
		driver.findElement(By.xpath("(//table[@role='grid'])[1]/tbody/tr[5]/td[7]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("scc_rt_submit")).click();
		
		
		
	}

	@AfterMethod
	public void afterMethod(ITestResult res) throws Exception {
		//cfn.takeScreenshot("AppleVacations");
		cfn.screenshotwithstatus(res);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
