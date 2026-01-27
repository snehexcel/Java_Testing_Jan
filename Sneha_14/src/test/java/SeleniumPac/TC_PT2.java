package SeleniumPac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_PT2 {
  @Test
  public void test4() {
	  System.out.println("Test4");
	  WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.yahoo.com/");
//		driver.quit();
  }
  public void test5() {
	  System.out.println("Test5");
	  WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://myntra.com");
//		driver.quit();
  }
  public void test6() {
	  System.out.println("Test6");
	  WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://amazon.in");
//		driver.quit();
  }
}
