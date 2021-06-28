package moneyControlWebsite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class shareDetailsPage {
	WebDriver driver;
	
	@FindBy(how= How.XPATH, using= "//*[@id=\"stockName\"]/h1")
	WebElement companyName;
	
	@FindBy(how=How.XPATH, using= "//*[@id=\"stk_overview\"]/div[1]/div/div[1]/table/tbody/tr[2]/td[2]")
	WebElement previousClose;
	
	@FindBy(how=How.XPATH, using= "//*[@id=\"stk_overview\"]/div[1]/div/div[1]/table/tbody/tr[1]/td[2]")
	WebElement openPrice;
	
	public shareDetailsPage(WebDriver driver) {
		this.driver= driver;
	}
	
	public String getShareDetails(){
		String shareDetails;
		shareDetails = companyName.getText()+","+previousClose.getText()+","+openPrice.getText();
		return shareDetails;
	}

}
