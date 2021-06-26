package moneyControl;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import CommonMethods.commonMethods;
import Utils.EnvironmentPropertLoader;
import moneyControlWebsite.moneyControlHomePage;
import moneyControlWebsite.moneyControlMainPage;

public class moneyControlBaseClass {
	WebDriver driver = null;
	protected static moneyControlMainPage moneyControlMainPageObj;
	protected static moneyControlHomePage moneyControlHomePageObj;
  
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void setUp() throws IOException {
		
		System.setProperty("webdriver.gecko.driver","src\\main\\resources\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(EnvironmentPropertLoader.getPropertyValue("moneyControlWebsite"));
		driver.findElement(By.xpath("/html/body/div/div[1]/span/a")).click();
		commonMethods.longWait();
		moneyControlMainPageObj	= PageFactory.initElements(driver, moneyControlMainPage.class);
		moneyControlHomePageObj = PageFactory.initElements(driver, moneyControlHomePage.class);
	}
	
		
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
