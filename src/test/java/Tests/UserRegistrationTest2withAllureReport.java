package Tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.HomePage;

import Pages.UserRegistrationPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({AllureListener.class})
public class UserRegistrationTest2withAllureReport extends TestBase {
	
	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Desc: Verifying Registration")
	@Story("Stroy Name: Check Registartion Confirmation")
	public void UserCanRegister() throws InterruptedException
	{
		HomePage obj1 = new HomePage(driver);
		obj1.ClickRegister();
		
		Thread.sleep(3000);
		UserRegistrationPage obj2 = new UserRegistrationPage(driver);
		obj2.UserCanRegister("Shssere","Aterr", "tt44@ww.com", "1234777");
		
		//Thread.sleep(3000);
		String ConfirmRegSMS=obj2.RegisterConfirm.getText();
		
		//Thread.sleep(3000);
		Assert.assertTrue(ConfirmRegSMS.contains("registration123 completed"));
		
		//obj2.continueToMyAccount();
		//Thread.sleep(3000);
		//obj2.Continue();
		
		
	}

}
