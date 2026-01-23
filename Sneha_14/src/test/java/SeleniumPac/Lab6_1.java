package SeleniumPac;
 
import java.time.Duration;
 
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Lab6_1 {
 
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
	    driver.findElement(By.linkText("Login")).click();
	    driver.findElement(By.id("input-email")).sendKeys("abfcthnbfsnc@mail.com");
	    driver.findElement(By.id("input-password")).sendKeys("Ab@cd@ef12");
	    driver.findElement(By.cssSelector("input[type='submit'][value='Login']")).click();
	    driver.findElement(By.linkText("Components")).click();
	    driver.findElement(By.linkText("Monitors (2)")).click();
	    
	    WebElement a = driver.findElement(By.id("input-limit"));
        Select country = new Select(a);
        country.selectByContainsVisibleText("25");
 
        driver.findElement(By.cssSelector("button[onclick=\"cart.add('42', '2');\"]")).click();
 
	    Thread.sleep(2000);
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600);");
	    
        Thread.sleep(2000);
        
	    driver.findElement(By.linkText("Specification")).click();
	    
	    Thread.sleep(2000);
	    
	    if(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tab-specification .table")) != null) {
	    	System.out.println("Verified");
	    }else {
	    	System.out.println("Not verified");
	    }
	    
	    Thread.sleep(2000);
 
	    js.executeScript("window.scrollBy(0, -600);");
	    driver.findElement(By.cssSelector("button[onclick=\"wishlist.add('42');\"]")).click();
 
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success")));
	    
	    System.out.println("Verified: " + alert.getText());
	    
	    driver.findElement(By.name("search")).click();
	    driver.findElement(By.cssSelector("input[type='text'][name='search']")).sendKeys("mobile" + Keys.ENTER);
 
	    driver.findElement(By.id("description")).click();
	    driver.findElement(By.id("button-search")).click();
	    
	    js.executeScript("window.scrollBy(0, 1000);");
	    
	    driver.findElement(By.linkText("HTC Touch HD")).click();
	    
 
       WebElement qty = driver.findElement(By.id("input-quantity"));
       qty.clear();
       qty.sendKeys("3");
       
	   driver.findElement(By.id("button-cart")).click();
	   
	   Thread.sleep(7000);
	   
	    WebElement alert2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success.alert-dismissible")));
	    
	    System.out.println("Verified: " + alert2.getText());
	    
		driver.findElement(By.id("cart")).click();
		
		driver.findElement(By.linkText("Checkout")).click();
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Logout")).click();
        
        
        if (driver.findElement(By.xpath("//h1[text()='Account Logout']")).isDisplayed()) {
            System.out.println("Account Logout verified");
        }
 
        driver.findElement(By.linkText("Continue")).click();
        
        driver.quit();
	}
 
}
 