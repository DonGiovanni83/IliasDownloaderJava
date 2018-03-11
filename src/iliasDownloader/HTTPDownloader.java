package iliasDownloader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class HTTPDownloader {
	protected WebDriver driver;
	protected Set<Cookie> cookieSet;
	protected String parsedCookies;
	protected String[] downloadFiles;
	private static final int BUFFER_SIZE = 4096;
	
	public HTTPDownloader(WebDriver driver, String[] files) {
		this.driver = driver;
		this.cookieSet = this.driver.manage().getCookies();
		this.parsedCookies = parseCookies(this.cookieSet);
		this.downloadFiles = files;
	}
	
	/**
	 * Method parses cookies and returns the cookies in one string
	 * so it can be used with a HTTPConnection
	 * @param cookies
	 * @return
	 */
	public String parseCookies(Set<Cookie> cookies) {
		String cookie = "";
		for(Cookie c : cookies) {
			String[] parsedCookies = c.toString().split(";");
			cookie = cookie.concat(parsedCookies[0] +"; ");
		}
		//remove the last "; "
		return cookie.substring(0, cookie.length()-3);
	}
	
	/**
	 * Initiate the download-process. Downloads every file stored in the local
	 * list of pending downloads(downloadFiles)
	 * @throws IOException 
	 */
	public void download() throws IOException {
		System.out.println("----------------------------------Initiating Downloads------------------------------");
		for(String link : this.downloadFiles) {
			
			System.out.println("---------------------------------Working on-----------------------------------");
			System.out.println(link);
			
			URL url = new URL(link);
		    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
		    connection.addRequestProperty("Cookie", parsedCookies);
		    int responseCode = connection.getResponseCode();
		 
		    // If response is OK try to download it
		    if (responseCode == HttpsURLConnection.HTTP_OK) {
		    	String fileName = "";
		    			    	
		        String disposition = connection.getHeaderField("Content-Disposition");
		        String contentType = connection.getContentType();
		        int contentLength = connection.getContentLength();
		        
		        if (disposition != null){
		            // extracts file name from disposition
		            int index = disposition.indexOf("filename=");
		            if (index > 0) {
		            	fileName = disposition.substring(index + 10, disposition.length() - 1);
		            }
		        }
		        else {
		        	// extracts file name from URL
		            fileName = link.substring(link.lastIndexOf("/") + 1, link.length());
		        }
		        //print Header
		    	System.out.println("\nSending 'GET' request to URL : " + url);
		    	System.out.println("Response Message : " + responseCode);
		        System.out.println("Content-Type = " + contentType);
		        System.out.println("Content-Disposition = " + disposition);
		        System.out.println("Content-Length = " + contentLength);
		        System.out.println("fileName = " + fileName);
		 
		        // opens input stream from the HTTP connection
		        InputStream inputStream = connection.getInputStream();
		        String saveFilePath =fileName;
		        
		        toFile(inputStream, saveFilePath);
		    }
		    else {
		        System.out.println("No file to download. Server replied HTTP code: " + responseCode);
		    }
		    connection.disconnect();
		}
	}
	
    /**
     * Reads the inputStream of a given connection and saves it to a File
     * @param connection
     * @param fileName
     * @throws IOException 
     */
   
    public void toFile(InputStream inputStream, String fileName) throws IOException {
    	 // opens an output stream to save into file
    	 FileOutputStream outputStream = new FileOutputStream(fileName);
    	 int bytesRead = -1;
    	 byte[] buffer = new byte[BUFFER_SIZE];
    	 while ((bytesRead = inputStream.read(buffer)) != -1) {
    	     outputStream.write(buffer, 0, bytesRead);
    	 }

    	 outputStream.close();
    	 inputStream.close();
    	 
    	 System.out.println("File downloaded");
    }

}
