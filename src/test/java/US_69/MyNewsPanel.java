/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package US_69;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author ЛЕНА
 */
public class MyNewsPanel {
    WebDriver driver;
    
    @FindBy(css="div[dataclass=myNews]+span")
    private WebElement newscount;
    
    @FindBy(className = "icon-bubbles-2")
    private WebElement openNewsBtn;
    
    @FindBy(id = "rightBtn")
    private WebElement rightBtn;
    
    @FindBy(id = "leftBtn")
    private WebElement leftBtn;
    
    @FindBy(className = "ui-tooltip-content")
    private WebElement hint;
    
    
    
    MyNewsPanel(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    String CheckHint()
    {
        try {
        Actions builder = new Actions(driver);
        Action move = builder.moveToElement(openNewsBtn).build();
        move.perform();
        return hint.getText();}
        catch(NoSuchElementException e)
        {
            return null;
        }
    }
    
    int GetNewsCountByIcon()
    {
        try{
        return Integer.parseInt(newscount.getText());}
        catch (NoSuchElementException e)
        {
            return -1;
        }
    }
    
    List<EventInMyNews> GetCurrentNews()
    {
        try
        {
            try
            {
                //проверяем, открыт ли попап
                driver.findElement(By.xpath("html/body/div[5]/div[3]/div/div[2]/div[5]"));
            }
            catch(NoSuchElementException e){openNewsBtn.click(); }

            //находим все ссылки на видимом поп-апе
            List<WebElement> news = driver.findElements(By.cssSelector("div[id^=qtip][aria-hidden=false] .EventContent a>p"));
            List<EventInMyNews> ret = new ArrayList<EventInMyNews>(0);
            for(WebElement e:news)
                ret.add(new EventInMyNews(driver,e,e.getText()));
            return ret;
        }
        catch (NoSuchElementException e)
        {
            return null;
        }
    }
    
    List<EventInMyNews> GetNextNews()
    {
        try{
        openNewsBtn.click();
        rightBtn.click();
        return GetCurrentNews();}
        catch (NoSuchElementException e)
        {
            return null;
        }
    }
    
    List<EventInMyNews> GetPrevNews()
    {
        try{
        openNewsBtn.click();
        leftBtn.click();
        return GetCurrentNews();}
        catch (NoSuchElementException e)
        {
            return null;
        }
    }
    
}
