package intro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertDemo extends BaseTest{

    @Test
    public void testAlert1(){
        driver.get("https://demoqa.com/alerts");
        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();
        /*Функция alert позволяет вывести какую-либо информацию во всплывающем окне в браузере.
         К таким окнам нельзя добавить стили и разукрасить их. Такое всплывающее окно очень удобно,
         так как оно позволяет быстро и наглядно вывести нужную информацию для пользователя.*/
        Alert alert = driver.switchTo().alert();// через драйвер мы переключаемся на алерт
        alert.accept();// нажимает кнопку ок
        Helper.pause(4000);
    }
    @Test
    public void testExplicitWaitAndAlert(){ // явные ожидания
        driver.get("https://demoqa.com/alerts");
        WebElement alertButton1 = driver.findElement(By.id("timerAlertButton"));
        alertButton1.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));//с помощью этой функции делается явные ожидания
        wait.until(ExpectedConditions.alertIsPresent());// ждем ожинаемые условия пока оно не появится
        Alert alert = driver.switchTo().alert();
        alert.accept(); // это мы кликаем ок в сплывающем окне
    }
    @Test
    public void testAlert2(){
        driver.get("https://demoqa.com/alerts");
        WebElement alertButton2 = driver.findElement(By.id("confirmButton"));
        alertButton2.click();
        Alert alert = driver.switchTo().alert();
        Helper.pause(3000);
        alert.dismiss();// в сплывающем окне нажали кнопку cansel
        WebElement confirmText = driver.findElement(By.id("confirmResult"));
        Assert.assertEquals(confirmText.getText(),"You selected Cancel");
    }
    @Test
    public void testAlert3(){
        driver.get("https://demoqa.com/alerts");
        WebElement alertButton3 = driver.findElement(By.id("promtButton"));
        alertButton3.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Mukashev Atai");
        Helper.pause(3000);
        alert.accept();
        WebElement promtButton = driver.findElement(By.id("promptResult"));
        Assert.assertEquals(promtButton.getText(),"You entered Mukashev Atai");

    }

}
