package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.CommonFunctions;
import com.utilities.StaticVariables;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.AfterClass;

public class FB_Login extends StaticVariables {

	Locators loc = new Locators();
	CommonFunctions cfn = new CommonFunctions();

	@BeforeClass
	public void beforeClass() {

		cfn.chromeBrowserLaunch();
	}

	@Test
	public void fblogin() throws Exception {

		// Read the test data from property file
		// CLASSNAME referenceName = new CLASSNAME();
		Properties p = new Properties();
		FileInputStream fi = new FileInputStream("./src/test/resources/testdata/td.properties");
		p.load(fi);
		// Type the website URL
		driver.get(p.getProperty("FB_URL"));
		cfn.sendKeyByAnyLocator(loc.FBLOGIN_USERNAME_EDITBOX, p.getProperty("FB_USERNAME"));
		cfn.sendKeyByAnyLocator(loc.FBLOGIN_PASSWORD_EDITBOX, p.getProperty("FB_PASSWORD"));
		cfn.clickByAnyLocator(loc.FBLOGIN_LOGIN_BUTTON);

	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
