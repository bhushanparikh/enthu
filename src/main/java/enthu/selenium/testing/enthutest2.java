package enthu.selenium.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * @author Bhushan Parikh
 *
 */
public class enthutest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String urlString = "http://financials.morningstar.com/income-statement/is.html?t=HDFC&region=ind&culture=en-US&platform=sal";
		
	    // webdriver for Chrome browser 
	    //System.setProperty("webdriver.chrome.driver", "C:\\BhushanWork\\selenium_webdriver_exe\\chromedriver.exe"); 
		
		// webdriver for Firefox browser 
	    System.setProperty("webdriver.gecko.driver", "C:\\BhushanWork\\selenium_webdriver_exe\\geckodriver.exe"); 
	    
	    FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.download.dir", "C:\\\\BhushanWork\\\\downloadedFiles");
		profile.setPreference("browser.helperApps.neverAsk.openFile",
									"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
									"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference("browser.download.manager.focusWhenStarting", false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference("browser.download.manager.showAlertOnComplete", false);
		profile.setPreference("browser.download.manager.closeWhenDone", false);
	    FirefoxOptions options = new FirefoxOptions().setProfile(profile);
	    
	    WebDriver driver=new FirefoxDriver(options);  
	      
	    // Launch website  
	    driver.navigate().to(urlString);
	    
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	    // Click on the search text box and send value  
	    driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div[21]/span/a")).click();
	   
    
	    // Click on the search button  
	    //driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div[1]/div[3]/center/input[1]")).click();
	}

}
