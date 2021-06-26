package moneyControlWebsite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class shareDetailsPage {
	WebDriver driver;
	
	@FindBy(how= How.XPATH, using= "//*[@id=\"stockName\"]/h1")
	WebElement companyName;
	
	public shareDetailsPage(WebDriver driver) {
		this.driver= driver;
	}

}
