import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class App {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = "{" + " \"name\" :" + " \"mkyong\" }";
		System.out.println(jsonInString);
		try {
			Staff staff = mapper.readValue(jsonInString, Staff.class);
			System.out.println(staff.getName());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
