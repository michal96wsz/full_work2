package pageObjectModel;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InitPage extends MainTools{
	WebDriver myDriver; // = new ChromeDriver();
	static Registration regObj;
	
	public InitPage (WebDriver drv) {
		super(drv);
		this.myDriver = drv;
		System.out.println(this.myDriver.hashCode());
		
		PageFactory.initElements(this.myDriver, this);
	}
	
	private class Registration {
		
		WebDriver regDriver;
		Select staticDropDown; //the Registration obj is made static in the main class so all its fields can be non-static because they will appear only once 
		
		public Registration (WebDriver drv) {
			this.regDriver = drv;
			PageFactory.initElements(this.regDriver, this);
			System.out.println("Utworzyl");
			
			staticDropDown = new Select(staticDropDownElement);
		}
		
		@FindBy (css = ".col-md-6 input[class*=form]")  // "//form //div[contains(@class, 'col-md-6')] //input[contains(@class, 'form-control')]"
		List<WebElement> textFieldsList;
		
		@FindBy (css = ".custom-select")
		WebElement staticDropDownElement;
		
		@FindBy(css = "input[value=Male]")
		WebElement genderRadioButton;
		
		
		public void fillTextFields(HashMap<String, String> mapka) {
			
			String labelText;
			//HashMap<String, String> mapka = new HashMap<String, String>();
			System.out.println("Jest we funkcji" + textFieldsList.size());
		
			
				for(WebElement ele : textFieldsList) {
					labelText = ele.findElement(By.xpath("parent::*/label")).getText();
					System.out.println(labelText);
					if(mapka.containsKey(labelText)) {
						ele.sendKeys(mapka.get(labelText));
						
					}
					else if (labelText.contains("Confirm")) {
						ele.sendKeys(mapka.get("Password"));
					}
				}
			
			}
			
		
		
		
		public void selectOccupation(String occupation) {
			//Select staticDropDown = new Select(staticDropDownElement);
			staticDropDown.selectByVisibleText(occupation);
			
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
		if(regObj == null)
			regObj = new Registration(this.myDriver);
		regObj.fillTextFields(mappp);
		
	}
	
	public boolean chooseOccupation(String occupation) {
		
		if(regObj == null)
			regObj = new Registration(this.myDriver);
	
		regObj.selectOccupation(occupation);
		boolean result = regObj.staticDropDown.getFirstSelectedOption().getText().contains(occupation);
		
		
		return result;
	}

}
