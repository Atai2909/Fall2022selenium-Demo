package intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class XpathDemo {
 WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // creating instance ChromeDriver
        driver.manage().window().maximize(); // увеличиваем окно в chrome
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


    @Test
    public void xpathDemo(){
       driver.get("https://demoqa.com/text-box");
                                       //это absolute xpath указываем путь с корня
        WebElement nameText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[1]/label"));
        String expectedEmailText = "Email";// ожидаемый результат "Email"
        // сравниваем фактический и ожидаемый результат
        Assert.assertEquals(nameText.getText(),expectedEmailText);

        WebElement nameText2 = driver.findElement(By.xpath("//label[@id='userEmail-label']"));
        Assert.assertTrue(expectedEmailText.contains(nameText2.getText()));


    }
    @Test
    public void xpathTest2(){
      WebElement userName = driver.findElement(By.xpath("//input[@id='userName']"));
      userName.sendKeys("Test123");
      //через метод getAttribute мы берем значение из username
        System.out.println("Result is : "+userName.getAttribute("value"));
        Assert.assertEquals(userName.getAttribute("value"),"Test123");
    }
@AfterClass
    public void tearDown(){
    driver.close();
    driver.quit();
}
// через этот метод в html-->//*[text()='Current Address'] ищем по названию текста


    }

