package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import MWSlearning.FULL_Work.DriverManager;
import externalTools.JSONparser;
import net.bytebuddy.implementation.bind.annotation.Super;
import pageObjectModel.InitPage;

public class WelcomePage extends DriverManager{
	String jsonFilePath = "D:\\SeleniumDrivers\\pliczek.json";

	@Test
	public void checkWrongCredentials() throws IOException {
	InitPage wPageObj = new InitPage(DriverManager.myDriver);
	wPageObj.getPage("https://rahulshettyacademy.com/client");
	wPageObj.goToGegistrationSubView(JSONparser.parseJSONtoHashMap(jsonFilePath));
//		
	}

}
