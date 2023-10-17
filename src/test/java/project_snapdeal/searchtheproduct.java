package project_snapdeal;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class searchtheproduct {
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
		    
		    SoftAssert softAssert = new SoftAssert();

		    // Add validation or further actions as needed
		    // For example, you can assert that search results are displayed correctly.
		    String pageTitle = driver.getTitle();
		    softAssert.assertFalse(pageTitle.contains("phone"));

	
	}
	
	
		@Test(dependsOnMethods = "searchtheprodut")
	    public void selectPhone()
		{
	        // Wait for the search results to load (you should implement a proper wait here).
	        // Find and click on the phone based on its title.
	        WebElement phone = driver.findElement(By.xpath("//p[@title='Karbonn k9 yuva Dual SIM Feature Phone Coffee']"));
	        phone.click();
	    }

	    @Test(dependsOnMethods = "selectPhone")
	    public void enterProductPage() {
	        // The previous step should have taken you to the product page.
	        // You can perform further actions on this page as needed
		 

	    // Add validation or further actions as needed
	    // For example, you can assert that search results are displayed correctly.
	    String pageTitle = driver.getTitle();
	    Assert.assertFalse(pageTitle.contains("sdCheckbox"));
        
        driver.quit(); // Close the browser at the end of the test
}
	@AfterSuite
	public void teardown()
	{
		driver.close();
	}
	
}
