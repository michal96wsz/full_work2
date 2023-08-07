package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.bytebuddy.asm.Advice.This;

public abstract class MainTools {
	private WebDriver myDriver;
	
	public MainTools(WebDriver drv) {
		this.myDriver = drv;
	}
	
	public void getPage(String URL_String) {
		this.myDriver.get(URL_String);
		System.out.println(this.myDriver.hashCode());
	}
	
	public void sendKeysToElement(WebElement element, String keysString) {
		element.sendKeys(keysString);
	}

}
