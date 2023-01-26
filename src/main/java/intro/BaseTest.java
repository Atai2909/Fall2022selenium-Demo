package intro;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public abstract class BaseTest {

    WebDriver driver;
    BrowserHelper browserHelper;
    AlertHelper alertHelper;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();  // Creating instance of ChromeDriver
        driver = new ChromeDriver();  // Configure ChromeDriver to connect browser
        driver.manage().window().maximize();  // Maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  // Driver will wait 20secs
        browserHelper = new BrowserHelper(driver);
        alertHelper = new AlertHelper();
    }

//   @AfterClass
//    public void tearDown() {
//       driver.close();
//       driver.quit();
   }
