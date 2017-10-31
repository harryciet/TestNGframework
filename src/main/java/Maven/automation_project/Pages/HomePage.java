package Maven.automation_project.Pages;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Maven.automation_project.Driver_class.driver_class;
import Maven.automation_project.Uilities.CommonFunctions;

public class HomePage extends driver_class {

	WebDriver driver;
	CommonFunctions common;
	String actual;
	boolean result;
	ArrayList<String> ar_testdata;
	ArrayList<String> ar_actual;
	String cost;
	Iterator<String> iter1;
	String actualmsg;

	public HomePage(WebDriver driver) {

		this.driver = driver;
	}

	public void click_shopnow() throws Exception {

		common = new CommonFunctions();
		System.out.println(common.is_displayed(By.xpath(OR.getProperty("shopnow_bttn")), driver));
		common.wait_visibility_of_element(By.xpath(OR.getProperty("shopnow_bttn")), driver);
		common.click(By.xpath(OR.getProperty("shopnow_bttn")), driver);
		result=common.element_exist(By.xpath(OR.getProperty("prestashop_text")), driver);
		Assert.assertEquals(result, true);
	
		driver.navigate().back();

	}

	public String accnt_confirmation() {

		ar_testdata = new ArrayList<String>();
		ar_testdata.add(testdata.getProperty("Product1_cost"));
		ar_testdata.add(testdata.getProperty("Product2_cost"));
		ar_testdata.add(testdata.getProperty("Product3_cost"));
		ar_testdata.add(testdata.getProperty("Product4_cost"));
		ar_testdata.add(testdata.getProperty("Product5_cost"));
		ar_testdata.add(testdata.getProperty("Product6_cost"));
		ar_testdata.add(testdata.getProperty("Product7_cost"));

		iter1 = ar_testdata.iterator();

		/*
		 * for(int i=0;i<ar_testdata.size();i++) {
		 * System.out.println(iter1.next()); }
		 */

		while (iter1.hasNext()) {
			System.out.println(iter1.next());
		}
		return null;

		/*
		 * String actual=common.get_text(By.xpath(
		 * "//ul[@id='homefeatured']//a[@class='quick-view' and @ href='http://automationpractice.com/index.php?id_product=1&controller=product']/following-sibling::div/span[1]"
		 * ), driver); System.out.println(actual);
		 * 
		 * System.out.println("Mohit"); return actual;
		 */

	}

	public void validate() throws InterruptedException {
		ar_actual = new ArrayList<String>();

		common = new CommonFunctions();

		common.hover_element(By.xpath(OR.getProperty("Prod_image1")), driver);
		cost = common.get_text(By.xpath(OR.getProperty("Product1")), driver);
		ar_actual.add(cost);

		common.hover_element(By.xpath(OR.getProperty("Prod_image2")), driver);
		cost = common.get_text(By.xpath(OR.getProperty("Product2")), driver);
		ar_actual.add(cost);

		common.hover_element(By.xpath(OR.getProperty("Prod_image3")), driver);
		cost = common.get_text(By.xpath(OR.getProperty("Product3")), driver);
		ar_actual.add(cost);

		common.hover_element(By.xpath(OR.getProperty("Prod_image4")), driver);
		cost = common.get_text(By.xpath(OR.getProperty("Product4")), driver);
		ar_actual.add(cost);

		common.hover_element(By.xpath(OR.getProperty("Prod_image5")), driver);
		cost = common.get_text(By.xpath(OR.getProperty("Product5")), driver);
		ar_actual.add(cost);

		common.hover_element(By.xpath(OR.getProperty("Prod_image6")), driver);
		cost = common.get_text(By.xpath(OR.getProperty("Product6")), driver);
		ar_actual.add(cost);

		common.hover_element(By.xpath(OR.getProperty("Prod_image7")), driver);
		cost = common.get_text(By.xpath(OR.getProperty("Product7")), driver);
		ar_actual.add(cost);

		iter1 = ar_actual.iterator();

		/*
		 * for(int i=0;i<ar_testdata.size();i++) {
		 * System.out.println(iter1.next()); }
		 */

		while (iter1.hasNext()) {
			System.out.println(iter1.next());
		}
		boolean Result = common.arraylist_compare(ar_testdata, ar_actual);
		if (Result == true) {
			System.out.println("chal gya");
			Assert.assertTrue(true, "Arrays are equal");
		} else {
			Assert.assertTrue(false, "Arrays are equal");
		}

	}

	public void enquiry() throws Exception

	{
		log.debug("reached in enquiry method");
		log.warn("gives warning");

		common = new CommonFunctions();
		common.click(By.xpath(OR.getProperty("contact_us_bttn")), driver);
		actualmsg = common.get_text(By.xpath(OR.getProperty("service_msg")), driver);

		Assert.assertEquals(actualmsg, "CUSTOMER SERVICE - CONTACT US");
		common.dropdown_select(By.xpath(OR.getProperty("subject_heading")), driver,
				testdata.getProperty("subject_drop"));

		common.enter_text(By.xpath(OR.getProperty("email_address")), driver, testdata.getProperty("email_testdata"));
		common.enter_text(By.xpath(OR.getProperty("order_ref")), driver, testdata.getProperty("order_ref_data"));
		common.enter_text(By.xpath(OR.getProperty("upload_choosefile")), driver, testdata.getProperty("file_path"));

		common.enter_text(By.xpath(OR.getProperty("message_text")), driver, testdata.getProperty("message_input"));

		common.click(By.xpath(OR.getProperty("send_bttn")), driver);

		actualmsg = common.get_text(By.xpath(OR.getProperty("success_alert")), driver);

		Assert.assertEquals(actualmsg, "Your message has been successfully sent to our team.");

		common.click(By.xpath(OR.getProperty("home_bttn")), driver);

	}

	public void order() throws Exception

	{

		common = new CommonFunctions();
		common.hover_element(By.xpath(OR.getProperty("Prod_image1")), driver);

		common.click(By.xpath(OR.getProperty("addtocart_product1_bttn")), driver);
		// actualmsg=common.get_text(By.xpath("//span[@class='cross']/following-sibling::h2"),driver);
		// actualmsg=common.get_text(By.xpath(OR.getProperty("product_add_check")),driver);
		// System.out.println(actualmsg);
		// Assert.assertEquals(actualmsg,"Product successfully added to your
		// shopping cart");

		common.wait_visibility_of_element(By.xpath(OR.getProperty("product_proceed_bttn")), driver);

		common.click(By.xpath(OR.getProperty("product_proceed_bttn")), driver);
		actualmsg = common.get_text(By.xpath(OR.getProperty("summary_check")), driver);
		System.out.println(actualmsg);
		actualmsg = (String) actualmsg.subSequence(0, 21);
		Assert.assertEquals(actualmsg, "SHOPPING-CART SUMMARY");
		common.click(By.xpath(OR.getProperty("summary_proceed_bttn")), driver);

		actualmsg = common.get_text(By.xpath(OR.getProperty("signin_check")), driver);
		Assert.assertEquals(actualmsg, "AUTHENTICATION");
		common.enter_text(By.xpath(OR.getProperty("alreadyreg_emailaddress")), driver,
				testdata.getProperty("emailaddress"));
		common.enter_text(By.xpath(OR.getProperty("login_password")), driver, testdata.getProperty("password"));
		common.click(By.xpath(OR.getProperty("submit_loginbutton")), driver);

		actualmsg = common.get_text(By.xpath(OR.getProperty("address_check")), driver);
		Assert.assertEquals(actualmsg, "ADDRESSES");
		common.click(By.xpath(OR.getProperty("address_proceed_bttn")), driver);
		
		common.wait_visibility_of_element(By.xpath(OR.getProperty("shipping_check")), driver);

	//	Thread.sleep(3000);
		actualmsg = common.get_text(By.xpath(OR.getProperty("shipping_check")), driver);
		Assert.assertEquals(actualmsg, "SHIPPING");
		common.click(By.xpath(OR.getProperty("shipping_checkbox")), driver);
		common.click(By.xpath(OR.getProperty("shipping_proceed_bttn")), driver);

		actualmsg = common.get_text(By.xpath(OR.getProperty("payment_check")), driver);
		Assert.assertEquals(actualmsg, "PLEASE CHOOSE YOUR PAYMENT METHOD");
		common.click(By.xpath(OR.getProperty("payby_bank")), driver);

		actualmsg = common.get_text(By.xpath(OR.getProperty("order_sumamry_check")), driver);
		Assert.assertEquals(actualmsg, "ORDER SUMMARY");
		common.click(By.xpath(OR.getProperty("order_confirm")), driver);

		actualmsg = common.get_text(By.xpath(OR.getProperty("order_confirm_check")), driver);
		Assert.assertEquals(actualmsg, "ORDER CONFIRMATION");
		actualmsg = common.get_text(By.xpath(OR.getProperty("complete_order_check")), driver);
		Assert.assertEquals(actualmsg, "Your order on My Store is complete.");
		common.click(By.xpath(OR.getProperty("logo")), driver);
		

	}

	public void discounted_item_price_check() throws Exception {

		common = new CommonFunctions();
		//common.wait_visibility_of_element(By.xpath(OR.getProperty("Prod_image5")), driver);

		common.hover_element(By.xpath(OR.getProperty("Prod_image5")), driver);
	

		ArrayList<String> product_prices = new ArrayList<String>();
		List<WebElement> product_prices_data = common.get_list(By.xpath(OR.getProperty("product5_prices_data")),
				driver);
		for (WebElement w : product_prices_data) {
			product_prices.add(w.getText());
		}
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		System.out.print(product_prices);
		float discounted_price = Float.parseFloat(product_prices.get(0).substring(1));
		float old_price = Float.parseFloat(product_prices.get(1).substring(1));
		int discount = Integer.parseInt(product_prices.get(2).substring(1, 2));
		float actual_price= (float) (old_price * 0.95);
		float twoDigitsF = Float.valueOf(decimalFormat.format(actual_price));

		if (discounted_price == twoDigitsF) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

}
