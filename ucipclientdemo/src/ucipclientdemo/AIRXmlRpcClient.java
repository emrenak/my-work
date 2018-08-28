package ucipclientdemo;

import java.util.Map;

public class AIRXmlRpcClient {

	public Map getResponseFromAir() throws Exception{
		Map m = null;
		try {
			String s = null;
			s.trim();
		}catch (NullPointerException np){
			System.out.println("no available clients");
			throw new RuntimeException("No available clients...");
		}catch (Exception e) {
			System.out.println("in exception");
			return getResponseFromAir();
		}
		
		return m; 
	}
}
