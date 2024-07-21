package Interview;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class handleCookies {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");

        //How to capture cookies from browser
        Set<Cookie> cookies=driver.manage().getCookies();
        System.out.println("Size of cookies"+cookies.size());

        //How to print cookies from browser
        for(Cookie cookie:cookies){
            System.out.println(cookie.getName()+" : "+cookie.getValue());
        }

        //adding cookie
        Cookie cookieObj = new Cookie("Mycookie123","342565");
        driver.manage().addCookie(cookieObj);
        cookies=driver.manage().getCookies();
        System.out.println("Size of cookies"+cookies.size());

        //delete specific cookies
        driver.manage().deleteCookie(cookieObj);
        cookies=driver.manage().getCookies();
        System.out.println("Size of cookies: "+cookies.size());

        //delete all cookies
        driver.manage().deleteAllCookies();
        cookies=driver.manage().getCookies();
        System.out.println("Size of cookies: "+cookies.size());
        driver.quit();
    }
}
