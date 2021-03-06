import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RedeemGiftCard {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testRedeemGiftCard() throws Exception {
    driver.get("http://ec2-18-223-100-203.us-east-2.compute.amazonaws.com:8080/");
    Thread.sleep(1000);
    driver.get("http://ec2-18-223-100-203.us-east-2.compute.amazonaws.com:8080/myaccount");
    driver.findElement(By.id("loginusername")).click();
    driver.findElement(By.id("loginusername")).clear();
    driver.findElement(By.id("loginusername")).sendKeys("admin");
    driver.findElement(By.id("loginpassword")).click();
    driver.findElement(By.id("loginpassword")).clear();
    driver.findElement(By.id("loginpassword")).sendKeys("password");
    Thread.sleep(2000);
    driver.findElement(By.id("loginsubmit")).click();
    driver.findElement(By.id("giftCardNumber")).click();
    driver.findElement(By.id("giftCardNumber")).clear();
    driver.findElement(By.id("giftCardNumber")).sendKeys("250250250250250");
    Thread.sleep(3000);
    driver.findElement(By.id("addGiftCard")).click();
    driver.findElement(By.linkText("Logout From Website")).click();
    driver.get("http://ec2-18-223-100-203.us-east-2.compute.amazonaws.com:8080/myaccount");
    driver.findElement(By.id("loginusername")).click();
    driver.findElement(By.id("loginusername")).clear();
    driver.findElement(By.id("loginusername")).sendKeys("testName");
    driver.findElement(By.id("loginpassword")).click();
    driver.findElement(By.id("loginpassword")).clear();
    driver.findElement(By.id("loginpassword")).sendKeys("test");
    Thread.sleep(3000);
    driver.findElement(By.id("loginsubmit")).click();
    driver.findElement(By.id("balanceNumber")).click();
    driver.findElement(By.id("balanceNumber")).clear();
    driver.findElement(By.id("balanceNumber")).sendKeys("250250250250250");
    driver.findElement(By.id("addBalanceButton")).click();
    Thread.sleep(3000);
    driver.findElement(By.linkText("Logout From Website")).click();
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
