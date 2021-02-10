package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendEmailPage extends PageBasePOM{

	public SendEmailPage(WebDriver driver) {
		super(driver);
	
	}
	
	
	@FindBy(css = "div.page-title")
	public WebElement FriendEmailTitle;
	
	@FindBy(css = "input.friend-email")
	WebElement FriendEmail;
	
	@FindBy(id = "PersonalMessage")
	WebElement EmailSMS;
	
	@FindBy(name = "send-email")
	WebElement SendBtn;
	
	@FindBy(css = "div.result")
	public WebElement ConfirmSendingEmail;
	
	public void sendEmail(String FriendEmailData, String EmailSMSData)
	{
		Write(FriendEmail, FriendEmailData);
		Write(EmailSMS, EmailSMSData);
		click(SendBtn);
		
		
		
	}

}
