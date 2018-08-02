package org.example.PNCSelenium;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.LoginPageObject;
import utility.WebDriverFactory;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class NewTest 
{
	
	private WebDriver driver; 
  @Test(priority=1)
  public void register() 
  {
	  driver.findElement(By.linkText("REGISTER")).click();
	  WebDriverWait wait = new WebDriverWait(driver,20);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.name("firstName")));
	  //Thread.sleep(6000);
	  driver.findElement(By.name("firstName")).sendKeys("Shruti");
	  driver.findElement(By.name("lastName")).sendKeys("Aggarwal");
	  driver.findElement(By.name("phone")).sendKeys("3643783468");
	  driver.findElement(By.id("userName")).sendKeys("shruti18@gmail.com");
	  driver.findElement(By.cssSelector("input[name='address1']")).sendKeys("Accenture");
	  driver.findElement(By.name("city")).sendKeys("Ghaziabad");
	  
	  Select country = new Select(driver.findElement(By.name("country")));
	  country.selectByVisibleText("INDIA");
	  
	  driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user123");
	  driver.findElement(By.name("password")).sendKeys("shru");
	  driver.findElement(By.name("confirmPassword")).sendKeys("shru");
	  driver.findElement(By.name("register")).click();
  }
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\pdc4-training.pdc4\\Desktop\\SeleniumDrivers\\chromedriver.exe");  
	    driver = new ChromeDriver();
	    driver = WebDriverFactory.createDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com");
		PageFactory.initElements(driver, LoginPageObject.class);
  }
  
  
  
  @Test(priority=2,dataProvider="usernameandpassword",description="This test case will run twice")
	public void login(String username, String password) 
	{
		driver.findElement(By.linkText("sign-in")).click();
		LoginPageObject.uname.clear();
		LoginPageObject.uname.sendKeys(username);
		LoginPageObject.pass.clear();
		LoginPageObject.pass.sendKeys(password);
		LoginPageObject.login_button.click();
		driver.navigate().forward();
		driver.navigate().back();
		Assert.assertEquals("FLIGHT FINDER", driver.getTitle());
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

  /*@Test(priority=2)
  public void login()
  {
	  driver.findElement(By.name("userName")).clear();
	  driver.findElement(By.name("userName")).sendKeys("invalidUN");
	  driver.findElement(By.name("password")).clear();
	  driver.findElement(By.name("password")).sendKeys("invalidPW");
	  driver.findElement(By.name("login")).click();
	  AssertJUnit.assertEquals("Find a flight", driver.getTitle());
  }*/
  
  @AfterTest
  public void afterTest() 
  {
  }

}
