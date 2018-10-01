/**
 * Class Sets up a Webdriver and starts it
 */
package iliasDownloader;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
/**
 * @author Fabio Bertagna
 *
 */
public class ChromeSession {
	final String CHROME_PATH = "/usr/bin/google-chrome-stable";
	protected ChromeOptions chrome_options;
	protected WebDriver driver;
	
	/**
	 * Initialise options and driver
	 */
	public ChromeSession() {
		//setup driver options
		this.chrome_options = new ChromeOptions();
		chrome_options.setBinary(CHROME_PATH);
		chrome_options.addArguments("--headless");
		
		//setup driver
		this.driver = new ChromeDriver(chrome_options);
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void terminateSession() {
		this.driver.close();
		this.driver.quit();
	}
	
	public void goTo(String url) {
		this.driver.navigate().to(url);
	}


}
