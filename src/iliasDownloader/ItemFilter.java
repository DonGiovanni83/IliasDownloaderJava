package iliasDownloader;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemFilter extends IliasSession{
	protected List<WebElement> ItemList;
	protected String PARENT_CONTAINER = "il_Block";
	protected String linkText = "https://ilias.unibe.ch/goto_ilias3_unibe_crs";
	
	//filter the current page for elements
	public ItemFilter() {
		super();
		WebElement parentContainer = driver.findElement(By.className(PARENT_CONTAINER));
		this.ItemList = parentContainer.findElements(By.tagName("h4"));
	}
	
	public List<WebElement> getItems(WebDriver driver) {
		return this.ItemList;
	}
	
	public void createList() {
		//List that will be printed
		List<String> strings = new ArrayList<String>();
		//for each element store its name for printing and add it to the layer
		for(WebElement e : this.ItemList){
		    strings.add("> "+e.getText());
		    //Il_Item item = new Il_Item(e.getText(), e);
		    //layer.add(item);    
		}
		//print each Item you found
		strings.forEach(System.out::println);
		//layer.print();
	}
	
	
	public void printCourses() {
		System.out.println("----------------------------Your courses-----------------------------");
		createList();
	}
	
}
