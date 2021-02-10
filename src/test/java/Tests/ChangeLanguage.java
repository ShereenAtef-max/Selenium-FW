package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ProductDeatilsPage;
import Pages.SearchPage;

public class ChangeLanguage extends TestBase{
	
	HomePage obj1;
	SearchPage obj2;
	ProductDeatilsPage obj3;
	int index =1;
	String ProductName="Apple MacBook Pro 13-inch";
	String Symbol="€";
	
	//1. Not registered user change language
	@Test(priority = 1)
	public void ChangeLang() throws InterruptedException
	{
		obj1 = new HomePage(driver);
		Thread.sleep(2000);
		obj1.SelectLang(index);
		
	}
	
	//2. search for product & verify teh price currency label
		@Test( priority = 2)
		public void AutoSearchForProduct() throws InterruptedException
		{
			obj2 = new SearchPage(driver);
			obj2.autoSearch(ProductName);
			
			
		}
		
		@Test(priority = 3)
		public void CheckPriceSymbol() throws InterruptedException
		{
			obj3 = new ProductDeatilsPage(driver);
			//Thread.sleep(2000);
			
			
			Assert.assertTrue(obj3.PriceLabel.getText().contains(Symbol));

			
		}
	
	
	
}
