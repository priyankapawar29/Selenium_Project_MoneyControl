/**
 * 
 */
package moneyControlWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import CommonMethods.commonMethods;

/**
 * @author Priyanka Pawar
 *
 */
public class moneyControlMainPage {
	
	WebDriver driver;
	
	@FindBy(how=How.LINK_TEXT, using = "Hello, Login")
	WebElement helloLogin;
	
	@FindBy (how=How.LINK_TEXT, using = "Log-in")
	WebElement login;
	
	@FindBy (how=How.XPATH, using = "(//*[@id='email'])[2]")
	WebElement usernameTextbox;
	
	@FindBy (how=How.XPATH, using = "//*[@id=\"login_form\"]//*[@id=\"pwd\"]")
	WebElement passwordTextbox;
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"ACCT_LOGIN_SUBMIT\"]")
	WebElement loginButton;
	
	@FindBy(how=How.XPATH, using = "//span[@class=\"usr_nm\"]")
	WebElement usernameDislapyed;
	
	@FindBy(how=How.XPATH, using = "(//*[@id=\"error_api\"])[2]")
	WebElement loginFailmsg;
	
	@FindBy(how=How.XPATH, using = "(//*[@id=\"LoginModal\"]/div/div/button)[1]")
	WebElement closeLoginWindow;
	
//	@FindBy(how=How.XPATH, using = "(//*[@title=\"Logout\"])[2]")
	@FindBy(how=How.LINK_TEXT, using = "Logout")
	WebElement logOut;
	
	@FindBy(how=How.XPATH, using = "/html/body/div/div[1]/span/a")
	WebElement continueToMoneyControl;
	
	public moneyControlMainPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String username, String password) {
		
		Actions action = new Actions(driver);
		action.moveToElement(helloLogin).perform();
		commonMethods.shortWait();
		action.moveToElement(login).click().build().perform();
		commonMethods.longWait();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"myframe\"]")));
		usernameTextbox.sendKeys(username);
		passwordTextbox.sendKeys(password);
		loginButton.click();
	}
	
	public boolean successfulLogin() {
		if (usernameDislapyed.getText().contains("Hi")) {
			return true;
		}
		return false;
	}
	
	public boolean invalidCredentials() {
		if (loginFailmsg.getText().contains("Invalid User Id/EmailID or Password. Please try again.")) {
			return true;
		}
		return false;
	}
	
	public void logOut() {
		Actions action = new Actions(driver);
		action.moveToElement(usernameDislapyed).perform();
		commonMethods.shortWait();
		action.moveToElement(logOut).click().build().perform();
		commonMethods.shortWait();
	}
	
	public void closeLoginWindow() {
		Actions action = new Actions(driver);
		action.moveToElement(closeLoginWindow).click().build().perform();
	}

}
