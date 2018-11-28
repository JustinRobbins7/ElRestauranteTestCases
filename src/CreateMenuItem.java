import java.util.regex.Pattern;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateMenuItem {
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
  public void testCreateMenuItem() throws Exception {
    driver.get("http://ec2-18-223-100-203.us-east-2.compute.amazonaws.com:8080/");
    Thread.sleep(2000);
    driver.get("http://ec2-18-223-100-203.us-east-2.compute.amazonaws.com:8080/myaccount");
    driver.findElement(By.id("loginusername")).click();
    driver.findElement(By.id("loginusername")).clear();
    driver.findElement(By.id("loginusername")).sendKeys("admin");
    driver.findElement(By.id("loginpassword")).clear();
    driver.findElement(By.id("loginpassword")).sendKeys("password");
    Thread.sleep(2000);
    driver.findElement(By.id("loginsubmit")).click();
    driver.findElement(By.id("title")).click();
    driver.findElement(By.id("title")).clear();
    driver.findElement(By.id("title")).sendKeys("TestTaco" + Integer.toString(random.nextInt(100000)));
    driver.findElement(By.id("description")).click();
    driver.findElement(By.id("description")).clear();
    driver.findElement(By.id("description")).sendKeys("This Taco is a test!");
    driver.findElement(By.id("price")).click();
    driver.findElement(By.id("price")).clear();
    driver.findElement(By.id("price")).sendKeys("5");
    //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Add Menu Item:'])[1]/following::div[9]")).click();
    //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Appetizer'])[3]/following::li[1]")).click();
    driver.findElement(By.id("addsubmit")).click();
    Thread.sleep(4000);
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
