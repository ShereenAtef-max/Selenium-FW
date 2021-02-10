package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDeatilsPage extends PageBasePOM {

	public ProductDeatilsPage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(css = "div.product-name")
	public WebElement ProductNameTitle;
	
	@FindBy(css = "div.email-a-friend")
	
	WebElement EmailFriendBtn;
	
	@FindBy(id = "price-value-4")
	public WebElement PriceLabel;
	
	
	
	public void openEmailFriendPage()
	{
		click(EmailFriendBtn);
	}

}
