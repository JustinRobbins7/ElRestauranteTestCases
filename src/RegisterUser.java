import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterUser {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private Random random = new Random();
  
  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testRegisterUser() throws Exception {
    driver.get("http://ec2-18-223-100-203.us-east-2.compute.amazonaws.com:8080/menu");
    driver.get("http://ec2-18-223-100-203.us-east-2.compute.amazonaws.com:8080/myaccount");
    Thread.sleep(2000);
    driver.findElement(By.linkText("Create Account")).click();
    driver.findElement(By.id("createusername")).click();
    driver.findElement(By.id("createusername")).clear();
    driver.findElement(By.id("createusername")).sendKeys("TestName" + Integer.toString(random.nextInt(100000)));
    driver.findElement(By.id("createpassword")).click();
    driver.findElement(By.id("createpassword")).clear();
    driver.findElement(By.id("createpassword")).sendKeys("test");
    driver.findElement(By.id("createpasswordverify")).click();
    driver.findElement(By.id("createpasswordverify")).clear();
    driver.findElement(By.id("createpasswordverify")).sendKeys("test");
    Thread.sleep(3000);
    driver.findElement(By.id("createaccount")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
