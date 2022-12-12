package dynamicElementsXpath;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicElements2 {
	WebDriver driver;
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "/Users/comet/SeleniumWorkspace/driver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://us.cnn.com/?refresh=1");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@Test
	public void test2() {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@data-vr-zone='home-top-col1']/descendant::strong[1]")));
		driver.findElement(By.xpath("//ul[@data-vr-zone='home-top-col1']/descendant::strong[1]")).click();
		
	}
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
