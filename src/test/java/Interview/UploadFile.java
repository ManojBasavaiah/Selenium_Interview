package Interview;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.time.Duration;

public class UploadFile {
    public static void main(String[] args) throws AWTException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //driver.get("https://demo.automationtesting.in/FileUpload.html");
        driver.navigate().to("https://www.filemail.com/share/upload-file");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //using sendkeys --> only if you see file type element
        //driver.findElement(By.xpath("//input[@id='input-4']")).sendKeys("C:\\Users\\manoj\\Downloads\\Ayush Agrawal Resume.pdf-1.pdf");

        // using robot class method
        driver.findElement(By.xpath("//label[@id='addBtn']")).click();
//        You can use JavaScriptExecutor in Selenium when Selenium WebDriver alone can't
//        perform certain operations or interact with web elements.
//        For example, if you're trying to click a button in an automation script but it fails every time,
//        you can use JavaScriptExecutor to resolve the issue.
//        You can also use JavaScriptExecutor when you want to perform actions that Selenium commands can't,
//        such as getting the contents of web elements or clicking on buttons.
        /*JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",button); // click action button as click did not work
        Thread.sleep(10000);*/

        /*
        1) Copy filepath
        2) CTRL + V
        3) ENTER
        */
        Robot rb= new Robot();
        rb.delay(1000);

        // copy ile to clipboard
        StringSelection ss= new StringSelection("C:\\Users\\manoj\\Downloads\\Ayush Agrawal Resume.pdf-1.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);

        // CTRL+V
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        //Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
//        driver.quit();
    }
}
