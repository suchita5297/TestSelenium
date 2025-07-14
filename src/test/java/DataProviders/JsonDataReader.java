package DataProviders;

import java.util.List;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;

import io.cucumber.core.internal.com.fasterxml.jackson.core.exc.StreamReadException;
import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.DatabindException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import pojos.Credentials;

public class JsonDataReader {
	
	@DataProvider(name = "JsonData")
	public Object[][] ReadJsonData() throws StreamReadException, DatabindException, IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		List<Credentials> cred= mapper.readValue(new File(System.getProperty("user.dir")+"/src/test/resources/Credentials.json"), new TypeReference<List<Credentials>>() {});
		
		Object[][] data = new Object[cred.size()][1];
		for(int i=0;i<cred.size();i++) {
			data[i][0] = cred.get(i);
		}
		return data;
		
	}

}
