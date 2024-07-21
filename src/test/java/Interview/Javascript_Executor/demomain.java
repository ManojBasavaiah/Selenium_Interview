package Interview.Javascript_Executor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class demomain {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Dwaring border
        WebElement logo= driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        JavascriptUtils.drawBorder(logo,driver);
        //screenshot
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File trg=new File(".\\Screenshots\\logo.png");
        FileUtils.copyFile(src,trg);

        //getTtile
        String title=JavascriptUtils.getTitleByJS(driver);
        System.out.println(title);

        //clickElement
        JavascriptUtils.clickElementByJS(logo,driver);

        //Alert
        JavascriptUtils.generateAlert(driver,"Alert");

        //refresh
        JavascriptUtils.refreshBrowserByJS(driver);

        //scrollPageDown
        JavascriptUtils.scrollPageDown(driver);
        Thread.sleep(1000);
        //ScrollPageUp
        JavascriptUtils.scrollPageUp(driver);
        //zoom
        JavascriptUtils.zoomPageByJS(driver);
        //flash
        //JavascriptUtils.flashElement(logo,driver);
        //scrollIntoView
        JavascriptUtils.scrollIntoView(logo,driver);
        //scrollIntoViewAndClick
        JavascriptUtils.scrollIntoViewAndClick(logo,driver);
    }
}
