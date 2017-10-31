package Maven.automation_project.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Maven.automation_project.Driver_class.driver_class;
import Maven.automation_project.Uilities.CommonFunctions;

public class LoginPage extends driver_class {
	WebDriver driver;
	CommonFunctions common;
	String actual;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	public String accnt_confirmation() {
		actual = common.get_text(By.xpath(OR.getProperty("acct_confirmation_text")), driver);
		return actual;

	}

	public void login() throws Exception

	{

		common = new CommonFunctions();
		common.click(By.xpath(OR.getProperty("signin_homepage")), driver);
		common.enter_text(By.xpath(OR.getProperty("alreadyreg_emailaddress")), driver,
				testdata.getProperty("emailaddress"));
		common.enter_text(By.xpath(OR.getProperty("login_password")), driver, testdata.getProperty("password"));
		common.click(By.xpath(OR.getProperty("submit_loginbutton")), driver);

		actual = common.get_text(By.xpath(OR.getProperty("acct_confirmation_text")), driver);
		Assert.assertEquals(actual,
				"Welcome to your account. Here you can manage all of your personal information and orders.");

		common.click(By.xpath(OR.getProperty("logout")), driver);

	}

	public void login_blank_cred() throws Exception

	{

		common = new CommonFunctions();
		common.click(By.xpath(OR.getProperty("submit_loginbutton")), driver);
		actual = common.get_text(By.xpath(OR.getProperty("error_emailadd_text")), driver);
		Assert.assertEquals(actual, "An email address required.");

		actual = common.get_text(By.xpath(OR.getProperty("error_oneerror_text")), driver);
		Assert.assertEquals(actual, "There is 1 error");

	}

	public void login_blank_passd() throws Exception

	{

		common = new CommonFunctions();
		common.enter_text(By.xpath(OR.getProperty("alreadyreg_emailaddress")), driver,
				testdata.getProperty("emailaddress"));
		common.click(By.xpath(OR.getProperty("submit_loginbutton")), driver);
		actual = common.get_text(By.xpath(OR.getProperty("error_nopassword_text")), driver);
		Assert.assertEquals(actual, "Password is required.");

	}

	public void login_auth_fail() throws Exception

	{

		common = new CommonFunctions();

		common.clear(By.xpath(OR.getProperty("alreadyreg_emailaddress")), driver);
		common.enter_text(By.xpath(OR.getProperty("alreadyreg_emailaddress")), driver,
				testdata.getProperty("invalidemail"));
		common.enter_text(By.xpath(OR.getProperty("login_password")), driver, testdata.getProperty("password"));
		common.click(By.xpath(OR.getProperty("submit_loginbutton")), driver);
		actual = common.get_text(By.xpath(OR.getProperty("error_wrongemail_text")), driver);
		Assert.assertEquals(actual, "Authentication failed.");

	}

	public void login_invalid_pass() throws Exception

	{

		common = new CommonFunctions();

		common.clear(By.xpath(OR.getProperty("alreadyreg_emailaddress")), driver);

		common.enter_text(By.xpath(OR.getProperty("alreadyreg_emailaddress")), driver,
				testdata.getProperty("emailaddress"));

		common.clear(By.xpath(OR.getProperty("login_password")), driver);

		common.enter_text(By.xpath(OR.getProperty("login_password")), driver, testdata.getProperty("invalidpass"));

		common.click(By.xpath(OR.getProperty("submit_loginbutton")), driver);

		actual = common.get_text(By.xpath(OR.getProperty("error_invaidpass_text")), driver);
		Assert.assertEquals(actual, "Invali password.");

	}

}
