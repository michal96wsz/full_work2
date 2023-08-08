package pageObjectModel;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
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
	
	private class Registration {
		
		WebDriver regDriver;
		
		public Registration (WebDriver drv) {
			this.regDriver = drv;
			PageFactory.initElements(this.regDriver, this);
			System.out.println("Utworzyl");
		}
		
		@FindBy (css = ".col-md-6 input[class*=form]")  // "//form //div[contains(@class, 'col-md-6')] //input[contains(@class, 'form-control')]"
		List<WebElement> textFieldsList;
		
		public void fillTextFields(HashMap<String, String> mapka) {
			
			String labelText;
			System.out.println("Jest we funkcji" + textFieldsList.size());
			for(WebElement ele : textFieldsList) {
				labelText = ele.findElement(By.xpath("parent::*/label")).getText();
				System.out.println(labelText);
				if(mapka.containsKey(labelText)) {
					ele.sendKeys(mapka.get(labelText));
				}
			}
			
		}
	}
	
	
	
	@FindBy(css = "input#userEmail")
	WebElement userNameElement; 
	
	@FindBy(css = "input#userPassword")
	WebElement userPasswordElement;
	
	@FindBy(css = "a[class*=link]")
	WebElement forgotPasswordLinkElement;
	
	@FindBy (css = "p[class*=wrapper-footer]")
	WebElement registerLinkTextElement;
	
	
	public void goToGegistrationSubView(HashMap<String, String> mappp) {
		registerLinkTextElement.click();
		Registration regObj = new Registration(this.myDriver);
		regObj.fillTextFields(mappp);
	}

}
