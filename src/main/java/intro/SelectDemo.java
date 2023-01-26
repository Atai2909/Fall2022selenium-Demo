package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectDemo extends BaseTest{
    @Test
    public void testSelect(){
        driver.get("https://demoqa.com/select-menu");

        WebElement select1 = driver.findElement(By.id("react-select-2-input"));
        Select select = new Select(select1);
        select.selectByVisibleText("Group 1, option 1");

    }
}
