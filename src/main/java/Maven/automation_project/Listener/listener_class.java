package Maven.automation_project.Listener;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import Maven.automation_project.Driver_class.driver_class;

public class listener_class extends driver_class implements ITestListener {

	public void onTestStart(ITestResult result) {
		result.getName();
		System.out.println("Test Case started="+result.getName());
		
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case pass="+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		
		 if(!result.isSuccess())
		 {
			
			 String userDir = System.getProperty("user.dir");
			 
			String customDir = "\\screenshots\\";
			
			 String screenShotName = userDir+customDir+new SimpleDateFormat("MM-DD-YYYY-HH-MM").format(new GregorianCalendar().getTime())+"-"+result.getMethod().getMethodName()+ ".png";
			
			 File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
				try {
					FileUtils.copyFile(srcFile,new File(screenShotName));
					
				}catch(Exception e) {
					e.printStackTrace();
					
				}
				//String userDirector = System.getProperty("user.dir") + "/";
				   Reporter.log("<a href=\"" + screenShotName + "\"><img src=\"file:///" + screenShotName +"\" alt=\"\"" + "height='100' width='100'/> " + "<br />");
				   //Reporter.log("<a href=\""+ failureImageFileName + "\">");
				   Reporter.setCurrentTestResult(null);
				   Reporter.log(result.getName()+ "--Test method failed\n");
		 }
   
		
	}

	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test Case skipped="+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
	
		
	}

	public void onFinish(ITestContext context) {
		
	}

}
