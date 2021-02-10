package Pages;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBasePOM {

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	
	
	@FindBy(id = "small-searchterms")
	WebElement SearchTxtBox;
	
	
	@FindBy(id = "ui-id-1")
	List<WebElement>  SearchAutoList;
	
	
	public void autoSearch(String ProductName) throws InterruptedException
	{
		Write(SearchTxtBox, ProductName);
		Thread.sleep(2000);
		SearchAutoList.get(0).click();
		
	}
	
	

}
