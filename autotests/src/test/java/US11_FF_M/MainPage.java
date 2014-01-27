/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package US11_FF_M;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author ЛЕНА
 */
public class MainPage {
    WebDriver driver;
    
    @FindBy(className="graystyle")
    private static WebElement signIn;
    
    @FindBy(css=".sign-out>a")
    private static WebElement signOut;
    
    @FindBy(id="_58_login")
    private WebElement login;
    
    @FindBy(id="_58_password")
    private WebElement passw;
    
    @FindBy(css=".aui-button-input.aui-button-input-submit")
    private WebElement signBtn;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://out.dp.ua:8080/ru/");
        PageFactory.initElements(driver, this);
    }
    
    public void signIn(String mail, String password)
    {
        signIn.click();//нажали на сссылку на страницу
        login.clear();
        login.sendKeys(mail);
        passw.clear();
        passw.sendKeys(password);
        signBtn.click();
    }
    
    public static void signOut()
    {
        try
        {
            signOut.click();
        }
        catch (NoSuchElementException e) { }
    }
    
    public static boolean IsAutorised()
    {
        try
        {
            signIn.click();
            return false;
        }
        catch (NoSuchElementException e)
        {
            return true;
        }
    }
    
}
