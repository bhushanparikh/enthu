package enthu.selenium.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Bhushan Parikh
 *
 */
public class enthutest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	    // webdriver for Chrome browser 
	    //System.setProperty("webdriver.chrome.driver", "C:\\BhushanWork\\selenium_webdriver_exe\\chromedriver.exe"); 
		
		// webdriver for Firefox browser 
	    System.setProperty("webdriver.gecko.driver", "C:\\BhushanWork\\selenium_webdriver_exe\\geckodriver.exe");  
	    
	    WebDriver driver=new FirefoxDriver();  
	      
	    // Launch website  
	    driver.navigate().to("http://www.google.com/");
	    
	    // Click on the search text box and send value  
	    driver.findElement(By.name("q")).sendKeys("www.enthuinvestor.com");  
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	    // Click on the search button  
	    driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div[1]/div[3]/center/input[1]")).click();
	}

}
