package Maven.automation_project.Pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Maven.automation_project.Driver_class.driver_class;
import Maven.automation_project.Uilities.CommonFunctions;

public class ShoppingCartPage extends driver_class {
	WebDriver driver;
	CommonFunctions common;
	String actual;
	boolean result;

	public ShoppingCartPage(WebDriver driver) {

		this.driver = driver;
	}

	public void add_item_cart() throws Exception

	{

		common = new CommonFunctions();
		common.hover_element(By.xpath(OR.getProperty("Prod_image1")), driver);

		common.click(By.xpath(OR.getProperty("addtocart_product1_bttn")), driver);

		common.wait_visibility_of_element(By.xpath(OR.getProperty("product_name_layer_cart")), driver);
		actual = common.get_text(By.xpath(OR.getProperty("product_name_layer_cart")), driver);

		Assert.assertEquals(actual, testdata.getProperty("product1_name_layer"));

		actual = common.get_text(By.xpath(OR.getProperty("product1_qty_layer_cart")), driver);
		Assert.assertEquals(actual, "1");

		actual = common.get_text(By.xpath(OR.getProperty("product1_price_layer_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("product1_price"));

		System.out.println(common.size_elements(By.xpath(OR.getProperty("total_items_text-layer_cart")), driver));

		actual = driver.findElements(By.xpath(OR.getProperty("total_items_text-layer_cart"))).get(2).getText();

		Assert.assertEquals(actual, "There is 1 item in your cart.");

		actual = common.get_text(By.xpath(OR.getProperty("total_prod_cost_layer_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("product1_price"));

		actual = common.get_text(By.xpath(OR.getProperty("total_shipping_layer_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("shipping_price"));

		actual = common.get_text(By.xpath(OR.getProperty("overall_cost_layer_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("product1_overall_cost"));

		common.click(By.xpath(OR.getProperty("cross_icon_layer_cart")), driver);
		

		common.hover_element(By.xpath(OR.getProperty("block_cart_hover")), driver);
		actual = common.get_text(By.xpath(OR.getProperty("block_cart_hover")), driver);
		Assert.assertEquals(actual, "Cart 1 Product");

		result = common.element_exist(By.xpath(OR.getProperty("product1_img_block_cart")), driver);
		Assert.assertEquals(result, true);

		actual = common.get_text(By.xpath(OR.getProperty("product1_qty_block_cart")), driver);
		Assert.assertEquals(actual, "1");

		actual = common.get_text(By.xpath(OR.getProperty("product1_price_block_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("product1_price"));

		actual = common.get_text(By.xpath(OR.getProperty("product1_shipping_block_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("shipping_price"));

		actual = common.get_text(By.xpath(OR.getProperty("overall_cost_block_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("product1_overall_cost"));

	}

	public void add_same_item_cart() throws Exception

	{

		common = new CommonFunctions();
		common.hover_element(By.xpath(OR.getProperty("Prod_image1")), driver);

		common.click(By.xpath(OR.getProperty("addtocart_product1_bttn")), driver);

		common.wait_visibility_of_element(By.xpath(OR.getProperty("product_name_layer_cart")), driver);
		actual = common.get_text(By.xpath(OR.getProperty("product_name_layer_cart")), driver);

		Assert.assertEquals(actual, testdata.getProperty("product1_name_layer"));

		actual = common.get_text(By.xpath(OR.getProperty("product1_qty_layer_cart")), driver);

		Assert.assertEquals(actual, "2");

		actual = common.get_text(By.xpath(OR.getProperty("product1_price_layer_cart")), driver);
		System.out.println(actual);
		Assert.assertEquals(actual, testdata.getProperty("Add_two_product1_items"));
		actual = driver.findElements(By.xpath(OR.getProperty("total_items_text-layer_cart"))).get(0).getText();

		Assert.assertEquals(actual, "There are 2 items in your cart.");

		actual = common.get_text(By.xpath(OR.getProperty("total_prod_cost_layer_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("Add_two_product1_items"));

		actual = common.get_text(By.xpath(OR.getProperty("total_shipping_layer_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("shipping_price"));

		actual = common.get_text(By.xpath(OR.getProperty("overall_cost_layer_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("two_product1_items_overall_cost"));

		common.click(By.xpath(OR.getProperty("cross_icon_layer_cart")), driver);

		common.hover_element(By.xpath(OR.getProperty("block_cart_hover")), driver);

		actual = common.get_text(By.xpath(OR.getProperty("block_cart_hover")), driver);
		Assert.assertEquals(actual, "Cart 2 Products");
		result = common.element_exist(By.xpath(OR.getProperty("product1_img_block_cart")), driver);
		Assert.assertEquals(result, true);

		actual = common.get_text(By.xpath(OR.getProperty("product1_qty_block_cart")), driver);
		Assert.assertEquals(actual, "2");

		actual = common.get_text(By.xpath(OR.getProperty("product1_price_block_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("Add_two_product1_items"));
		
		common.wait_visibility_of_element(By.xpath(OR.getProperty("product1_shipping_block_cart")), driver);

		//Thread.sleep(2000);
		actual = common.get_text(By.xpath(OR.getProperty("product1_shipping_block_cart")), driver);
	    Assert.assertEquals(actual, testdata.getProperty("shipping_price"));

		actual = common.get_text(By.xpath(OR.getProperty("overall_cost_block_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("two_product1_items_overall_cost"));

	}

	public void add_different_item_cart() throws InterruptedException {

		common = new CommonFunctions();
		common.hover_element(By.xpath(OR.getProperty("Prod_image2")), driver);
		common.click(By.xpath(OR.getProperty("addtocart_product2_bttn")), driver);

		common.wait_visibility_of_element(By.xpath(OR.getProperty("product_name_layer_cart")), driver);

		actual = common.get_text(By.xpath(OR.getProperty("product_name_layer_cart")), driver);
		Assert.assertEquals(actual, "Blouse");

		actual = common.get_text(By.xpath(OR.getProperty("product1_qty_layer_cart")), driver);

		Assert.assertEquals(actual, "1");

		actual = common.get_text(By.xpath(OR.getProperty("product1_price_layer_cart")), driver);
		System.out.println(actual);
		Assert.assertEquals(actual, testdata.getProperty("product2_price"));

		actual = driver.findElements(By.xpath(OR.getProperty("total_items_text-layer_cart"))).get(0).getText();

		Assert.assertEquals(actual, "There are 3 items in your cart.");


		actual = common.get_text(By.xpath(OR.getProperty("total_prod_cost_layer_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("Add_three_product1and2_items"));

		common.wait_visibility_of_element(By.xpath(OR.getProperty("total_shipping_layer_cart")), driver);

		actual = common.get_text(By.xpath(OR.getProperty("total_shipping_layer_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("shipping_price"));

		actual = common.get_text(By.xpath(OR.getProperty("overall_cost_layer_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("product1and2_overall_cost"));

		common.click(By.xpath(OR.getProperty("cross_icon_layer_cart")), driver);

		common.hover_element(By.xpath(OR.getProperty("block_cart_hover")), driver);
		actual = common.get_text(By.xpath(OR.getProperty("block_cart_hover")), driver);
		Assert.assertEquals(actual, "Cart 3 Products");
		result = common.element_exist(By.xpath(OR.getProperty("product1_img_block_cart")), driver);
		Assert.assertEquals(result, true);

		actual = common.get_text(By.xpath(OR.getProperty("product1_qty_block_cart")), driver);
		Assert.assertEquals(actual, "2");

		actual = common.get_text(By.xpath(OR.getProperty("product2_qty_block_cart")), driver);
		Assert.assertEquals(actual, "1");

		common.wait_visibility_of_element(By.xpath(OR.getProperty("product1_shipping_block_cart")), driver);
		actual = common.get_text(By.xpath(OR.getProperty("product1_shipping_block_cart")), driver);
		System.out.println("Code break1");
		Assert.assertEquals(actual, testdata.getProperty("shipping_price"));

		actual = common.get_text(By.xpath(OR.getProperty("overall_cost_block_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("product1and2_overall_cost"));

	}

	public void remove_single_item() throws Exception

	{
       int old_size= common.size_elements(By.xpath(OR.getProperty("remove_link")), driver);
		common.click(By.xpath(OR.getProperty("cross_icon_last_item")), driver);
		Thread.sleep(2000);
		  int new_size= common.size_elements(By.xpath(OR.getProperty("remove_link")), driver);
		  
		  if(new_size<old_size)
			  Assert.assertTrue(true);
		  else
			  Assert.assertTrue(false);
		

	}

	public void remove_all_items() throws Exception

	{
		common.hover_element(By.xpath(OR.getProperty("Prod_image2")), driver);
		common.click(By.xpath(OR.getProperty("addtocart_product2_bttn")), driver);
		common.wait_visibility_of_element(By.xpath(OR.getProperty("cross_icon_layer_cart")), driver);
		common.click(By.xpath(OR.getProperty("cross_icon_layer_cart")), driver);
		common.hover_element(By.xpath(OR.getProperty("block_cart_hover")), driver);
		common.wait_visibility_of_element(By.xpath(OR.getProperty("cross_icon_last_item")), driver);
		common.click(By.xpath(OR.getProperty("cross_icon_last_item")), driver);
		
	
		common.click(By.xpath(OR.getProperty("cross_icon_first_item")), driver);
		Thread.sleep(2000);
		actual = common.get_text(By.xpath(OR.getProperty("block_cart_hover")), driver);
		Assert.assertEquals(actual, "Cart (empty)");
	}

	public void click_cart_item_image() throws Exception {

		common = new CommonFunctions();
		common.hover_element(By.xpath(OR.getProperty("Prod_image1")), driver);

		common.click(By.xpath(OR.getProperty("addtocart_product1_bttn")), driver);

		common.wait_visibility_of_element(By.xpath(OR.getProperty("product_name_layer_cart")), driver);

		common.click(By.xpath(OR.getProperty("cross_icon_layer_cart")), driver);

		common.hover_element(By.xpath(OR.getProperty("block_cart_hover")), driver);

		common.click(By.xpath(OR.getProperty("product1_img_block_cart")), driver);
		actual = common.get_text(By.xpath(OR.getProperty("product1name_text_details")), driver);
		Assert.assertEquals(actual, testdata.getProperty("product1name_text_details"));

		driver.navigate().back();

	}

	public void click_cart_item_name() throws Exception {

		common = new CommonFunctions();
		driver.navigate().refresh();

		common.hover_element(By.xpath(OR.getProperty("block_cart_hover")), driver);

		common.click(By.xpath(OR.getProperty("product1_name_block_cart")), driver);
		actual = common.get_text(By.xpath(OR.getProperty("product1name_text_details")), driver);
		Assert.assertEquals(actual, testdata.getProperty("product1name_text_details"));
		driver.navigate().back();

	}

	public void open_closed_session() throws Exception {
		common = new CommonFunctions();
		driver.navigate().refresh();
		Set<Cookie> allCookies = driver.manage().getCookies();
		System.out.println(allCookies);
		driver.close();

		/*
		 * selectbrowser(testdata.getProperty("browser"));
		 * driver.get(testdata.getProperty("url"));
		 * driver.manage().window().maximize();
		 */

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.manage().window().maximize();

		for (Cookie cookie : allCookies) {

			driver.manage().addCookie(cookie);
		}

		driver.navigate().refresh();

		common.hover_element(By.xpath(OR.getProperty("block_cart_hover")), driver);
		actual = common.get_text(By.xpath(OR.getProperty("block_cart_hover")), driver);
		Assert.assertEquals(actual, "Cart 1 Product");

		result = common.element_exist(By.xpath(OR.getProperty("product1_img_block_cart")), driver);
		Assert.assertEquals(result, true);

		actual = common.get_text(By.xpath(OR.getProperty("product1_qty_block_cart")), driver);
		Assert.assertEquals(actual, "1");

		actual = common.get_text(By.xpath(OR.getProperty("product1_price_block_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("product1_price"));

		actual = common.get_text(By.xpath(OR.getProperty("product1_shipping_block_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("shipping_price"));

		actual = common.get_text(By.xpath(OR.getProperty("overall_cost_block_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("product1_overall_cost"));

	}

	public void add_discounted_product() throws Exception {
		common = new CommonFunctions();
		// common.click(By.xpath(OR.getProperty("cross_icon_first_item")),driver);
		
		common.hover_element(By.xpath(OR.getProperty("block_cart_hover")), driver);
		common.wait_visibility_of_element(By.xpath(OR.getProperty("cross_icon_first_item")), driver);
		common.click(By.xpath(OR.getProperty("cross_icon_first_item")), driver);


		common.hover_element(By.xpath(OR.getProperty("Prod_image5")), driver);

		common.click(By.xpath(OR.getProperty("addtocart_product5_bttn")), driver);

		common.wait_visibility_of_element(By.xpath(OR.getProperty("product_name_layer_cart")), driver);
		actual = common.get_text(By.xpath(OR.getProperty("product_name_layer_cart")), driver);

		// Thread.sleep(1000);
		Assert.assertEquals(actual, testdata.getProperty("product5_name_layer"));
		common.wait_visibility_of_element(By.xpath(OR.getProperty("product1_qty_layer_cart")), driver);

		actual = common.get_text(By.xpath(OR.getProperty("product1_qty_layer_cart")), driver);
		Assert.assertEquals(actual, "1");

		actual = common.get_text(By.xpath(OR.getProperty("product1_price_layer_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("product5_price"));
		// Thread.sleep(3000);

		/*
		 * actual=common.get_text(By.xpath(OR.getProperty(
		 * "total_items_text-layer_cart")), driver); Assert.assertEquals(actual,
		 * "There is 1 item in your cart.");
		 */

		actual = common.get_text(By.xpath(OR.getProperty("total_prod_cost_layer_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("product5_price"));

		actual = common.get_text(By.xpath(OR.getProperty("total_shipping_layer_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("shipping_price"));

		actual = common.get_text(By.xpath(OR.getProperty("overall_cost_layer_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("product5_overall_cost"));

		common.click(By.xpath(OR.getProperty("cross_icon_layer_cart")), driver);
		// Thread.sleep(2000);

		common.hover_element(By.xpath(OR.getProperty("block_cart_hover")), driver);
		actual = common.get_text(By.xpath(OR.getProperty("block_cart_hover")), driver);
		Assert.assertEquals(actual, "Cart 1 Product");
		
		common.wait_visibility_of_element(By.xpath(OR.getProperty("product5_img_block_cart")), driver);

		result = common.element_exist(By.xpath(OR.getProperty("product5_img_block_cart")), driver);
		Assert.assertEquals(result, true);
		common.wait_visibility_of_element(By.xpath(OR.getProperty("product1_qty_block_cart")), driver);
		actual = common.get_text(By.xpath(OR.getProperty("product1_qty_block_cart")), driver);
		Assert.assertEquals(actual, "1");

		actual = common.get_text(By.xpath(OR.getProperty("product1_price_block_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("product5_price"));

		actual = common.get_text(By.xpath(OR.getProperty("product1_shipping_block_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("shipping_price"));

		actual = common.get_text(By.xpath(OR.getProperty("overall_cost_block_cart")), driver);
		Assert.assertEquals(actual, testdata.getProperty("product5_overall_cost"));

	}

}
