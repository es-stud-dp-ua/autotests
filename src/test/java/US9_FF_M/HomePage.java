package US9_FF_M;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
			this.driver = driver;
		}
	
	public AskPage gotoSomepage(String text) {
		driver.findElement(By.linkText(text)).click();		
		return new AskPage(driver);
	}
}