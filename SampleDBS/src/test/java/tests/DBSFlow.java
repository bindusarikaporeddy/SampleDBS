package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.DBSPage;
import utils.BrowserManager;

public class DBSFlow {
	String url="https://www.dbs.com.sg/personal/cards/default.page";
	@Test
	@Parameters({"browser","url"})
	public void DBS_Sample_Flow_Test() {
		WebDriver driver = BrowserManager.getDriver("chrome", url);
		
		driver.get(url);
		
		DBSPage dbs = PageFactory.initElements(driver, DBSPage.class);
		dbs.navigateToCreditCardsTab();
		dbs.scroll();
		dbs.selectTwoCardsToCompare("DBS Altitude Visa Signature Card", "DBS Black Visa Card");
		Reporter.log("DBS Flow is completed", true);
		driver.close();
		
	}
}
