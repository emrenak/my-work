package gceligibility;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		while (true){
			ArrayList<String> al = new ArrayList<String>();
			for (int i = 0; i < 50; i++) {
				al.add(""+i);
			}
			al = null;
			al = new ArrayList<String>();
		}

	}

}
