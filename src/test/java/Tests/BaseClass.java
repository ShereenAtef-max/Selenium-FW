package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	public WebDriver Inbitialize_Driver()
	{
		//WebDriverManager.chromedriver().setup();
		String FirFoxPath= System.getProperty("user.dir")+"/Resources/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", FirFoxPath);
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		tdriver.set(driver);
		return getDriver();
		
		
	}
	
	public static synchronized WebDriver getDriver()
	{
		return tdriver.get();
	}
}
