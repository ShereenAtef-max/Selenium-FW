package Tests;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;


public class AllureListenerLast implements ITestListener {

	//When ScreenShot will be TAken
	@Override
	public void onTestFailure(ITestResult result) {
		
		
		
		saveScreenOnFailure(TestBase.GetDriver());
		saveLogs(result.getMethod().getConstructorOrMethod().getName());

	}

	//Take ScreenShot
	@Attachment(value = "screenshot", type = "image/png")
	public byte[] saveScreenOnFailure(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}


	@Attachment(value = "{0}", type = "text/plain")
	public static String saveLogs(String message) {
		return message;
	}



}
