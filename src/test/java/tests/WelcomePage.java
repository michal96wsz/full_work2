package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import MWSlearning.FULL_Work.DriverManager;
import net.bytebuddy.implementation.bind.annotation.Super;
import pageObjectModel.InitPage;

public class WelcomePage extends DriverManager{
	

	@Test
	public void checkWrongCredentials() {
	InitPage wPageObj = new InitPage(DriverManager.myDriver);
	wPageObj.getPage("https://rahulshettyacademy.com/client");

//		
	}

}
