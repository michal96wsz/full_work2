package MWSlearning.FULL_Work;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import externalTools.SQL_implementation;
import pageObjectModel.InitPage;

public class DriverManager {
	protected static WebDriver myDriver;
	int k;
	
	public DriverManager () {
	
	}
	
	private static void initDriver() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumDrivers\\chromedriver.exe");
		
		DriverManager.myDriver = new ChromeDriver();
		System.out.println(DriverManager.myDriver.hashCode());
		//DriverManager.myDriver.get("https://rahulshettyacademy.com/client");
	}
	
	@BeforeTest
	public void initEnv() {
		initDriver();
	}
	
	@AfterTest
	public void closeEnv() {
		//DriverManager.myDriver.close();
	}
	public static void main(String... args) {
		/*
		DriverManager base = new DriverManager();
		InitPage initPageObject = new InitPage(base.myDriver);
		initPageObject.loadInitPage();
		*/
	}

}
