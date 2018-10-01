/**
 * 
 */
package Tests;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author root
 *
 */
public class Screenshot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String CHROME_PATH = "/usr/bin/google-chrome";
		String CHROMEDRIVER_PATH = "/usr/bin/chromedriver";
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary(CHROME_PATH);
		chromeOptions.addArguments("--headless");
		
		WebDriver Driver = new ChromeDriver(chromeOptions);
		Driver.navigate().to("https://www.ilias.unibe.ch");
		
		WebDriverWait waitForUsername = new WebDriverWait(Driver, 5000);
		
		    
		Driver.quit();
		

	}

}
