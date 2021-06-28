package moneyControl;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import CommonMethods.commonMethods;
import Utils.EnvironmentPropertLoader;

public class moneyControlUseCase2 extends moneyControlBaseClass{
  @Test
  public void searchStockdetails() throws IOException {
	String[] shareDetails= {};
	moneyControlMainPageObj.login(EnvironmentPropertLoader.getPropertyValue("username"), EnvironmentPropertLoader.getPropertyValue("password"));
	commonMethods.longWait();
	driver.switchTo().defaultContent();
	Assert.assertTrue(moneyControlMainPageObj.successfulLogin()); 
	
	String[] companyList = commonMethods.ReadColumnFromExcel(EnvironmentPropertLoader.getPropertyValue("moneyControlUC2InputExcel"));
	
	for (int i=0;i<=9;i++) {
		moneyControlHomePageObj.searchStock(companyList[i]);
		shareDetails[i]= shareDetailsPageObj.getShareDetails();
		driver.navigate().back();
	}
	commonMethods.writeRowInExcel(shareDetails, EnvironmentPropertLoader.getPropertyValue("moneyControlUC2OutputExcel"));
	
  }
}
