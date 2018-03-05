/**
 * Class takes a Screenshot
 */
package iliasDownloader;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
/**
 * @author Fabio Bertagna
 *
 */
public class Screenshot {
	private WebDriver driver;
	
	/**
	 * @param driver
	 */
	public Screenshot(WebDriver driver) {
		this.driver = driver;
	}
	
	public void take() throws IOException{
		//take screenshot
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("/root/Documents/Programming/Projects/IliasDownloaderJava/screenshot.png"));
		}
		catch(IOException e) {
			System.out.println("Error occured : " + e.getMessage());
		}
	}
	

}
