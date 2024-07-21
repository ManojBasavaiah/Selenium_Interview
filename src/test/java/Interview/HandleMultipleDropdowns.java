package Interview;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class HandleMultipleDropdowns {
    private static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.findElement(By.xpath("//input[@id=\"justAnInputBox\"]")).click();
        List<WebElement> Options1=driver.findElements(By.xpath("//li/span[starts-with(@class,'comboTree')]"));
        selectOptions(Options1,"choice 1, choice 2, choice 2 3");

        driver.findElement(By.xpath("//input[@id=\"justAnInputBox\"]")).click();
        List<WebElement> Options2=driver.findElements(By.xpath("//li/span[starts-with(@class,'comboTree')]"));
        selectOptions(Options2,"all");

        }
    public static void selectOptions(List<WebElement> Options, String... value){
for (WebElement op:Options){
//            if(!value[0].equalsIgnoreCase("all")){
//                String txt=op.getText();
//                for(String val:value){
//                    if(txt.equals(val)){
//                        op.click();
//                        break;
//                    }
//                }
//            }
            if(op.getText().equals(value)){
                op.click();
                break;
            }
        }}
        }


