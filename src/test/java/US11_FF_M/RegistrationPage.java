/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package US11_FF_M;

import US11_FF_M.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author ЛЕНА
 */
class RegistrationPage {
    public WebDriver driver;
    public String baseURL = "http://out.dp.ua:8080/ru/registration";

    boolean PortletIsAvaible() {
        try
        {
            return !portletError.getText().contains("временно недоступен");
        }
        catch(NoSuchElementException e)
        {
            return true;
        }
    }

    enum error_kind{firstName, lastName, email, password1, password2};
    
    @FindBy(className="portlet-msg-error")
    private WebElement portletError;
    
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;
    
    @FindBy(id = "lastName")
    private WebElement lastName;
    
    @FindBy(id = "firstName")
    private WebElement firstName;
    
    @FindBy(id="emailAddress")
    private WebElement email;
    
    @FindBy(id="password1")
    private WebElement pass1;
    
    @FindBy(id="password2")
    private WebElement pass2;
    
    @FindBy(className = "splLink")
    private WebElement show_hide_link;
    
    

    RegistrationPage(WebDriver driver) {
        this.driver = driver;
        baseURL = driver.getCurrentUrl()+"registration";
        driver.get(baseURL);
        PageFactory.initElements(driver, this);
    }

   /* boolean isColorChanged()
    {
        
    }*/
    
    void InputRequiredData(String name, String surname, String mail, String password, String confirm_password) {
        lastName.clear();
        lastName.sendKeys(surname);
        firstName.clear();
        firstName.sendKeys(name);
        email.clear();
        email.sendKeys(mail);
        pass1.clear();
        pass1.sendKeys(password);
        pass2.clear();
        pass2.sendKeys(confirm_password);
    }
    
    boolean CheckErrorMessage(error_kind kind, String message)
    {
        try{
            String errXpath = "//*[@class='error' and @for='"+kind+"']";
            return driver.findElement(By.xpath(errXpath)).getText().contains(message);}
        catch(NoSuchElementException e)
        {
            return false;
        }
    }
    
    boolean CheckErrorPresence(error_kind kind)
    {
        try{
            String errXpath = "//*[@class='error' and @for='"+kind+"']";
            driver.findElement(By.xpath(errXpath));
            return true;
        }
        catch(NoSuchElementException e)
        {
            return false;
        } 
    }
    
    RegistrationPage Submit() {
        this.submitButton.click();
        return this;
    }
    
}
