package Interview.Basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class locators {
    private WebDriver driver;

    public void initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void launch() throws InterruptedException {
        driver.navigate().to("https://www.google.com/");
        Thread.sleep(200);
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("selenium");
        List<WebElement> E = driver.findElements(By.xpath("//ul[@role=\"listbox\"]/li"));
        System.out.println(E.size());
        String actualValue = null;
        for (int i = 0; i < E.size(); i++) {
            System.out.println(E.get(i).getText());
            actualValue = String.valueOf((E.get(i).getText().contains("selenium download")));
        }
        String expectedValue = "Sele";
        assert expectedValue.equals(actualValue) : "Expected title: " + expectedValue + ", but got: " + actualValue;
    }

    public void close() {
        driver.quit();
    }
}





