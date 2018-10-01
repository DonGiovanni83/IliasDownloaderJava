/**
 * 
 */
package iliasDownloader;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * @author root
 *
 */
public class IliasSession extends ChromeSession {
	final String ILIAS_HOME = "https://www.ilias.unibe.ch";
	final String UNI_SELECT = "//*[@class=\"idd_textbox\"]";
	final String UNI_SUBMIT = "//*[@id=\"wayf_submit_button\"]";
	final String SWITCH_USR = "#username";
	final String SWITCH_PASS = "#password";
	final String SWITCH_LOGIN = "body > div > div.aai_login_field > form > div:nth-child(4) > button";
	private String[] creds;
	
	
	public IliasSession() {
		start();
		selectUni("bern");
		UserLogin login = new UserLogin();
		this.creds = login.getCredentials();
		switchLogin(this.creds);
			
	}
	
	/**
	 * Selects uniBern
	 * @param name
	 */
	public void selectUni(String name) {
		goTo(ILIAS_HOME);
		System.out.println("\n-----------------------Selecting University: "+name+"-----------------------");
		WebElement uniName = this.driver.findElement(By.xpath(UNI_SELECT));
		uniName.clear();
		uniName.sendKeys(name + Keys.RETURN);
		
		this.driver.findElement(By.xpath(UNI_SUBMIT)).click();
	}
	/**
	 * Logs in on Switch
	 * @param creds
	 */
	public void switchLogin(String[] creds) {
		System.out.println("\n--------------------------Ilias-Login---------------------------");

		WebElement usrForm = this.driver.findElement(By.cssSelector(SWITCH_USR));
		usrForm.sendKeys(creds[0]);
		WebElement passForm = this.driver.findElement(By.cssSelector(SWITCH_PASS));
		passForm.sendKeys(creds[1]);
		this.driver.findElement(By.cssSelector(SWITCH_LOGIN)).click();
	}
	/*
	 * Method for quick access for Ilias-Homepage when loged in
	 */
	public void goHome() {
		this.driver.navigate().to(ILIAS_HOME);
		}
	
	/**
	 * Start banner
	 */
	public void start() {
		String banner = "\n" + 
				"  _____ _ _             _____                      _                 _           \n" + 
				" |_   _| (_)           |  __ \\                    | |               | |          \n" + 
				"   | | | |_  __ _ ___  | |  | | _____      ___ __ | | ___   __ _  __| | ___ _ __ \n" + 
				"   | | | | |/ _` / __| | |  | |/ _ \\ \\ /\\ / | '_ \\| |/ _ \\ / _` |/ _` |/ _ | '__|\n" + 
				"  _| |_| | | (_| \\__ \\ | |__| | (_) \\ V  V /| | | | | (_) | (_| | (_| |  __| |   \n" + 
				" |_____|_|_|\\__,_|___/ |_____/ \\___/ \\_/\\_/ |_| |_|_|\\___/ \\__,_|\\__,_|\\___|_|   \n" + 
				"                                                                                 \n" + 
				"                                                                                 \n";
		System.out.println(banner);
	}

	public String[] getCreds() {
		return this.creds;
	}
}