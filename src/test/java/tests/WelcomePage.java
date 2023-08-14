package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MWSlearning.FULL_Work.DriverManager;
import dev.failsafe.internal.util.Assert;
import externalTools.JSONparser;
import net.bytebuddy.implementation.bind.annotation.Super;
import pageObjectModel.InitPage;

public class WelcomePage extends DriverManager{
	String jsonFilePath = "D:\\SeleniumDrivers\\pliczek.json";

	@Test(dataProvider = "getDataFromJSON")
	public void checkWrongCredentials(HashMap<String, String> registartionInputHashMap) throws IOException, InterruptedException {
		boolean result;
		System.out.println(registartionInputHashMap.get("First Name"));
		
		InitPage wPageObj = new InitPage(DriverManager.myDriver);
		wPageObj.getPage("https://rahulshettyacademy.com/client");
		
		wPageObj.goToGegistrationSubView(registartionInputHashMap); //(JSONparser.parseJSONtoHashMap(jsonFilePath));
		Thread.sleep(2000);
		result = wPageObj.chooseOccupation("Student");
		assertTrue(result);
		
//	To do DDT create a json input with a lot of combinations with incorrect sets of data for registration. Update jsonParser so it can return List of hashMaps, adjust InitPage filltextFields method Add some validation in case of wrong input as there are some validation messages
	}
	
	
	
	@DataProvider
	public Object[] getDataFromJSON() throws IOException {
		
		List<HashMap<String, String>> listOfHashMaps = JSONparser.parseJSONtoHashMap(jsonFilePath);
		Object[] arrayOfMaps = new Object[listOfHashMaps.size()];
		
		for(int i = 0; i < listOfHashMaps.size(); i++) {
			arrayOfMaps[i] = listOfHashMaps.get(i);
		}
		
		return arrayOfMaps;
		
	}

}
