package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Ikea extends BaseTest{
    @Test
    public void testMoveToElementAndSelect(){
        driver.get("https://www.imoving.com/");
        WebElement houseTypeSelectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(houseTypeSelectMenu);
        select.selectByVisibleText("My Apartment");
        Helper.pause(3000);

       WebElement menu2 = driver.findElement(By.id("hp-nav-select-house"));
        Select select2 = new Select(menu2);
        select2.selectByIndex(1);
        Helper.pause(3000);

        WebElement submit = driver.findElement(By.xpath("//*[@id=\"roomsForm\"]/div[3]/button"));
        submit.click();
        Helper.pause(3000);

        WebElement closeMenu = driver.findElement(By.id("closeSaveModal"));
        closeMenu.click();
        Helper.pause(3000);

        WebElement closeMenu1 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/a"));
        closeMenu1.click();
        Helper.pause(3000);

        WebElement closeMenu2 = driver.findElement(By.id("closeTutorial"));
        closeMenu2.click();
        Helper.pause(3000);

        WebElement add1 = driver.findElement(By.xpath(".//div[@class='item'][1]"));
        WebElement add12 = driver.findElement(By.xpath("//a[@ng-click='vm.addAnotherItemType(item)']"));
        add12.click();







    }
}
