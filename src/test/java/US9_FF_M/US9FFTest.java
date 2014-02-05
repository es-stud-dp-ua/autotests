package US9_FF_M;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class US9FFTest{
  public WebDriver driver;
  public String baseUrl;
  
  @Before
  public void SetUp(){
	/*System.setProperty("webdriver.chrome.driver",
			  "C:\\Users\\User\\Desktop\\JAVATest\\chromedriver.exe");
	driver = new ChromeDriver();*/	
	 driver= new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(Contains.firstpage);
}
   
  @Test
  public void test() throws Exception {
		HomePage home=new HomePage(driver);
		AskPage askpage=home.gotoSomepage("ask question the administrator");
	List <String> captions=Contains.checklan(askpage.searchSignIn());	
   askpage.searchAskBlock();
   askpage.checkLabels(captions);
   askpage.checkANDfillBlocks(Contains.email,Contains.sub,Contains.text);
   askpage.sentData();
   assertEquals(captions.get(3), askpage.resultMsg());   
  }
  
  
  @After
  public void tearDown() throws Exception{
      try{
          driver.quit();
      }
      catch (UnreachableBrowserException e){  
          System.out.println("Driver has some problems with shutting down. Skipping exception...");
      }catch (NullPointerException e){}
  }
}

