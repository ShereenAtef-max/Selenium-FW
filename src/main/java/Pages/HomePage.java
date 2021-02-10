package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Step;

public class HomePage extends PageBasePOM {

	public HomePage(WebDriver driver) {
		super(driver);

	}
	
	//Find WebElem
	
	@FindBy(linkText = "Register")
	WebElement registerLink;
	
	@FindBy(id = "customerCurrency")
	WebElement DDLLanguage;
	
	@FindBy(linkText = "Log out")
	WebElement LogoutBtn;
	
	
	//Work with WebElem
	@Step("Click Register Button...")
	public void ClickRegister()
	{
		click(registerLink);
	}
	
	@Step("Selecting teh Lang...")
	public void SelectLang(int index)
	{
		select = new Select(DDLLanguage);
		select.selectByIndex(index);
	}
	
	@Step("Click Logout Button...")
	public void Logout()
	{
		click(LogoutBtn);
	}

}
