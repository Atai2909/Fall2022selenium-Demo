package intro;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class UploadDownloadDemo extends BaseTest {
    @Test
    //загружаем файл
    public void test1(){
        driver.navigate().to("https://demoqa.com/upload-download");
        driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\User\\Downloads\\Изображение WhatsApp 2022-12-27 в 02.40.43.jpg");
    }
}
