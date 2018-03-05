/**
 * 
 */
package iliasDownloader;

import java.io.IOException;

/**
 * @author root
 *
 */
public class Main{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		GetRSSURL login = new GetRSSURL();
		login.login();
		login.getRSSURL();
		login.terminateSession();
	}

}
