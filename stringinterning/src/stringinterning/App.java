package stringinterning;

public class App {

	public static void main(String[] args) {
		String s1 = "Ege";
		String s2 = "Ege";
		System.out.println(s1==s2);
		String s3 = new String("Ege");
		System.out.println(s1==s3);
		System.out.println(s1==s3.intern());
		
		if(true)
			try {
				System.out.println("in");
			} catch (Exception e) {
				// TODO: handle exception
			}
	}

}
