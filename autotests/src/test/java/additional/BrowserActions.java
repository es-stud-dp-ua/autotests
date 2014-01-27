package additional;


import java.util.Set;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ЛЕНА
 */
public class BrowserActions {
    
    public static void disableCacheFF(final FirefoxProfile firefoxProfile) {
        firefoxProfile.setPreference("browser.cache.disk.enable", false);
        firefoxProfile.setPreference("browser.cache.memory.enable", false);
        firefoxProfile.setPreference("browser.cache.offline.enable", false);
        firefoxProfile.setPreference("network.http.use-cache", false);
    }
    
 /*   public static void deleteCookie(WebDriver driver, String cookieName){
        driver.manage().deleteCookieNamed(cookieName);
    }
    
    public static void disableCookie(final FirefoxProfile profile)
    {
       profile.setPreference("network.cookie.cookieBehavior",2); 
    }
    
    public static void deleteCookie(WebDriver driver, Cookie cookie)
    {
        driver.manage().deleteCookie(cookie);
    }
    
    public static void setCookie(WebDriver driver, String key, String value)
    {
        Cookie cookie = new Cookie(key, value);
        driver.manage().addCookie(cookie);
    }
    
    public static void getCookiesForCurrentDomen(WebDriver driver, String key, String value)
    {
        Set<Cookie> allCookies = driver.manage().getCookies();
    }*/
}
