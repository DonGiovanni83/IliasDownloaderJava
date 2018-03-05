/**
 * 
 */
package iliasDownloader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
/**
 * @author root
 *
 */
public class IliasLogin extends ChromeSession {
	private String username;
	private String password;
	final String LOGIN_URL = "https://www.ilias.unibe.ch";
	
	//WebElements used in Loginprocess
	final String UNISELECT_XPATH = "//*[@id=\"user_idp_iddtext\"]"; 
	final String UNILOGIN_XPATH = "//*[@id=\"wayf_submit_button\"]"; 
	final String LOGIN_XPATH = "/html/body/div/div[3]/form/div[4]/button";	
	
	public IliasLogin() {
		UserLogin login = new UserLogin();
		final String[] creds = login.getCredentials();
		
		this.username = creds[0];
		this.password = creds[1];
	}
	
	public void login() throws IOException{
		//go to login page
		super.driver.navigate().to(LOGIN_URL);
		System.out.println("\n----------------Selecting the right University----------------");
		
		//select university
		WebElement SelectUni = super.driver.findElement(By.xpath(UNISELECT_XPATH));
		SelectUni.clear();
		SelectUni.sendKeys("bern");
		SelectUni.sendKeys(Keys.RETURN);
		
		//submit selection
		WebElement LoginUni = driver.findElement(By.xpath(UNILOGIN_XPATH));
		LoginUni.click();
		
		
		//enter Switch username and password
		WebElement username = driver.findElement(By.cssSelector("#username"));
		username.sendKeys(this.username);
		WebElement password = driver.findElement(By.cssSelector("#password"));
		password.sendKeys(this.password);
		
		//submit credentials
		WebElement submit = driver.findElement(By.xpath(LOGIN_XPATH));
		submit.click();
		System.out.println("\n---------------------Logging in on Ilias----------------------");

		}
}
