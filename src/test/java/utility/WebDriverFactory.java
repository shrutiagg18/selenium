package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory 
{

	public static WebDriver createDriver()
	{
		String webdriver = System.getProperty("browser","chrome");

		switch(webdriver)
		{
		case "firefox":
			System.setProperty("webdriver.gecko.driver","C:\\Users\\pdc4-training.pdc4\\Desktop\\SeleniumDrivers\\geckodriver.exe");
			return new FirefoxDriver();

		case "chrome":
			System.setProperty("webdriver.chrome.driver","C:\\Users\\pdc4-training.pdc4\\Desktop\\SeleniumDrivers\\chromedriver.exe");
			return new ChromeDriver();

		case "IE":
			System.setProperty("webdriver.ie.driver","C:\\Users\\pdc4-training.pdc4\\Desktop\\SeleniumDrivers\\IEDriverServer.exe");
			return new InternetExplorerDriver();

		default:
			throw new RuntimeException("Unsupported Webdriver: " + webdriver);
		}
	}
}
