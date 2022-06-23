package Local;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BeforeAfter extends Baselinks {
	
	public BeforeAfter()
	{
		PageFactory.initElements(driver, this);
	}
	
	public static WebDriver driver;
	public ExtentReports extent;
	public ExtentHtmlReporter extnthtml;
	public ExtentTest test;
	
	@BeforeTest
	public void m1()
	{
		 extnthtml = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Extentreports/reports.html");
		
		 extent = new ExtentReports();
       
         extent.attachReporter(extnthtml);
        
        
        extent.setSystemInfo("Hostname", "Local host");
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Browser", "chrome");
        extent.setSystemInfo("qa", "vijay");
	}
	
	@BeforeMethod
	public void Sample()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");	
	}
	
	
	
	@AfterMethod
	public void titletest(ITestResult result) throws Exception
	{
		System.out.println(driver);
		
		
		if(result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("FAIL__________");
			test.log(Status.FAIL, "TEST CASE FAILED    "+result.getName());
			Thread.sleep(4000);
		
			String screenshotPath = BeforeAfter.getscreenshot(driver);
			test.log(Status.FAIL, "TEST CASE FAILED     "+ test.addScreenCaptureFromPath(screenshotPath));
			
			test.log(Status.FAIL, result.getTestName());
			Thread.sleep(4000);
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			System.out.println("Skipp__________");
			test.log(Status.SKIP, "TEST CASE SKIPPED "+result.getName());
		}
		
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			System.out.println("success__________");
			test.log(Status.PASS, "TEST CASE success "+result.getName());
		}
		driver.quit();

	}
	@AfterTest
	public void flu()
	{
		extent.flush();
	}
	public static String getscreenshot(WebDriver driver)
	{
		TakesScreenshot tc =(TakesScreenshot)driver;
		File source = tc.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/ScreenShots/"+System.currentTimeMillis()+".png";
		File dest = new File((String) path);
		try {
			FileUtils.copyFile(source, dest);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return path;
		
	}
	
	
	
}
