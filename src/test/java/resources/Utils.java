package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification objRequestSpecification;

	public RequestSpecification requestSpecification() throws IOException {
		if (objRequestSpecification == null) {
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			objRequestSpecification = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
					.addQueryParam("key", "qaclick123").addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
			return objRequestSpecification;
		}
		
		return objRequestSpecification;
	}

	public String getGlobalValue(String propKey) throws IOException {
		Properties prop = new Properties();
		FileInputStream fileInputStream = new FileInputStream(
				"C:\\Users\\M1043004\\DevOps\\API-Framework\\src\\test\\java\\resources\\application.properties");
		prop.load(fileInputStream);
		return prop.getProperty(propKey);
	}
	
	public String getJsonPath(Response response,String key)
	{
		  String resp=response.asString();
		JsonPath   js = new JsonPath(resp);
		return js.get(key).toString();
	}
}
