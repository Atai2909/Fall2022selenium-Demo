package intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Glovo {
    WebDriver driver;

    @Test
    public void testGlovo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // creating instance ChromeDriver
        driver.manage().window().maximize(); // увеличиваем окно в chrome
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://glovoapp.com/");

        WebElement startRegistration = driver.findElement(By.xpath("(//button[@id='user-register'])[2]"));
        startRegistration.click();

        WebElement inputName = driver.findElement(By.xpath("//*[@id='signup-name']/div/input"));
        inputName.sendKeys("Mukashev Atai");

        WebElement inputEmail = driver.findElement(By.xpath("//*[@id='signup-email']/div/input"));
        inputEmail.sendKeys("Glovo@gmail.com");

        WebElement inputPassword = driver.findElement(By.xpath("//*[@id='signup-password']/div/div/input"));
        inputPassword.sendKeys("Glovo12345");

        WebElement button = driver.findElement(By.xpath("//*[@id='signup-button']"));
        button.click();


    }
}
