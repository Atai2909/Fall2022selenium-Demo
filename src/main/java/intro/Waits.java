package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Waits extends BaseTest {

    @Test
    // явное ожидание
    public void testExplicitWait() {

        driver.navigate().to("https://demoqa.com/dynamic-properties");

        WebElement enableAfter = driver.findElement(By.id("enableAfter"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(enableAfter)).click();// ждем пока этот элемент будет кликабельным
        //Ожидаемые условия

        wait.until(ExpectedConditions.attributeContains(By.id("colorChange"),"class","text-danger"));
        // тут мы ждем пока у данного атрибута не поменяется цвет по тому value когда он поменяется
        WebElement colorChange = driver.findElement(By.id("colorChange"));
        colorChange.click();

//        wait.until(ExpectedConditions.attributeContains(By.id("visibleAfter"),"class","mt-4 btn"));
//        Assert.assertEquals("Visible After 5 Seconds","Visible After 5 Seconds");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("visibleAfter"))).click();
        // тут мы ждем пока не появиться элемент или кнопка
    }
    @Test
    public void singIn(){
        driver.get("https://www.etsy.com/");
        WebElement singIn1 = driver.findElement(By.xpath(".//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']"));
        singIn1.click();

        WebElement Email = driver.findElement(By.id("join_neu_email_field"));
        Email.sendKeys("Atay@gmail.com");

        Helper.pause(2);

        WebElement password = driver.findElement(By.id("join_neu_password_field"));
        password.sendKeys("Atai123456");
    }
}
