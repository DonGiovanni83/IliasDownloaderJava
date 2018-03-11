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
	 * Downloads the files on these 5 links
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		IliasSession session = new IliasSession(); // login in ilias
		String[] files = new String[5];
		files[0] = "https://ilias.unibe.ch/goto_ilias3_unibe_file_1296670_download.html";
		files[1] = "https://ilias.unibe.ch/goto_ilias3_unibe_file_1283863_download.html";
		files[2] = "https://ilias.unibe.ch/goto_ilias3_unibe_file_1295650_download.html";
		files[3] = "https://ilias.unibe.ch/goto_ilias3_unibe_file_1299723_download.html";
		files[4] = "https://ilias.unibe.ch/goto_ilias3_unibe_file_1295311_download.html";
		HTTPDownloader downloader = new HTTPDownloader(session.getDriver(), files);
		downloader.download();
		session.terminateSession();

		 }		
	}


