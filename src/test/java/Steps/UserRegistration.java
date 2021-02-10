package Steps;

import org.testng.Assert;

import Pages.HomePage;
import Pages.UserRegistrationPage;
import Tests.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegistration extends TestBase {
	
	HomePage obj1;
	UserRegistrationPage obj2;

	@Given("User access the  home page")
	public void user_access_the_home_page() {
		
	obj1 = new HomePage(driver);

	
	obj2 = new UserRegistrationPage(driver);
	
	    
	}
	
	@When("I click on Reigister link")
	public void I_click_on_Reigister_link() {
		obj1.ClickRegister();
		
	    
	}
	
//	@When("I entered the user data")
//	public void I_entered_the_user_data() {
//	    obj2.UserCanRegister("DD", "PP", "DDPP@ww.com", "wjdw778899909");
//	}
	
	@When("I entered {string} , {string} , {string} , {string}")
	public void i_entered(String firstname, String Lastname, String email, String Password) {
		obj2.UserCanRegister(firstname, Lastname,email ,Password );
	}

	@Then("the registration page displayed successfully")
	public void the_registration_page_displayed_successfully() {
	    String ConfrimSMS=obj2.RegisterConfirm.getText();
	    Assert.assertTrue(ConfrimSMS.contains("registration completed"));
	}
	
}
