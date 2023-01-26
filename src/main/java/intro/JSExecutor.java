package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutor extends BaseTest {
// JSExecutor это метод ищет кнопки в HTML без SCROLL
    @Test
    public void test1(){
        browserHelper.openURL("https://www.etsy.com/");// открыли сайт            тут нашли путь к кнопке careers
        WebElement careersLink = driver.findElement(By.xpath("//a[@href='https://www.etsy.com/careers?ref=ftr']"));
        Helper.jsClick(driver,careersLink); // через helper нажали на эту кнопку
        Helper.pause(5000);
        Helper.jsScrollDown(driver);// через helper делаем scrollDown
        Helper.pause(5000);
    }
}
