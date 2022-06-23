package Local;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Baselinks {
	
	@FindBy(xpath = "//input[@class=\"ytd-searchbo\"]")
	WebElement searchbar;
	
	@FindBy(xpath = "//*[@id=\"search-icon-legacy\"]")
	WebElement searchicon;

}
