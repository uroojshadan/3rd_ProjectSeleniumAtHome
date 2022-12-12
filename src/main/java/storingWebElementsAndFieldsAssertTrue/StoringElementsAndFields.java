package storingWebElementsAndFieldsAssertTrue;

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

import net.bytebuddy.dynamic.TypeResolutionStrategy.Passive;

public class StoringElementsAndFields {


	WebDriver driver;
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "/Users/comet/SeleniumWorkspace/driver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://techfios.com/billing/?ng=login/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	@Test
	public void storingWEWF() throws InterruptedException {
		//driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");
		WebElement USER_NAME_ELEMENT=driver.findElement(By.xpath("//input[@id='username']"));/*Selenium offers us to store the web elements and fields using
		webElement type and By (Class) type-->we are storing them in variables for reusability*/
		//driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
		WebElement PASSWORD_ELEMENT=driver.findElement(By.xpath("//input[@id='password']"));
		//driver.findElement(By.xpath("//button[@name='login']")).click();
		WebElement SIGN_IN_BUTTON_ELEMENT=driver.findElement(By.xpath("//button[@name='login']"));
		
		//By class variables can be declared as global variables
		By USER_NAME_FIELD=By.xpath("//input[@id='username']");
		By PASSWORD_FIELD=By.xpath("//input[@id='password']");
		By SIGN_IN_BUTTON_FIELD=By.xpath("//button[@name='login']");
		By DASHBOARD_FIELD=By.xpath("//*[@id='page-wrapper']/div[2]/div[1]/h2");
		USER_NAME_ELEMENT.sendKeys("demo@techfios.com");
		PASSWORD_ELEMENT.sendKeys("abc123");
		//SIGN_IN_BUTTON_ELEMENT.click();
		//Thread.sleep(2000);
		
		//OR
		
		USER_NAME_ELEMENT.clear();
		PASSWORD_ELEMENT.clear();
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		//driver.findElement(PASSWORD_FIELD).sendKeys("abc123");-->correct password
		driver.findElement(PASSWORD_FIELD).sendKeys("abc1234");//providing wrong password so that we can see page not found in console
		driver.findElement(SIGN_IN_BUTTON_FIELD).click();
		//Assert.assertTrue(error message,condition)-->if the condition is false then message will be shown i.e. if dash board field is displayed on site 
		//then condition is true if it is not displayed the condition is false and message wil be displayed
		//Assert.assertTrue("Dashboard page not Found",driver.findElement(DASHBOARD_FIELD).isDisplayed());
		
		boolean pageTitleStatus;
		try {
			WebElement DASHBOARD_ELEMENT=driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div[1]/h2"));
			pageTitleStatus=true;
		}catch(Exception e) {
			pageTitleStatus=false;
		}
		//assertTrue() is method of Assert class which takes 2 args-->String message which will be executed when the 2nd arg i.e. condition is false
		Assert.assertTrue("Page not Found",pageTitleStatus);/*pageTitleStatus = false since we gave wrong password it will never go to dashboard*/
		//java.lang.AssertionError: Page not Found
		
	}
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
		
	}
}

