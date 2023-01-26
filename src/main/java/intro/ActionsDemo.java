package intro;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ActionsDemo extends BaseTest {


    @Test
    public void testRadioButton() {
        driver.get("https://demoqa.com/radio-button");
        WebElement yesRadio = driver.findElement(By.xpath(".//label[@for='yesRadio']"));
        yesRadio.click();
        Assert.assertTrue(yesRadio.isEnabled());// isEnabled --->  yesRadio включен
    }

    @Test
    public void testRightClick() {
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
        Actions action = new Actions(driver);
        // это класс чьи методы выполняют функции типа: doubleClick, contextClick,
        action.doubleClick(doubleClick).perform();


        Assert.assertEquals(driver.findElement(By.id("doubleClickMessage")).getText(), "You have done a double click");
    }

    @Test
    public void doubleClick() {
        driver.get("https://demoqa.com/buttons");
        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
        Actions action = new Actions(driver);
        action.contextClick(rightClick).perform();
        Helper.pause(3000);
        Assert.assertTrue(driver.findElement(By.id("rightClickMessage")).getText().contains("You have done a right click"));

    }

    @Test
    public void Click() {
        driver.get("https://demoqa.com/buttons");
        WebElement ClickButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button"));
        ClickButton.click();
        Helper.pause(3000);
        WebElement clickMessage = driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertEquals(clickMessage.getText(), ("You have done a dynamic click"));
    }
    @Test
    public void testMoveToElementAndSelect(){
        driver.get("https://www.imoving.com/");
        WebElement houseTypeSelectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(houseTypeSelectMenu);
        select.selectByValue("1080");
        Helper.pause(3000);
        select.selectByVisibleText("My Apartment");
        Helper.pause(3000);
        select.selectByIndex(3);
        Helper.pause(3000);


    }
}