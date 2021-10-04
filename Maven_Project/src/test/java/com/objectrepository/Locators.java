package com.objectrepository;

import org.openqa.selenium.By;

public class Locators {
	//Here we will store the Application Locators!
	public final By FBLOGIN_USERNAME_EDITBOX = By.id("email");
	public final By FBLOGIN_PASSWORD_EDITBOX = By.id("pass");
	public final By FBLOGIN_LOGIN_BUTTON = By.name("login");
	
	public final By FRAME_ZONAL_LINK = By.name("P-24Alist");
    public final By FRAME_LASTUPDATEDATE_TEXT = By.xpath("//body[1]/table[1]/tbody[1]/tr[8]/td[2]/span[1]");
    
    public final By FORMS_AGREE_POPUP = By.id("tgbgdpr-overlay-agree");
    public final By FORMS_DOWNLOAD_CLICK = By.xpath("//*[text()='Download']");
    
  //Applevacation locators
  	  public final By Leaving_From = By.id("orgAC_value");
      public final By Arrived_To = By.id("desAC_value");
      public final By Search_Button = By.id("scc_rt_submit");
      
      
      
      
  //PlatformQ Education
      public final By productMenu = By.xpath("//div[contains(text(),'Products')]");      
    
}
