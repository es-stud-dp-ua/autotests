package US9_FF_M;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class AskPage {
	private WebDriver driver;



	public AskPage(WebDriver driver) {
	this.driver=driver;	
	}



	public String searchSignIn() {		
		return driver.findElement(By.xpath(Contains.signLink)).getText();
	}


	public void searchAskBlock() {	
		driver.findElement(By.id(Contains.askBlock));	
	}



	public void checkLabels(List <String> captions) {
		try{  
		    List<WebElement> webText = driver.findElements(By.xpath(Contains.labels));
			  Assert.assertEquals(3, webText.size());  

		      String errorstring="Неосответствие надписи блока для введения";
		      Assert.assertEquals(errorstring+" email",captions.get(0),webText.get(0).getText());
		      Assert.assertEquals(errorstring+" темы",captions.get(1),webText.get(1).getText());
		      Assert.assertEquals(errorstring+" текста письма",captions.get(2),webText.get(2).getText());  
		} catch (Exception e) {System.out.println("Блоки для ввода не подписаны");} 
		
	}



	public void checkANDfillBlocks(String email, String subject, String text) {
		try{  
	  	    WebElement form1 = driver.findElement(By.id(email));
	        WebElement form2 = driver.findElement(By.id(subject));
	        WebElement form3 = driver.findElement(By.id(text));
	        
	    form1.sendKeys(Contains.emailFILL);    
	    form2.sendKeys(Contains.subjectFILL);  
	    form3.sendKeys(Contains.textFILL); 
	    form1.click();
	    driver.findElement(By.xpath(Contains.btnOK));   
	} catch (NoSuchElementException e){System.out.println("Отсутствуют блоки для ввода данных или они не принимают данные");}
	catch (WebDriverException e){System.out.println("Блоки для ввода данных не принимают данные");}
	}



	public void sentData() {
		 driver.findElement(By.xpath(Contains.sentbtn)).click();	
	}



	public String resultMsg() {
	return driver.findElement(By.xpath(Contains.lastMSG)).getText();
		
	}

}