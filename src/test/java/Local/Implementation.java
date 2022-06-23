package Local;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Implementation extends Test {
	
	
WebDriver driver;
	
	public Implementation(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void sampleimp() throws Exception
	{
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		searchbar.sendKeys("new songs");
		Thread.sleep(3000);
		searchicon.click();
	}

}
