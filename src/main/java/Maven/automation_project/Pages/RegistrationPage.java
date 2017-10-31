package Maven.automation_project.Pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Maven.automation_project.Driver_class.driver_class;
import Maven.automation_project.Uilities.CommonFunctions;

public class RegistrationPage extends driver_class {
	WebDriver driver;
	CommonFunctions common;
	String new_email_address;
	boolean result;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public String accnt_confirmation() {
		String actual = common.get_text(By.xpath(OR.getProperty("acct_confirmation_text")), driver);
		return actual;

	}

	public void registration() throws InterruptedException {

		System.out.println("reached in registerwebsite method");
		common = new CommonFunctions();
		common.click(By.xpath(OR.getProperty("signin_homepage")), driver);
		new_email_address = testdata.getProperty("create_new_email")
				+ new SimpleDateFormat("MM-DD-YYYY-HH-MM-SS").format(new GregorianCalendar().getTime()) + "@gmail.com";
		System.out.println(new_email_address);
		common.enter_text(By.xpath(OR.getProperty("create_email")), driver, new_email_address);

		common.click(By.xpath(OR.getProperty("create_accnt_button")), driver);

		common.click(By.xpath(OR.getProperty("mr_radio")), driver);

		common.enter_text(By.xpath(OR.getProperty("firstname")), driver, testdata.getProperty("firstname_reg"));

		common.enter_text(By.xpath(OR.getProperty("lastname")), driver, testdata.getProperty("lastname_reg"));
	
		common.enter_text(By.xpath(OR.getProperty("password_registration")), driver,
				testdata.getProperty("password_reg"));
		common.dropdown_select(By.xpath(OR.getProperty("days_reg")), driver, testdata.getProperty("day_reg"));

		common.dropdown_select(By.xpath(OR.getProperty("months_reg")), driver, testdata.getProperty("month_reg"));
		common.dropdown_select(By.xpath(OR.getProperty("years_reg")), driver, testdata.getProperty("year_reg"));
		common.click(By.xpath(OR.getProperty("signup_checkbox")), driver);
		common.click(By.xpath(OR.getProperty("offers_checkbox")), driver);

		common.enter_text(By.xpath(OR.getProperty("company")), driver, testdata.getProperty("company_reg"));
		common.enter_text(By.xpath(OR.getProperty("address1")), driver, testdata.getProperty("address1_reg"));
		common.enter_text(By.xpath(OR.getProperty("address2")), driver, testdata.getProperty("address2_reg"));
		common.enter_text(By.xpath(OR.getProperty("city")), driver, testdata.getProperty("city_reg"));
		common.dropdown_select(By.xpath(OR.getProperty("state")), driver, testdata.getProperty("state_reg"));

		common.enter_text(By.xpath(OR.getProperty("postcode")), driver, testdata.getProperty("postcode_reg"));

		common.dropdown_select(By.xpath(OR.getProperty("country")), driver, testdata.getProperty("country_reg"));
		common.enter_text(By.xpath(OR.getProperty("additional_info")), driver,
		testdata.getProperty("additional_info_reg"));
		common.enter_text(By.xpath(OR.getProperty("homemobile")), driver, testdata.getProperty("homemobile_reg"));
		common.enter_text(By.xpath(OR.getProperty("phonemobile")), driver, testdata.getProperty("phonemobile_reg"));

		common.enter_text(By.xpath(OR.getProperty("alias_textbox")), driver, testdata.getProperty("alias_textbox_reg"));
		common.click(By.xpath(OR.getProperty("register_button")), driver);

	}

	public void regitration_with_regitered_email() throws InterruptedException {
		common.click(By.xpath(OR.getProperty("logout")), driver);
		new_email_address = testdata.getProperty("create_new_email") + "@gmail.com";

		common.enter_text(By.xpath(OR.getProperty("create_email")), driver, new_email_address);

		common.click(By.xpath(OR.getProperty("create_accnt_button")), driver);
		

		result = common.element_exist(By.xpath(OR.getProperty("create_same_accnt_error")), driver);
		Assert.assertEquals(result, true);
	}

}
