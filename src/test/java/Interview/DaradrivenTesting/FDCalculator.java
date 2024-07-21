package Interview.DaradrivenTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.time.Duration;

public class FDCalculator {
    public static void main(String[] args) throws IOException, InterruptedException {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
        ///Alerts
//        driver.switchTo().alert().dismiss();
        driver.findElement(By.xpath("//button[@id=\"wzrk-cancel\"]")).click();
        String filePath = System.getProperty("user.dir")+"/src/testData/caldata.xlsx";
        int rows=excelUtils.getRowCount(filePath,"Sheet1");
        for(int i=1;i<=rows;i++){
            //1) read data from excel
            String principle=excelUtils.getCellData(filePath,"Sheet1",i,0);
            String rateofinterest=excelUtils.getCellData(filePath,"Sheet1",i,1);
            String period1=excelUtils.getCellData(filePath,"Sheet1",i,2);
            String period2=excelUtils.getCellData(filePath,"Sheet1",i,3);
            String  frequency=excelUtils.getCellData(filePath,"Sheet1",i,4);
            String expected_maturity =excelUtils.getCellData(filePath,"Sheet1",i,5);

            //2) send data to application
            driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principle);
            driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateofinterest);
            driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1);
            Select perdrp=new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
            perdrp.selectByVisibleText(period2);
            Select fredrp=new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
            fredrp.selectByVisibleText(frequency);
            //calculate
            driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();

            //3) Validation
            String actual_maturity=driver.findElement(By.xpath("//span[@id=\"resp_matval\"]//strong")).getText();
            if(Double.parseDouble(expected_maturity)==Double.parseDouble(actual_maturity)){
                System.out.println("Test Passed");
                excelUtils.setCellData(filePath,"Sheet1",i,7,"Pass");
                excelUtils.fillGreenColor(filePath,"Sheet1",i,7);
            }else{
                System.out.println("Test Failed");
                excelUtils.setCellData(filePath,"Sheet1",i,7,"Fail");
                excelUtils.fillRedColor(filePath,"Sheet1",i,7);

            }
            Thread.sleep(3000);
            driver.findElement(By.xpath("//img[@class='PL5']")).click();

        }//ending of loop
        driver.quit();
    }
}
