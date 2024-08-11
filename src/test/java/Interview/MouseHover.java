package Interview;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class MouseHover {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/");
        WebElement desktop=driver.findElement(By.xpath("//a[text()='Desktops']"));
        WebElement Mac=driver.findElement(By.xpath("//a[text()='Mac (1)']"));
        Actions actions =new Actions(driver);
        String tab=Keys.chord(Keys.CONTROL,Keys.RETURN);
        actions.moveToElement(desktop).moveToElement(Mac).perform();
        Mac.sendKeys(tab);
        Set<String> windowIDs=driver.getWindowHandles();
        Iterator<String> it =windowIDs.iterator();
        String ParentID=it.next();
        System.out.println(ParentID+" : "+driver.getTitle());
        Thread.sleep(1000);
        String ChildID=it.next();
        System.out.println(ChildID+" : "+driver.getTitle());
        driver.switchTo().window(ChildID);
        System.out.println(driver.getCurrentUrl()+ " : " + driver.getTitle());
//        driver.quit();
    }
}
