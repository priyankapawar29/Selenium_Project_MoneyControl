package moneyControlWebsite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Priyanka Pawar
 *
 */
public class moneyControlHomePage {
	WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "(//input[@id=\"companyname\"])[1]")
	WebElement searchStockCompanyName;
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"compsearch\"]/div[3]/input")
	WebElement searchStockSearchClick;
	
	public moneyControlHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchStock(String companyName) {
		searchStockCompanyName.sendKeys(companyName);
		searchStockSearchClick.click();
	}
}
