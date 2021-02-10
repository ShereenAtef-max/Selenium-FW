package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ProductDeatilsPage;
import Pages.SearchPage;
import Pages.SendEmailPage;
import Pages.UserRegistrationPage;

public class SendEmailToFriendTest  extends TestBase{

	HomePage obj1;
	UserRegistrationPage obj2;
	SearchPage obj3;
	ProductDeatilsPage obj4;
	SendEmailPage obj5;

	String ProductName="Apple MacBook Pro 13-inch";
	String FriendEmailData="gg@ee.com";
	String SMSData="asejkwaejwnknqkwjehqkweqkjweq";

	// 1. Registered User

	@Test(priority = 1)
	public void UserCanRegister() throws InterruptedException
	{
		obj1 = new HomePage(driver);
		obj1.ClickRegister();

		obj2 = new UserRegistrationPage(driver);
		Thread.sleep(3000);
		obj2.UserCanRegister("Shere","Ate", "sheryttyyttfjjts@23tt47887yy01yiiy44.com", "1234777");

		Thread.sleep(3000);
		String ConfirmRegSMS=obj2.RegisterConfirm.getText();

		Thread.sleep(3000);
		Assert.assertTrue(ConfirmRegSMS.contains("registration completed"));


	}

	//2. Search for Product

	@Test(priority = 2)
	public void AutoSearchForProduct() throws InterruptedException
	{
		obj3 = new SearchPage(driver);
		obj3.autoSearch(ProductName);
	
		
	}

	//3. open SendEmail from Product details
	@Test(priority=3)
	public void OpenSendEmailPage() throws InterruptedException
	{
		obj4 = new ProductDeatilsPage(driver);
		Thread.sleep(2000);
		obj4.openEmailFriendPage();

		
	}

	//4. Send Email Page &  Confirm Email is sent
	
	@Test(priority = 4)
	public void SendEmail() throws InterruptedException
	{
		obj5 = new SendEmailPage(driver);
		Assert.assertEquals(obj5.FriendEmailTitle.getText(), "Email a friend");
		
		obj5.sendEmail(FriendEmailData, SMSData);
		
		String ConfirmSendingSMS=obj5.ConfirmSendingEmail.getText();
		
		Assert.assertEquals(ConfirmSendingSMS, "Your message has been sent.");
	}

	

}
