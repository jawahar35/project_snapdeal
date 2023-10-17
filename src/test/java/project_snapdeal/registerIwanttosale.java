package project_snapdeal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class registerIwanttosale {
	WebDriver driver;
	@BeforeSuite
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	   }
	@Test(priority=1)
	public void openapp() throws InterruptedException 
	{
		driver.get("https://www.snapdeal.com/");
		Thread.sleep(20000);
	}
	@Test(priority=2)
	public void entertosale()
	{
		 WebElement sellButton = driver.findElement(By.linkText("Sell On Snapdeal"));
	        sellButton.click();

	        // Add appropriate waits for elements to load.

	        // For the purpose of this example, let's assert that we're on the correct page.
	        String pageTitle = driver.getTitle();
	        Assert.assertTrue(pageTitle.contains("Snapdeal"));	 
	}
	
	@Test(priority=3)
	public void register()
	{
		 WebElement Gst = driver.findElement(By.xpath("//*[@id=\"j_id0:j_id35:j_id36:frmGST:sdGstn\"]"));
		 Gst.sendKeys("123456789123456");
		 
		 WebElement onRegisterNowClick = driver.findElement(By.xpath("//*[@id=\"j_id0:j_id35:j_id36:frmGST:btnRegisterNow\"]"));
		 onRegisterNowClick.click();
		 WebElement error = driver.findElement(By.xpath("//*[@id=\"j_id0:j_id35:j_id36:frmGST:errGSTn\"]"));
	        Assert.assertFalse(error.isDisplayed(), "Please enter a invalid GSTn Format");
	}
	@Test(priority=4)
	public void watchtrainingvideo()
	{
		WebElement trainingVideosLink = driver.findElement(By.xpath("//*[@id=\"fr-new-user\"]/div/div[5]/div/a[2]"));
        trainingVideosLink.click();
        
        driver.get("https://www.youtube.com/channel/UCGay5vO0lgq0TkYoHzdgCIQ/videos");
        // You can assert if you have successfully reached the YouTube channel.
        // Example:
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Snapdeal Seller Training Academy"), "Failed to reach the YouTube channel.");
    
        
	}
	
	@AfterSuite
	public void teardown()
	{
		driver.close();
	}

}
