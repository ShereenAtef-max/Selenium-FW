package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;

import Pages.UserRegistrationPage;

public class UserRegistrationTest2WithDataProvider extends TestBase {
	
	
	@DataProvider(name="RegistrationTestData")
	public static  Object[][] testData()
	{
		return new Object[][] {
			{"SherTTTyy","Atffff","ff@eertytr.com","nknknkkkk33"},
			{"DD","RR","DDRR@wwrrtt.com","wew33333333"}
		};
		
	}
	
	
	@Test(dataProvider = "RegistrationTestData")
	public void UserCanRegister(String Fname, String Lname, String Email, String Pass) throws InterruptedException
	{
		HomePage obj1 = new HomePage(driver);
		obj1.ClickRegister();
		
		UserRegistrationPage obj2 = new UserRegistrationPage(driver);
		obj2.UserCanRegister(Fname,Lname, Email, Pass);
		
		Thread.sleep(3000);
		String ConfirmRegSMS=obj2.RegisterConfirm.getText();
		
		//Thread.sleep(3000);
		Assert.assertTrue(ConfirmRegSMS.contains("registration completed"));
		
		//obj2.continueToMyAccount();
		//Thread.sleep(3000);
		//obj2.Continue();
		
		obj1.Logout();
		Thread.sleep(3000);
		
	}

}
