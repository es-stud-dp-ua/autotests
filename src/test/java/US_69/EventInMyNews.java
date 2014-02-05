/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package US_69;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author ЛЕНА
 */
public class EventInMyNews {
    WebElement link;
    String title;
    WebDriver driver;
    
    EventInMyNews(WebDriver driver, WebElement link, String title)
    {
        this.driver = driver;
        this.link = link;
        this.title = title;
    }
    
    NewsPage GetEvent()
    {
        try{
        link.click();
        return new NewsPage(driver, driver.getCurrentUrl());}
        catch (NoSuchElementException e)
        {
            return null;
        }
    }
}
