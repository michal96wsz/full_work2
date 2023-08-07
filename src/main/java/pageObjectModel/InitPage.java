package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InitPage extends MainTools{
	WebDriver myDriver; // = new ChromeDriver();
	
	public InitPage (WebDriver drv) {
		super(drv);
		this.myDriver = drv;
		System.out.println(this.myDriver.hashCode());
		
		PageFactory.initElements(this.myDriver, this);
	}
	
	@FindBy(css = " ")
	WebElement userNameElement; 
	
	
	
	
	
}
