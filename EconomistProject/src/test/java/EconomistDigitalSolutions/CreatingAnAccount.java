package EconomistDigitalSolutions;


import org.openqa.selenium.By;                                                               //Contains Web driver class needed to instantiate a new browser that is loaded with the below selenium webdriver.
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CreatingAnAccount {
	
	public String baseUrl="https://jobs.economist.com/";                                    //Base URL used of economist website to Hit on web.
	public WebDriver driver;
	

@BeforeTest// Launching the browser with application
public void launchApplication()
{
	System.setProperty("webdriver.chrome.driver", "C:\\eclipse-workspace\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get(baseUrl);
	System.out.println("Application launch successfully");                                   //Before Test Code Used to launch the website using chrome browser.
}

@Test(priority=1)  // Creating new Account                                                        //Priority - Used to Run the automated code in a sequencial manner.
public void createNewAccount() throws Exception
{
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[contains(text(),'Create account')]")).click();
	System.out.println("Able to click on Create an Account");
	driver.findElement(By.id("title")).sendKeys("MRS");
	driver.findElement(By.id("firstname")).sendKeys("Vaibhav");                             // First name used to fill the value in required sections on website.
	driver.findElement(By.id("lastname")).sendKeys("sharma");                               // Last name used to fill the value in required sections on website.
	driver.findElement(By.id("emailaddress")).sendKeys("Vaibhav.sharma@gmail.com");         // Email Address used to fill the value in required sections on website
	driver.findElement(By.id("regpassword")).sendKeys("sharma123");                         // Password is filled.
	driver.findElement(By.id("confirmpassword")).sendKeys("sharma123");                     // Confirm Password field is filled.
	//WebElement option=driver.findElement(By.id("rememberme-register"));                   // Keep me Signed in checkbox is checked.
	//option.click();
	WebElement option2=driver.findElement(By.id("agreeTermsAndConds"));                     // Terms and conditions check box is checked.
	option2.click();
	driver.findElement(By.xpath("//input[@Value='Create an account']")).submit();           // Create an account button is clicked to create an account successfully.
	System.out.println("Account is created successfully");                                  // Account is created successfully.
}

@Test(priority=2) // Login with existing account as I created above
public void SignIn() throws Exception
{
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();               //SignIn form is clicked.
	driver.findElement(By.id("signinemail")).sendKeys("Vaibhav.sharma@gmail.com");         //Email addressed is filled with the given email.
	driver.findElement(By.id("signinpassword")).sendKeys("sharma123");                     // Password is filled in the box.
	driver.findElement(By.xpath("//input[@Value='Sign in']")).submit();                    // Sign in button is clicked.
	System.out.println("Login successfully");                                              // Login successfully.
} 

@AfterTest   // Close the browser                                                               
public void quitApplication()
{
	driver.quit();
}

}
