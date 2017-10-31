package Maven.automation_project.Smoke;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Maven.automation_project.Driver_class.driver_class;


import Maven.automation_project.Pages.HomePage;
import Maven.automation_project.Pages.LoginPage;

public class HomePageTest extends driver_class {

	HomePage object;

	@BeforeClass
	public void setup() throws IOException {
		initialization();
		object = new HomePage(driver);
	}

	@Test(priority = 0,enabled = true)
	public void Verify_User_is_able_to_click_ShopNow_button() throws Exception {
		object.click_shopnow();
	}

	@Test(priority = 1,enabled = true)
	public void Verify_all_Prices_of_Homepage_Products_are_Correct() throws Exception {
		object.accnt_confirmation();
		object.validate();
		// object.accnt_confirmation();

		// Assert.assertEquals(object.accnt_confirmation(), "Welcome to your
		// account. Here you can manage all of your personal information and
		// orders.");
	}

	@Test(priority = 2,enabled = true)
	public void Verify_User_is_able_to_Make_an_Enquiry() throws Exception {

		object.enquiry();

	}

	@Test(priority = 3,enabled = true)
	public void Verify_User_is_able_to_do_Order() throws Exception {

		object.order();

	}
	
	@Test(priority = 4,enabled = true)
	public void Verify_Discounted_product_price_on_homepage() throws Exception {

		object.discounted_item_price_check();

	}

	@AfterClass
	public void close_browser() {
		closebrowser();
	}

}
