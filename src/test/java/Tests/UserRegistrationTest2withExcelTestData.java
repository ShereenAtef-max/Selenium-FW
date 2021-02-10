package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;

import Pages.UserRegistrationPage;
import TestData.ReadExcelData;

public class UserRegistrationTest2withExcelTestData extends TestBase {
	
	@DataProvider(name="EXTestData")
	public Object[][] ExcelTestData() throws IOException
	{
		ReadExcelData ER = new ReadExcelData();
		
		return ER.GetExcelData();
	}
	
	@Test(dataProvider = "EXTestData")
	public void UserCanRegister(String Fname,String Lname, String Email, String Pass) throws InterruptedException
	{
		HomePage obj1 = new HomePage(driver);
		obj1.ClickRegister();
		Thread.sleep(3000);
		UserRegistrationPage obj2 = new UserRegistrationPage(driver);
		obj2.UserCanRegister(Fname,Lname, Email, Pass);
		
		Thread.sleep(4000);
		String ConfirmRegSMS=obj2.RegisterConfirm.getText();
		
		//Thread.sleep(3000);
		Assert.assertTrue(ConfirmRegSMS.contains("registration completed"));
		
		//obj2.continueToMyAccount();
		//Thread.sleep(3000);
		//obj2.Continue();
		
		obj1.Logout();
		Thread.sleep(4000);
		
	}

}
