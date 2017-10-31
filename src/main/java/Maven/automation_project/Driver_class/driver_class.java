package Maven.automation_project.Driver_class;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class driver_class {
	
	public static WebDriver driver;
	public static Properties OR,testdata;
	public File file;
	public FileInputStream filereader;
	public static  Logger log ;
	

	
    public  void initialization() throws IOException
	
	{    log = Logger.getLogger("devpinoyLogger");
    	loadproperties();
	    selectbrowser(testdata.getProperty("browser"));
		driver.get(testdata.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		 verifytitle();
		
		
	}
	
	public void verifytitle()
	{
		String expected_title=driver.getTitle();
	Assert.assertEquals("My Store",expected_title );
	
	}
	
	public void selectbrowser(String browsername)
	
	{
		if(browsername.equalsIgnoreCase("chrome"))
			
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		    driver=new ChromeDriver();
		    
		}
		
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "/Framework/automation_project/drivers/geckodriver.exe");
		    driver=new FirefoxDriver();
			
			
		}
	}
	
	public void loadproperties() throws IOException
	{
		testdata =new Properties();
	    file = new File(System.getProperty("user.dir")+"/src/main/java/Maven/automation_project/Config/testdata.properties");
	    filereader=new FileInputStream(file);
	    testdata.load(filereader);
	    
	    OR =new Properties();
	    file = new File(System.getProperty("user.dir")+"/src/main/java/Maven/automation_project/Config/xpaths.properties");
	    filereader=new FileInputStream(file);
	    OR.load(filereader);
	}
	
	
	public void closebrowser()
	{
		driver.quit();
	}
	
}
