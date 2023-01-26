package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

// исключения
public class SeleniumExceptions extends BaseTest {

    @Test
    //NoSuchElementException
    public void demo1() {
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.findElement(By.id("userName1")).sendKeys("Hello World");
    }

    @Test
    //NoSuchWindowException
    public void noSuchWindowException() {
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.switchTo().window("Hello");
    }

    @Test
    //NoSuchFrameException
    public void NoSuchFrameException() {
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.switchTo().frame(132);
    }

    @Test
    //NoSuchAlertException
    public void NoSuchAlertException() {
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.switchTo().alert();
    }

    @Test
    //InvalidSelectorException //изза не правильный путь и синтаксическая ошибка
    public void invalidSelectorException() {
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.findElement(By.xpath("//button[type@type='button'][]"));
    }

    @Test
    //noSuchSessionException-метод не смог открыть сесиию
    public void noSuchSessionExceptionTest() {
        driver.quit();
        browserHelper.openURL("https://demoqa.com/text-box");
    }

    @Test
    //ошибка выходит когда ссылаемся на ссылку которая уже устарела потомучто обновился сайт
    public void staleElementReferenceExceptionTest() {
        browserHelper.openURL("https://www.amazon.com/");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
        List<WebElement> allBrands = driver.findElements(By.xpath("//div[@id='brandsRefinements']//ul/li/span/a"));
        int count = 0;
        for (WebElement e : allBrands) {
            count++;
            if (e.getText().contains("SAMSUNG")) {
                driver.findElement(By.xpath("(//div[@id='brandsRefinements']//ul/li/span/a/div/label/i)" + "[" + count + "]")).click();
            }
        }
    }

    @Test
    //ошибка выходит когда драйвер не дождался какогото условия
    public void timeOutExceptionTest() {
        browserHelper.openURL("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter"))).click();
    }

    @Test// Element Not Interactable - это когда element button не активный на сайте
    public void test() {
        browserHelper.openURL("https://demoqa.com/radio-button");
        driver.findElement(By.id("noRadio")).sendKeys("saas");
    }
    @Test//elementClickInterceptedException- это когда мы пытаемся кликнуть на disable button
    public void elementClickInterceptedExceptionTest(){
        browserHelper.openURL("https://demoqa.com/radio-button");
        driver.findElement(By.id("noRadio")).click();
    }


    }
