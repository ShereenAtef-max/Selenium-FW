package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;

import Pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
	
	@Test
	public void UserCanRegister() throws InterruptedException
	{
		HomePage obj1 = new HomePage(driver);
		obj1.ClickRegister();
		
		UserRegistrationPage obj2 = new UserRegistrationPage(driver);
		obj2.UserCanRegister("Shere","Ate", "shery@2347887044.com", "1234777");
		
		//Thread.sleep(3000);
		String ConfirmRegSMS=obj2.RegisterConfirm.getText();
		
		//Thread.sleep(3000);
		Assert.assertTrue(ConfirmRegSMS.contains("registration completed"));
		
		//obj2.continueToMyAccount();
		//Thread.sleep(3000);
		//obj2.Continue();
		
		
	}

}
