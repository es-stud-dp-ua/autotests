/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package US_69;

import additional.BrowserActions;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import US11_FF_M.MainPage;
import US11_FF_M.MainPage.language;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.remote.UnreachableBrowserException;

/**
 *
 * @author ЛЕНА
 */
public class US_69Test {
    public static WebDriver driver;
    
    @Before
    public void setUp() {
        //final DesiredCapabilities firefox = DesiredCapabilities.firefox();
        final FirefoxProfile firefoxProfile = new FirefoxProfile();
        BrowserActions.disableCacheFF(firefoxProfile);
        if (driver==null) 
        {
            driver = new FirefoxDriver(firefoxProfile);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        MainPage m  = new MainPage(driver);
        if (!MainPage.IsAutorised())
            m.signIn("test@liferay.com", "test");
        m.SetLanguage(language.ru);
        Assert.assertTrue("Error: autorisation failed!",MainPage.IsAutorised());
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
    
        
    @Test
    public void HintTest()
    {        
        MyNewsPanel p = new MyNewsPanel(driver);
        String pop_up_text = p.CheckHint();
        Assert.assertTrue(pop_up_text, pop_up_text.contains("Мои новости"));
    }
    
    @Test
    public void TestNextBtn()
    {
        MyNewsPanel p = new MyNewsPanel(driver);
        int iconNewsCount = p.GetNewsCountByIcon();
        int actualNewsCount=0;
        List<EventInMyNews> news = new ArrayList();
        news.addAll(p.GetCurrentNews());
        actualNewsCount += news.size();
        String firstTitle = news.get(0).title;
        news.clear();
        news.addAll(p.GetNextNews());
        while (!firstTitle.equals(news.get(0).title))
        {
            actualNewsCount += news.size();
            news.clear();
            news.addAll(p.GetNextNews());
        }
        Assert.assertEquals("ERROR! number of news in pages and in control icon don't match!", actualNewsCount, iconNewsCount);
    }
    
    @Test
    public void TitlesMatchTest()
    {
        Assert.assertTrue("You are noy autorised!", MainPage.IsAutorised());
        MyNewsPanel p = new MyNewsPanel(driver);
        if (p.GetNewsCountByIcon()!=-1)
        {
            EventInMyNews e = p.GetCurrentNews().get(0);
            String title = e.title;
            Assert.assertEquals("ERROR! Titles do not match!", title, e.GetEvent().Title()); 
        }
        else 
            Assert.assertTrue("There is no news!", false);
    }
    
    @Test
    public void NewsCountIcon()
    {
        MyNewsPanel p = new MyNewsPanel(driver);
        Assert.assertNotEquals("There are no news or no icon!", p.GetNewsCountByIcon(), -1);
    }
}
