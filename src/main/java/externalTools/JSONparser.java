package externalTools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.bytebuddy.asm.Advice.Return;

public class JSONparser {
	
	public static HashMap<String, String> parseJSONtoHashMap(String path) throws IOException {
		File jsonFile = new File(path);
		String jsonString = FileUtils.readFileToString(jsonFile, StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> mapka = mapper.readValue(jsonString, new TypeReference<HashMap<String, String>>() {});
		
		return mapka;
	}
	
	/*
	public static void main(String... args) throws IOException {
		JSONparser jprJsoNparser = new JSONparser();
		jprJsoNparser.parseJSONtoHashMap("eee");
	}
*/
}
