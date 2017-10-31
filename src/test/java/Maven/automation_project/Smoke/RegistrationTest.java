package Maven.automation_project.Smoke;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Maven.automation_project.Driver_class.driver_class;
import Maven.automation_project.Pages.LoginPage;
import Maven.automation_project.Pages.RegistrationPage;

public class RegistrationTest extends driver_class {

	RegistrationPage object;

    
	@BeforeClass
	public void setup() throws IOException
	{
		initialization();
		object= new RegistrationPage(driver);
	}
	@Test(priority=0)
	public void Verify_User_is_able_Register_as_New_User() throws Exception
	{
	 
	 object.registration();
	
	Assert.assertEquals(object.accnt_confirmation(), "Welcome to your account. Here you can manage all of your personal information and orders.");

		
	}
	
	@Test(priority=1)
	public void Verify_User_is_not_able_to_Register_with_Already_Regitered_Email() throws Exception
	{
	 
	 object.regitration_with_regitered_email();
	
	

		
	}
	@AfterClass
	public void close_browser()
	{
		closebrowser();
	}

}
