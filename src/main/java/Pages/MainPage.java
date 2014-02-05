/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Ксения
 */
public class MainPage extends Page{
    Banner banner;
    Microblog microblog;
    
    @FindBy(css=".eventLink")
    List<WebElement> events;
    
    private WebElement getEvent(int index){
        return events.get(index);
    }
    
    /* remember title, click link and return title*/
    public String getEventTitle(int index){
        String title = events.get(index).findElement(By.className("eventLink")) .getText();
        //String title = getEvent(index).findElement(By.cssSelector(.eventLink))
        events.get(index).click();
        return title;
    }
    public String getEventInfo(int index){
        String info = events.get(index).findElement(By.className("eventLink")).getText();
        return info;
    }
            
    public int getEventCount(){
        return events.size();
    }
    
}
