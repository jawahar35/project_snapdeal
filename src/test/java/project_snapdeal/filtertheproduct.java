package project_snapdeal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class filtertheproduct {
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
	public void searchtheprodut() throws InterruptedException
	{
		Thread.sleep(20000);
		    WebElement searchBox = driver.findElement(By.id("inputValEnter"));
		    searchBox.sendKeys("phone");
		    searchBox.click();
		    WebElement searchTextSpan=driver.findElement(By.xpath("//*[@id=\"sdHeader\"]/div[4]/div[2]/div/div[2]/button/span"));
		    searchTextSpan.click();
	}
	@Test(priority=3)
	public void filterproduct()
	{
		WebElement sortby=driver.findElement(By.xpath("//*[@id=\"content_wrapper\"]/div[7]/div[5]/div[3]/div[1]/div/div[2]/div/i"));
		sortby.click();
		WebElement sortLowToHigh = driver.findElement(By.cssSelector("li[data-sorttype='plth'][data-index='2']"));
        sortLowToHigh.click();
        boolean isSortSelected = sortLowToHigh.getAttribute("class").contains("sel");
        SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(isSortSelected, "Failed to select 'Low to High' sort option.");
		driver.quit();
	}
	@AfterSuite
	public void teardown()
	{
		driver.close();
	}
	
	
	
}
