package intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.By.id;

public class Demo1 {

    @Test
    public void testDemo1(){
        // настройка chrome driver для подключения к браузеру
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver(); // creating instance ChromeDriver
        driver.manage().window().maximize(); // увеличиваем окно в chrome
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //драйвер будет ждать открытия окна 20 секунд
        //если браузер не откроется в течении 20 секунд этот метод выведет ошибку

        driver.get("https://demoqa.com/text-box");

        WebElement fullNameInputField = driver.findElement(id("userName")); // это для ввода имя пользователя в поле. и через html указываем путь

        fullNameInputField.sendKeys("Atai Mukashev"); // вводим имя в поле

        WebElement userEmail = driver.findElement(id("userEmail"));

        userEmail.sendKeys("Vendetta_0929@mail.ru");

        WebElement currentAddress = driver.findElement(id("currentAddress"));

        currentAddress.sendKeys("KG");

        WebElement permanentAddress = driver.findElement(id("permanentAddress"));

        permanentAddress.sendKeys("KG");
         // это для scroll down или up страницу
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");


        WebElement submitButton = driver.findElement(id("submit"));
        submitButton.click();

    }
}
