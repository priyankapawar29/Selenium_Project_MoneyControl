package moneyControl;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import CommonMethods.commonMethods;
import Utils.EnvironmentPropertLoader;



public class moneyControlUseCase1 extends moneyControlBaseClass{
	  
	@Test(priority = 1)
	public void loginSuccess() throws IOException {
		moneyControlMainPageObj.login(EnvironmentPropertLoader.getPropertyValue("username"), EnvironmentPropertLoader.getPropertyValue("password"));
		commonMethods.longWait();
		driver.switchTo().defaultContent();
		Assert.assertTrue(moneyControlMainPageObj.successfulLogin());
		moneyControlMainPageObj.logOut();
	}
	
	@Test(priority = 2)
	public void loginFailure() throws IOException {
		moneyControlMainPageObj.login(EnvironmentPropertLoader.getPropertyValue("username"), "password");
		commonMethods.shortWait();
		Assert.assertTrue(moneyControlMainPageObj.invalidCredentials());
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		commonMethods.shortWait();
		
	}

}
