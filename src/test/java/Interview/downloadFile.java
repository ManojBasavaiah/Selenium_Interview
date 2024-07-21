package Interview;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;

public class downloadFile {
    public static void main(String[] args) {
        String location=System.getProperty("user.dir")+"src/testData/Downloads";
        //chrome
        HashMap preferences=new HashMap();
        preferences.put("plugins.always_open_pdf_externally",true);
        preferences.put("download.default_directory",location);

         ChromeOptions options=new ChromeOptions();
         options.setExperimentalOption("prefs",preferences);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://demoqa.com/upload-download");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.linkText("Download")).click();

    }
}
