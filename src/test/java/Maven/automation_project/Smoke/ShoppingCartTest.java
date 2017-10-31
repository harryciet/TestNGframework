package Maven.automation_project.Smoke;

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
import Maven.automation_project.Pages.ShoppingCartPage;

public class ShoppingCartTest extends driver_class{
	

	
	
	ShoppingCartPage object;
	
	
    
	@BeforeClass
	public void setup() throws IOException
	{
		initialization();
		object= new ShoppingCartPage(driver);
	}
	
	@Test(priority=0,enabled = true)
	public void Verify_User_is_able_to_add_single_item_into_Cart() throws Exception
	{
	 
	 object.add_item_cart();
	
	}
	
	@Test(priority=1,enabled = true)
	public void Verify_User_is_able_to_add_Same_item_again_into_Cart() throws Exception
	{
	 
	 object.add_same_item_cart();
	
	}
	
	@Test(priority=2,enabled = true)
	public void Verify_User_is_able_to_add_Multiple_Different_items_into_Cart() throws Exception
	{
	 
	 object.add_different_item_cart();
	
	}
	
	@Test(priority=3,enabled = true)
	public void Verify_User_is_able_to_Remove_Single_item_from__Cart() throws Exception
	{
	 
	 object.remove_single_item();
	
	}
	
	@Test(priority=4,enabled = true)
	public void Verify_User_is_able_to_Remove_all_items_from__Cart() throws Exception
	{
	 
	 object.remove_all_items();
	
	}
	
	@Test(priority=5,enabled = true)
	public void Verify_User_is_able_to_click_image_of_item_in__Cart() throws Exception
	{
	 
	 object.click_cart_item_image();
	
	}
	
	@Test(priority=6,enabled = true)
	public void Verify_User_is_able_to_click_name_of_item_in_Cart() throws Exception
	{
	 
	 object.click_cart_item_name();
	
	}
	
	@Test(priority=7,enabled = true)
	public void Verify_Cart_Data_is_Reatined_on_Opening_the_closed_Session() throws Exception
	{
	 
	 object.open_closed_session();
	
	}
	@Test(priority=8,enabled = true)
	public void Verify_User_is_able_to_add_discounted_item_into_Cart() throws Exception
	{
	 
	 object.add_discounted_product();
	
	}

	
	
	@AfterClass
	public void close_browser()
	{
		closebrowser();
	}

}
