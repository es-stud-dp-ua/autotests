package US1_TEST;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

/**
 *
 * @author ЛЕНА
 */
public class TestBannerTest {
    public FirefoxDriver driver;
    public String baseURL;
    public String verificationErrors;
    public String[] css={"#firstHeading>span",
                        ".post_title",
                        ".post_title",
                        "#fehl",
                        ".documentClauseText"};
    public String[] text={"Рок-н-ролл",
                        "Краткая история животных на обложках книг O’Reilly",
                        "Бэкдор в роутерах TP-LINK",
                        "Google.com",
                        "(crossfade) – когда два сэмпла, композиции или просто фрагмента являются смежными, либо частично перекрывают"};
    public TestBannerTest() {   
    }
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "H:\\практика\\chromedriver.exe");
        baseURL = "http://109.206.40.61:8080";
         driver = new FirefoxDriver();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.get(baseURL);
    }
    
    @After
    public void tearDown() throws Exception{        
        try
            {
                driver.quit();
            }
            catch (UnreachableBrowserException e)
            {
                System.out.println("Driver has some problems with shutting down. Skipping exception...");
            }
    }

    /**
     * Test of bannertest method, of class TestBanner.
     */
    @Test
    public void testDotButtons() throws Exception{
                driver.get(baseURL+"/");
                List<WebElement> banner = new ArrayList<WebElement>();
                banner.addAll(driver.findElements(By.cssSelector(".pagination > ul > li > a")));
                assertEquals("Error: number of dot buttons is not 5!",banner.size(),5);
                for (WebElement item:banner)
                    item.click();
                
            }
    
    @Test
    public void testLinksUnderImages() throws Exception
    {
        List<WebElement>  banner = driver.findElements(By.cssSelector(".images>a"));
        List<String> links = new ArrayList<String>();
        for (WebElement item : banner)
            links.add(item.getAttribute("href"));               
        for (int i=0;i<5;i++)
        {
            driver.get(links.get(i));
            try
            {
                String expected = driver.findElementByCssSelector(css[i]).getText();
                assertTrue("Error: "+i+" slide: no such text: maybe language of the page is not russian",expected.contains(text[i]) );
            }
            catch(org.openqa.selenium.NoSuchElementException e)
            {
                assertTrue("Error: "+i+" slide: no such css selector: maybe incorrect redirection",false);
            }
        }
    }
}
