/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package US_69;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author ЛЕНА
 */
public class NewsPage {
    WebDriver driver;
    String url;
    
    @FindBy(className = "newsHeader")
    private WebElement title;       
    
    NewsPage(WebDriver driver, String url)
    {
        this.driver = driver;
        this.url = url;
        PageFactory.initElements(driver, this);
    }
    
    String Title()
    {
        try{
            driver.get(url);
            return title.getText();
        }
        catch (NoSuchElementException e)
        {
            return null;
        }
    }
}
