package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class UserRegistrationPage extends PageBasePOM {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
		
		
		
	}
	
	@FindBy(id = "gender-male")
	WebElement RadioButton;
	
	@FindBy(id = "FirstName")
	WebElement FirstName;
	
	@FindBy(id = "LastName")
	WebElement LastName;
	
	@FindBy(id = "Email")
	WebElement Email;
	
	@FindBy(id = "Password")
	WebElement Password;
	
	@FindBy(id = "ConfirmPassword")
	WebElement ConfirmPass;
	
	@FindBy(id = "register-button")
	WebElement RegisterButton;
	
	@FindBy(css = "div.result")
	public WebElement RegisterConfirm;
	
	@FindBy(name = "register-continue")
	WebElement ContinueBtn;
	

	@Step("Register with Fname: {0} and Lname: {1} and Email: {2} and Pass: {3} step... ")
	public void UserCanRegister(String FName, String LName,String Emailvalue, String Pass)
	{
		//RadioButton.click();
		click(RadioButton);
		//FirstName.sendKeys(FName);
		Write(FirstName,FName);
		//LastName.sendKeys(LName);
		Write(LastName, LName);
		//Email.sendKeys(Emailvalue);
		Write(Email, Emailvalue);
		//Password.sendKeys(Pass);
		Write(Password, Pass);
		//ConfirmPass.sendKeys(Pass);
		Write(ConfirmPass, Pass);
		//RegisterButton.click();
		click(RegisterButton);
		
		
		
	}
	
	public void Continue()
	{
		ContinueBtn.click();
	}
	
	
	

}
