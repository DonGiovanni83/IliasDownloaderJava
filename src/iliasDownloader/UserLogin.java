
package iliasDownloader;

import java.io.Console;
import java.util.Scanner;

/**
 * Login interface in the terminal. Credentials of the user are beeing
 * captured and stored
 * @author root
 *
 */
public class UserLogin {
	private String username;
	private String password;
	
	public UserLogin() {
		Scanner scan = new Scanner(System.in);
		//uses Console to mask the password with blank characters
		Console cons = System.console();
		
		System.out.print("\nEnter your username : ");
		this.username = scan.nextLine();
		System.out.print("Enter your password : ");
		char[] passString = cons.readPassword();
	    this.password = new String(passString);
	    
		scan.close();
		
	}
	
	public String[] getCredentials(){
		return new String[]{this.username, this.password};
	}

}
