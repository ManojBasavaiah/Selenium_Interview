package Interview.Javascript_Executor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtils {
    public static void drawBorder(WebElement element, WebDriver driver){
        JavascriptExecutor js =( (JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='3px solid red'",element);
    }
    public static String getTitleByJS(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title =js.executeScript("return document.title;").toString();
        return title;
    }
    public static  void clickElementByJS(WebElement element, WebDriver driver){
        JavascriptExecutor js =( (JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();",element);
    }
    public static void generateAlert(WebDriver driver, String message){
        JavascriptExecutor js =( (JavascriptExecutor) driver);
        js.executeScript("alert('"+message+"')");
    }

    public static void refreshBrowserByJS(WebDriver driver){
        JavascriptExecutor js =( (JavascriptExecutor) driver);
        js.executeScript("history.go(0)");
    }

    public static void scrollPageDown(WebDriver driver){
        JavascriptExecutor js =( (JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public static void scrollPageUp(WebDriver driver){
        JavascriptExecutor js =( (JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    public static void scrollIntoView(WebElement element, WebDriver driver){
        JavascriptExecutor js =( (JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public static void zoomPageByJS(WebDriver driver){
        JavascriptExecutor js =( (JavascriptExecutor) driver);
        js.executeScript("document.body.style.zoom='50%'");
    }

    public void flashElement(WebElement element, WebDriver driver){
        JavascriptExecutor js =( (JavascriptExecutor) driver);
        String flash = "this.style.backgroundColor = 'yellow', 500";
        js.executeScript(flash,element);
    }

    public static void scrollIntoViewAndClick(WebElement element, WebDriver driver){
        JavascriptExecutor js =( (JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        element.click();
    }

}
