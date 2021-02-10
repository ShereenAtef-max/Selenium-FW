package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Utilities.Screenshot;
import io.cucumber.testng.AbstractTestNGCucumberTests;


//All TestCases will be enherited from it


public class TestBase extends AbstractTestNGCucumberTests{

	 public static WebDriver driver;


@BeforeSuite
@Parameters ({"browser"})
public static void StartDriver(@Optional("firefox") String browserName)

{
	if(browserName.equalsIgnoreCase("chrome"))
	{
		String ChromePath= System.getProperty("user.dir")+"/Resources/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
	}
	else if(browserName.equalsIgnoreCase("firefox"))
	{
		String FirFoxPath= System.getProperty("user.dir")+"/Resources/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", FirFoxPath);
		driver = new FirefoxDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	driver.navigate().to("https://demo.nopcommerce.com/");
	
	}

public static WebDriver GetDriver()
{
	return driver;
	}


@AfterSuite
public void CloseDriver()
{
	driver.quit();
	}

@AfterMethod
public void ScreenShotifFailed(ITestResult result)
{
	if(result.getStatus()==ITestResult.FAILURE)
	{
		
		System.out.println("Failed!");
		Screenshot.captureScreenshot(driver, result.getName());
		
	}
	
	
	}

}
