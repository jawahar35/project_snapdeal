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

public class AddtoCart {
	WebDriver driver;
	
	@BeforeSuite
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void openApp() throws InterruptedException
	{
		driver.get("https://www.snapdeal.com/product/karbonn-k9-yuva-dual-sim/5188147400383515212#bcrumbSearch:Karbonn%20k9%20yuva%20Dual%20SIM%20Feature%20Phone%20Coffee");
		Thread.sleep(5000);
		
	}
	@Test(priority=2)
	public void addtocart()
	{
		WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"add-cart-button-id\"]/span"));
        addToCartButton.click();
        WebElement cartQuantity = driver.findElement(By.xpath("//*[@id=\"sdHeader\"]/div[4]/div[2]/div/div[3]/div[1]/div/i/span"));
        String cartItemCount = cartQuantity.getText();
        
        Assert.assertTrue(Integer.parseInt(cartItemCount) > 0, "Product was added to the cart");
    }
	@Test(priority=3)
		public void viewthecart()
		{
		WebElement cartInner=driver.findElement(By.xpath("//*[@id=\"sdHeader\"]/div[4]/div[2]/div/div[3]/div[1]/div"));
		cartInner.click();
		
		 String cartPageTitle = driver.getTitle();
	        Assert.assertNotSame(cartPageTitle, "shopping");
	        
	}
	@Test(dependsOnMethods = "viewthecart")
	public void proceedthepayment()
	{
		WebElement button=driver.findElement(By.xpath("//*[@id=\"checkout-continue\"]/input[2]"));
		button.click();
			
	}
	
	@AfterSuite
	public void teardown()
	{
		driver.close();
	} 
	
	
	}


