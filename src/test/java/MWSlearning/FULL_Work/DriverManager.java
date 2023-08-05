package MWSlearning.FULL_Work;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import externalTools.SQL_implementation;
import pageObjectModel.InitPage;

public class DriverManager {
	WebDriver myDriver;
	
	public DriverManager () {
		//this.myDriver = drv;
		
		initDriver();
	}
	
	private void initDriver() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumDrivers\\chromedriver.exe");
		
		this.myDriver = new ChromeDriver();
		
	}
	
	public static void main(String... args) {
		DriverManager base = new DriverManager();
		InitPage initPageObject = new InitPage(base.myDriver);
		initPageObject.loadInitPage();
	}

}
