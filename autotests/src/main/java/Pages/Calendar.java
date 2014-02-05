/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
       @FindBy(css=".left")
      public WebElement back;
      public String SwitchBack(){
         back.findElement(By.cssSelector(".left"));
         back.click();
         month.findElement(By.cssSelector(".month"));
         return month.getText();
         }
      @FindBy(css=".right")
      public WebElement right;
      public String SwitchForward(){
          right.findElement(By.cssSelector(".right")).click();
          month.findElement(By.cssSelector(".month"));
          return month.getText();
      }
     /* public WebElement table;
      public String tableId ="calendarTable";
            public void Testcount() throws Exception {
                         table.findElement(By.id(tableId));
			 List<WebElement> days = table.findElements(By.tagName("tr").cssSelector("#calendarTable"));
		 if (days!=null)
		 {
			 System.out.println(days.size());
		 }
		 else
		 {
			 System.out.print("null");
		 }	
	 }*/
            public WebElement table;
            public String tableId ="calendarTable";
            public int Testcount() throws Exception {
                   table.findElement(By.id(tableId));
                   List<WebElement> days = table.findElements(By.tagName("tr").cssSelector("#calendarTable"));
		   if (days!=null)
		   return days.size();
         return 0;
		 	 	
	 }
            
}
