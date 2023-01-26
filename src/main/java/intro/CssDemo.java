package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class CssDemo extends BaseTest{

    @Test
public void CcsTest1(){

        driver.get("https://www.amazon.com/");

        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);

    }
}
