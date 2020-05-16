package enthu.selenium.testing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	private static final String downlaodLocation = "C:\\\\BhushanWork\\\\downloadedFiles";
	
	public static void main(String[] args) {
		enthutest2 myClass = new enthutest2();
		myClass.downloadStatements();
	}

	/**
	 * @param args
	 */
	public void downloadStatements() {
		
		List<String> companyList = new ArrayList<>();
		try {
			createCompanyList(companyList);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		for(String company : companyList) {
			String urlString = "http://financials.morningstar.com/income-statement/is.html?t="+company+"&region=ind&culture=en-US&platform=sal";
			
			// webdriver for Firefox browser 
		    System.setProperty("webdriver.gecko.driver", "C:\\BhushanWork\\selenium_webdriver_exe\\geckodriver.exe"); 
		    
		    FirefoxProfile profile=new FirefoxProfile();
		    createProfile(profile);

		    FirefoxOptions options = new FirefoxOptions().setProfile(profile);
		    
		    WebDriver driver=new FirefoxDriver(options);  
		      
		    // Launch website  
		    driver.navigate().to(urlString);
		    
		    try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    
		    // Click on the search text box and send value  
		    driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div[21]/span/a")).click();
		    
		    driver.quit();
		    
		    try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private void createCompanyList(List<String> companyList) throws IOException {
		//companyList.add("HDFC");
		//companyList.add("ITC");
		    String file = getClass().getClassLoader().getResource("companyList.txt").getFile();
		    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
		        String line = "";
		        while ((line = br.readLine()) != null) {
		        	companyList.add(line);
		        }
		    } catch (FileNotFoundException e) {
		    	e.printStackTrace();
		    }
	}

	private void createProfile(FirefoxProfile profile) {
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.download.dir", downlaodLocation);
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
		
	}

}
