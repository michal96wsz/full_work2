package tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import MWSlearning.FULL_Work.DriverManager;
import net.bytebuddy.implementation.bind.annotation.Super;
import pageObjectModel.InitPage;

public class WelcomePage extends DriverManager{
	HashMap<String, String> regStrings = new HashMap<String, String>(Map.of("First Name", "Bajo", "Last Name", "Jajo"));
	

	@Test
	public void checkWrongCredentials() {
	InitPage wPageObj = new InitPage(DriverManager.myDriver);
	wPageObj.getPage("https://rahulshettyacademy.com/client");
	wPageObj.goToGegistrationSubView(regStrings);
//		
	}

}
