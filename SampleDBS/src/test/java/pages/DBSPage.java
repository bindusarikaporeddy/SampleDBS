package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

public class DBSPage {
	WebDriver driver;
	
	public DBSPage(WebDriver driver) {
		this.driver= driver;
	}
	
	public By creditCards = By.xpath("//a[contains(@href,'cards-comparator') and text()='Credit Cards']");
	public By altitudeVisa = By.xpath("//input[@data-title='DBS Altitude Visa Signature Card']//following::label[1]//child::span");
	public By blackVisa = By.xpath("//input[@data-title='DBS Black Visa Card']//following::label[1]//child::span");
	public By compareBtn = By.xpath("//button[text()='Compare']");
	
	
	public static void scrollToView(WebElement ele, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}
	
	
	public boolean navigateToCreditCardsTab() {
		try {
			driver.findElement(creditCards).click();
			Reporter.log("Credit Cards tab is clicked", true);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void scroll() {
		scrollToView(driver.findElement(altitudeVisa), driver);
		Reporter.log("Browser scrolled to view the contents", true);
	}
	
//	public void clickMethod(WebElement element) {
//		WebElement ele = driver.findElement(By.xpath(element));
//		ele.isDisplayed();
//		ele.click();
//	}
	public boolean selectTwoCardsToCompare(String type1, String type2) {
		try {
			WebElement cardType1 = driver.findElement(By.xpath("//input[@data-title='"+type1+"']//following::label[1]//child::span"));
			WebElement cardType2 = driver.findElement(By.xpath("//input[@data-title='"+type2+"']//following::label[1]//child::span"));
			
			boolean card1 = cardType1.isDisplayed();
			boolean card2 = cardType2.isDisplayed();
			
			Assert.assertTrue(card1, "First card should be visible for comparision");
			Assert.assertTrue(card2, "Second card should be visible for comparision");
			
			
			cardType1.click();
			cardType2.click();
			Reporter.log("Two cards are selected to compare", true);
			driver.findElement(compareBtn).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
