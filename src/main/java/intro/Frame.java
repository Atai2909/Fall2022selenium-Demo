package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Frame extends BaseTest {
    //Frame -это рамка для рекламы
    @Test
    public void test1(){
        driver.get("https://demoqa.com/frames");

        driver.switchTo().frame(2);
        WebElement frameText = driver.findElement(By.id("sampleHeading"));
        System.out.println(frameText.getText());

        driver.switchTo().defaultContent(); // это чтобы переключаться с фрейма на фрейм

        driver.switchTo().frame(3);
        WebElement frameText1 = driver.findElement(By.id("sampleHeading"));
        System.err.println(frameText1.getText());

        WebElement frameText2 = driver.findElement(By.xpath("//div[@class='pattern-backgound playgound-header']"));
        System.out.println(frameText2.getText());
    }
}
