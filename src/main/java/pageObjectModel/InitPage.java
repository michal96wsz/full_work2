package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitPage {
	WebDriver myDriver; // = new ChromeDriver();
	
	public InitPage (WebDriver drv) {
		this.myDriver = drv;
	}
	
	public void loadInitPage() {
		myDriver.get("https://rahulshettyacademy.com/client");
	}
}
