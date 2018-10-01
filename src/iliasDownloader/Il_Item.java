/**
 * 
 */
package iliasDownloader;

import org.openqa.selenium.WebElement;

/**
 * @author root
 *
 */
public class Il_Item {
	protected String name;
	protected WebElement webElement;
	
	public Il_Item(String name, WebElement webElement) {
		this.name = name;
		this.webElement = webElement;
	}
	
	
	public String name() {
		return this.webElement.getText();
	}
}
