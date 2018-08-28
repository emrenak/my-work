package ucipclientdemo;

public class App {

	public static void main(String[] args) {
		AIRXmlRpcClient airXmlRpcClient = new AIRXmlRpcClient();
		try {
			airXmlRpcClient.getResponseFromAir();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
