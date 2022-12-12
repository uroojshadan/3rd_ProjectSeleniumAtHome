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

public class DynamicElements {

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
	public void Testing() throws InterruptedException {
		driver.findElement(By.xpath("//section[@id='homepage1-zone-1']/descendant::h3[1]")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		/*WebDriverWait wait=new WebDriverWait(driver,50);//explicit wait till the element is located by its xpath
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@data-vr-zone='home-top-col3']/descendant::h3[1]")));
		driver.findElement(By.xpath("//ul[@data-vr-zone='home-top-col3']/descendant::h3[1]")).click();
		Thread.sleep(3000);*/

	}
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
		
	}
}

