package explicitWaitAndExceptions;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExpWaitAndExcp {

	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "/Users/comet/SeleniumWorkspace/driver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://techfios.com/billing/?ng=login/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void Test1() {

		WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement SIGN_IN_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@name='login']"));


		By USER_NAME_FIELD=By.xpath("//input[@id='username']");
		By PASSWORD_FIELD=By.xpath("//input[@id='password']");
		By SIGN_IN_BUTTON_FIELD=By.xpath("//button[@name='login']");
		//for assertion of the fact that we are on the page with header as Dashboard
		By DASHBOARD_FIELD=By.xpath("//*[@id='page-wrapper']/div[2]/div[1]/h2");
		
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc1234");//providing wrong password
		driver.findElement(SIGN_IN_BUTTON_FIELD).click();
		
		//to demonstrate webdriver wait explicit wait in selenium and get Timeout exception
		WebDriverWait wait=new WebDriverWait(driver,10);/*explicit wait-->driver waits for 10 secs*/
		/*TimeoutException:Expected condition failed: waiting for visibility of element located
		by By.xpath: //*[@id='page-wrapper']/div[2]/div[1]/h2 (tried for 10 second(s) with 500 milliseconds interval)
		TimeoutException occurs : When we apply webdriverwait within the expected conditions and when the condition fails then 
		we get to see time out exception*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_FIELD));//waits for visibility of element located by the locator
		
		
		
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();

	}

}
