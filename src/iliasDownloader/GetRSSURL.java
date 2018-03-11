/**
 * 
 */
package iliasDownloader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * @author root
 *
 */
public class GetRSSURL extends IliasSession{
	private String RSSURL;
	final String RSSBUTTON_XPATH = "//*[@id=\"block_pdnews_0\"]/div/div[7]/a/span";
	final String RSS_XPATH = "//*[@id=\"block_pdcontent_0\"]/div/div[2]/p[3]/a";
	final File file;

	public GetRSSURL() throws IOException{
		this.file = new File("RSSURL.txt");
		try {
			file.createNewFile();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	
	public void getRSSURL() {
		try {
			//check if RSSURL has already been stored
			FileReader read = new FileReader(file);
			BufferedReader bfread = new BufferedReader(read);
			
			if(bfread.readLine()==null){				
				//Search RSS-Link on ilias
				WebElement rssButton = this.driver.findElement(By.xpath(RSSBUTTON_XPATH));
				rssButton.click();
				
				//Copy Link and write it into the .txt File
				WebElement rss = this.driver.findElement(By.xpath(RSS_XPATH));
				this.RSSURL = rss.getAttribute("href");
				FileWriter write = new FileWriter("RSSURL.txt");
				
				//User information
				System.out.println("\n-----------------Catched RSSURL Successfully------------------");
				System.out.println("\n"+RSSURL);
				
				
				write.write(RSSURL);
				write.close();
			}
			else{
				//User information
				System.out.println("\n------------------RSSURL already available--------------------");
			}
			//Clean up
			read.close();
			bfread.close();
		}catch(IOException e) {
			System.out.println(e.getMessage() + e.getLocalizedMessage());
		}
		
	}
	

}
