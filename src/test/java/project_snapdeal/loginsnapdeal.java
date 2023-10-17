package project_snapdeal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginsnapdeal {
	WebDriver driver;
    Assertion assertion;
    
	
	@BeforeSuite
	public void setup() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		Thread.sleep(20000);
	   }
	
	
	 @Test
	    public void signInAndVerifyOTP() {
	        // Click the "Sign In" button.
	        WebElement accountInner = driver.findElement(By.xpath("//span[text()='Sign In']"));
	       accountInner.click();
	 }
	 @Test(priority=2)
           public void login()
           {
	        
	        WebElement accountBtn = driver.findElement(By.xpath("//a[text()='login']"));
	        accountBtn.click();
	 
		 
	    }
	 @Test(priority=3)
	 public void mobilenumberandotp() 
	 {
		
		 
		   driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("8072896310");
		 
			
	        WebElement continueButton = driver.findElement(By.id("continueButtonId"));
	        continueButton.click();
	       
	        String otp = "123456"; 

	        // Find the OTP input field and enter the OTP.
	        WebElement otpInput = driver.findElement(By.id("otpInputId"));
	        otpInput.sendKeys(otp);

	        // Click the "Verify" button.
	        WebElement verifyButton = driver.findElement(By.id("verifyButtonId"));
	        verifyButton.click();

	        // Use TestNG assertions to check if the login was successful.
	        assertion.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login was successful.");
	        driver.quit(); // Close the browser at the end of the test
	 }
	 
	 	@AfterSuite
	 	public void teardown()
	 	{
	 		driver.close();
	 	}
	 
}
	 

	   
		  
	        
	        
	        
	 

	 



