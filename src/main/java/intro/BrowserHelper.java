package intro;

import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper {

    private WebDriver driver;

    public BrowserHelper(WebDriver driver){
        this.driver = driver;
    }
    // с помощью этого медота мы открываем сайты
    public void openURL(String URL){
        driver.navigate().to(URL);
    }

    public void goBack(){
        driver.navigate().back();
    }

    public void goForward(){
        driver.navigate().forward();
    }

    public  void refresh(){
        driver.navigate().refresh();
    }
    // этот метод сохраняет в себя все вкладки в set и возвращает
    public Set<String> getWindowHandles(){
        return driver.getWindowHandles();
    }
    // метод для переключения между вкладками
    public void switchToWindow(int index){
        // тут ложим set v linkedList
        LinkedList <String> windowID = new LinkedList<String>(getWindowHandles());
        if(index < 0 || index > windowID.size()){
            throw new IllegalArgumentException("Invalid index: " + index);
        }
        driver.switchTo().window(windowID.get(index));// здесь мы переключаемся между вкладками по индексу
    }
    //тут мы переключаемся на 0 индекс
    public void switchToParent(){
        LinkedList <String> windowID = new LinkedList<String>(getWindowHandles());
        driver.switchTo().window(windowID.get(0));
    }




}
