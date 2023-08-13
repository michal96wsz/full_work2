package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import MWSlearning.FULL_Work.DriverManager;
import dev.failsafe.internal.util.Assert;
import externalTools.JSONparser;
import net.bytebuddy.implementation.bind.annotation.Super;
import pageObjectModel.InitPage;

public class WelcomePage extends DriverManager{
	String jsonFilePath = "D:\\SeleniumDrivers\\pliczek.json";

	@Test
	public void checkWrongCredentials() throws IOException, InterruptedException {
		boolean result;
		InitPage wPageObj = new InitPage(DriverManager.myDriver);
		wPageObj.getPage("https://rahulshettyacademy.com/client");
		wPageObj.goToGegistrationSubView(JSONparser.parseJSONtoHashMap(jsonFilePath));
		result = wPageObj.chooseOccupation("Student");
		assertTrue(result);
//	To do DDT create a json input with a lot of combinations with incorrect sets of data for registration. Update jsonParser so it can return List of hashMaps, adjust InitPage filltextFields method Add some validation in case of wrong input as there are some validation messages
	}

}
