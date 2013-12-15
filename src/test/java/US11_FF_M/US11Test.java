/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package US11_FF_M;

import java.util.Arrays;
import java.util.Collection;
import org.junit.runners.Parameterized.Parameters;
import US11_FF_M.RegistrationPage.error_kind;
import additional.BrowserActions;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.UnreachableBrowserException;
/**
 *
 * @author ЛЕНА
 */
@RunWith(value = Parameterized.class)
public class US11Test {
    public static WebDriver driver;
    public String name, surname, email, password, confurm_password; 
    public String errMsg;
    public error_kind kind;
    
    public US11Test(String name, String surname, String email, String password, String confurm_password, String errMsg, error_kind kind)
    {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.confurm_password = confurm_password;
        this.errMsg = errMsg;
        this.kind = kind;
    }
    
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { 
            { "","surname","fake@gmail.com","1234","1234"," ",error_kind.firstName } ,
            { "name","","fake@gmail.com","1234","1234", " ", error_kind.lastName}/* ,
            { "name","surname","fake@gmail.com","1234","1", "Passwords do not match", error_kind.password1 } ,
            { "name","surname","РјРѕР¶РµС@bk.ru","1234","1234","must be not empty",error_kind.email } ,
            { "name","surname","this is\"not\\allowed@example.com","1234","1234" ,"must be not empty",error_kind.email} ,
            { "name","surname","A@b@c@example.com","1234","1234","must be not empty",error_kind.email } ,
            { "name","surname","just\"not\"right@example.com ","1234","1234","must be not empty",error_kind.email } ,
            { "name","surname","Abc..123@example.com ","1234","1234","must be not empty",error_kind.email } */
        };
	return Arrays.asList(data);
    }

    @Before
    public void setUp() {
        //final DesiredCapabilities firefox = DesiredCapabilities.firefox();
         final FirefoxProfile firefoxProfile = new FirefoxProfile();
         BrowserActions.disableCacheFF(firefoxProfile);
         if (driver==null) 
            driver = new FirefoxDriver(firefoxProfile);
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         MainPage m = new MainPage(driver);
    }
    
    @AfterClass
    public static void tearDown() throws Exception{        
        try
            {
                driver.quit();
            }
            catch (UnreachableBrowserException e)
            {
                System.out.println("Driver has some problems with shutting down. Skipping exception...");
            }
    }
    
     @Test/*(dataProvider = "parseLocaleData")*/
    public void testFieldsPresent() throws Exception
    {
        RegistrationPage r = new RegistrationPage(driver);
        r.InputRequiredData(name, surname, email, password, confurm_password);
        r = r.Submit();
        Assert.assertTrue("ERROR!! portlet is no avaible!",r.PortletIsAvaible());
        Assert.assertTrue("ERROR!! no error message when it is need!", r.CheckErrorPresence(kind));
        Assert.assertTrue("ERROR!! error text doesn't match!",r.CheckErrorMessage(kind, errMsg));
    }
    
}
