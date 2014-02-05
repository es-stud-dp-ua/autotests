/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.Test;
/**
 *
 * @author Ксения
 */
public class Calendar {
    
     @FindBy(css=".month")
    public WebElement month;
     public String getCalendarTitle(){
        String title;
         title = month.findElement(By.cssSelector(".month")) .getText();
        return title;
     }
     public WebElement left;
     public void Arrays(){
     String click;
     click = left.
     }
}
