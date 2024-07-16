package Tutorial9;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTC {
	static WebDriver driver;

	@Test
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(priority = 1)
	public void validateLoginFunctionality() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void validateHomePageTitle() {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}
	
	@Test(priority = 4)
	public void validateHomePageurl() {
		String actualUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl.contains("orange"), true);
	}
	
	@Test(priority = 5)
	public void validatePIMPageurl() {
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		String actualUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl.contains("pim"), true);
	}

}
