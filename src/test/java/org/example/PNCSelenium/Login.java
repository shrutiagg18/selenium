/* package org.example.PNCSelenium;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import pages.LoginPageObject;
import utility.WebDriverFactory;

public class Login
{

	private WebDriver driver;

	@Test(priority=2,dataProvider="usernameandpassword",description="This test case will run twice")
	public void login(String username, String password) 
	{
		driver.findElement(By.linkText("sign-in")).click();
		LoginPageObject.uname.clear();
		LoginPageObject.uname.sendKeys(username);
		LoginPageObject.pass.clear();
		LoginPageObject.pass.sendKeys(password);
		LoginPageObject.login_button.click();
	}

	@DataProvider(name= "usernameandpassword")
	public String[][] credentials()
	{
		return new String[][]
				{
			new String[] { "invalidUN","invalidPW" },
			new String[] {"username1","password1"}
				};
	}
	
	@BeforeTest
	public void beforeTest() 
	{
		driver = WebDriverFactory.createDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com");
		PageFactory.initElements(driver, LoginPageObject.class);
	}
	@AfterTest
	public void afterTest() 
	{

	}

}    */
