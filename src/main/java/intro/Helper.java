package intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Helper {

   private static JavascriptExecutor js;


    public static void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void jsClick(WebDriver driver, WebElement element){
         js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
    }

    public static void jsScrollDown(WebDriver driver){
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0.250)","");

    }
}
