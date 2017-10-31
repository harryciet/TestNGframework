package Maven.automation_project.Uilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {

	int count = 0;
	String match;
	WebElement element;
	/*
	 * enter_text ok clear_text ok get_text ok get_array/list/set click ok
	 * element_exist_check ok element_dont_exist_check ok compare_text ok
	 * compare_arrays ok wait_for_element_appears explicit wait/smart wait mouse
	 * hover ok window handles dropdown ok iframe file_upload
	 */

	public void click(By by, WebDriver driver) {
		driver.findElement(by).click();

	}
	
	public void wait_visibility_of_element(By by, WebDriver driver) {
		
		WebDriverWait wait= new WebDriverWait (driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));

	}
	
public void wait_invisibility_of_element(By by, WebDriver driver) {
		
		WebDriverWait wait= new WebDriverWait (driver,5);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

	}
	
public int size_elements(By by, WebDriver driver) {
		
		return driver.findElements(by).size();
	}
	
	public boolean is_displayed(By by, WebDriver driver) {
		
		return driver.findElement(by).isDisplayed();
	}

	public List<WebElement> get_list(By by, WebDriver driver) {
		List<WebElement> list = driver.findElements(by);
		return list;
	}

	public void enter_text(By by, WebDriver driver, String testdata) {
		driver.findElement(by).sendKeys(testdata);
	}

	public String get_text(By by, WebDriver driver) {
		return driver.findElement(by).getText();
	}

	public String get_text_through_attribute(By by, WebDriver driver) {
		return driver.findElement(by).getAttribute("outerHTML");
	}

	public void dropdown_select(By by, WebDriver driver, String testdata)

	{
		Select select = new Select(driver.findElement(by));
		select.selectByValue(testdata);

	}

	public void clear(By by, WebDriver driver) {
		driver.findElement(by).clear();
		;

	}

	public boolean element_exist(By by, WebDriver driver) {

		List<WebElement> elements = driver.findElements(by);
		if (elements.size() == 1)
			return true;
		else
			return false;

	}

	public boolean element_does_not_exist(By by, WebDriver driver) {

		List<WebElement> elements = driver.findElements(by);
		System.out.println(elements.size());
		if (elements.size() > 0)
			return false;
		else
			return true;

	}

	public void hover_element(By by, WebDriver driver)

	{
		element = driver.findElement(by);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}

	public boolean arraylist_compare(ArrayList ar1, ArrayList ar2)

	{
		for (int i = 0; i < ar1.size(); i++) {
			for (int j = 0; j < ar2.size(); j++) {

				match = ar1.get(i).toString();
				if (match.equals(ar2.get(j))) {
					count++;
					break;

				}
			}

			// if(ar1.contains(ar2.get(j)))

		}

		if (count == (ar1.size()))
			return true;
		else
			return false;

	}

}
