package intro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHelper {

  private WebDriver driver;
  private Alert alert;


  public void acceptAlert(){
      driver.switchTo().alert();
      alert.accept();
  }
  public void dismissAlert(){
      driver.switchTo().alert();
      alert.dismiss();
  }
  public void sendKeysAlert(String txt){
      driver.switchTo().alert();
      alert.sendKeys(txt);
  }
}
