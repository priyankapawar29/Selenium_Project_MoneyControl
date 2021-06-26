package moneyControl;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import CommonMethods.commonMethods;
import Utils.EnvironmentPropertLoader;

public class moneyControlUseCase2 extends moneyControlBaseClass{
  @Test
  public void searchStockdetails() throws IOException {
	moneyControlMainPageObj.login(EnvironmentPropertLoader.getPropertyValue("username"), EnvironmentPropertLoader.getPropertyValue("password"));
	commonMethods.longWait();
	driver.switchTo().defaultContent();
	Assert.assertTrue(moneyControlMainPageObj.successfulLogin()); 
	moneyControlHomePageObj.searchStock(null);
	String[] companyList = commonMethods.ReadColumnFromExcel(EnvironmentPropertLoader.getPropertyValue("moneyControlUC2InputExcel")); 
	for (String comapnay : companyList) {
		moneyControlHomePageObj.searchStock(comapnay);
		
	}
  }
}
