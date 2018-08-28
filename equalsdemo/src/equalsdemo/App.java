package equalsdemo;

public class App {

	public static void main(String[] args) {
		String a = "a";
		String b = "a";
		String c = new String("a");
		String d = new String("a");
		if(a.equals(b)){
			System.out.println("Equal1");
		}
		if(a==b){
			System.out.println("Equal2");
		}
		if(c==d){
			System.out.println("Equal3");
		}
		if(c.equals(d)){
			System.out.println("Equal4");
		}
	}

}
