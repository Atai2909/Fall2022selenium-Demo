package intro;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

public class ScreenShotsDemo extends BaseTest{
    @Test
    public void screenShotTest() throws Exception {
        browserHelper.openURL("https://www.amazon.com/"); // тут указываем путь куда сохранить и в конце дали название
        takeSnapShot(driver,"C:\\Users\\User\\IdeaProjects\\UI_framework_Practice\\src\\main\\resources\\amazonHomePage.png");
    }
        public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception{
//Преобразовать объект веб-драйвера для создания скриншота
            TakesScreenshot scrShot =((TakesScreenshot)webdriver);
//Вызовите метод getScreenshotAs для создания файла изображения
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//Переместить файл изображения в новое место назначения
            File DestFile=new File(fileWithPath);
//Скопируйте файл в пункт назначения
            FileUtils.copyFile(SrcFile, DestFile);
    }
}
