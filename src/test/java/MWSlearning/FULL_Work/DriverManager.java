package MWSlearning.FULL_Work;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
		ChromeOptions opi = new ChromeOptions();
		opi.addArguments("start-maximized");
		DriverManager.myDriver = new ChromeDriver(opi);
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
