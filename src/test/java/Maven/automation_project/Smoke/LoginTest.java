package Maven.automation_project.Smoke;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Maven.automation_project.Driver_class.driver_class;
import Maven.automation_project.Pages.LoginPage;

public class LoginTest extends driver_class{
	

	
	
	LoginPage object;

    
	@BeforeClass
	public void setup() throws IOException
	{
		initialization();
		object= new LoginPage(driver);
	}
	@Test(priority=0,enabled = true)
	public void Verify_User_is_Able_to_Login_With_Valid_Credentials() throws Exception
	{
	 
	 object.login();
	
	}
	
	@Test(priority=1,enabled = true)
	public void Verify_User_is_not_Able_to_Login_With_Blank_Credentials() throws Exception
	{
	 
	 object.login_blank_cred();
	}
	
	@Test(priority=2,enabled = true)
	public void Verify_User_is_not_Able_to_Login_With_Blank_Password() throws Exception
	{
	 
	 object.login_blank_passd();
	}
	
	
	@Test(priority=3,enabled = true)
	public void Verify_User_is_not_Able_to_Login_With_Invalid_EmailAddress() throws Exception
	{
	 object.login_auth_fail();
	}
	
	@Test(priority=4,enabled = true)
	public void Verify_User_is_not_Able_to_Login_With_Invalid_Password() throws Exception
	{
	 object.login_invalid_pass();
    }
	
	
	
	@AfterClass
	public void close_browser()
	{
		closebrowser();
	}

}
