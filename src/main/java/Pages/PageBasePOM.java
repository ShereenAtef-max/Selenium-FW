package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBasePOM {
	
	protected WebDriver driver;
	public Select select;
	
	
	public PageBasePOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void click(WebElement elem)
	{
		elem.click();
		
	}
	
	public void Write(WebElement elem, String value)
	{
		elem.sendKeys(value);
	}

}
