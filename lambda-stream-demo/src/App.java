import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {
		List<String> colors = new ArrayList<String>();
		colors.add("blue");
		colors.add("yellow");
		colors.add("black");
		colors.add("red");
		List results = colors.stream().filter(color -> !"blue".equals(color))
				.filter(color -> color.length() > 5)
				.collect(Collectors.toList());
		results.forEach(System.out::println); // lambda here

		Comparator<Integer> intCompare = (Integer e1, Integer a2) -> e1
				.compareTo(a2);

		// Using lambda expression
		Runnable race2 = () -> System.out.println("Hello world !");

		race2.run();

		String[] players = { "Rafael Nadal", "Novak Djokovic",
				"Stanislas Wawrinka", "David Ferrer", "Roger Federer",
				"Andy Murray", "Tomas Berdych", "Juan Martin Del Potro",
				"Richard Gasquet", "John Isner" };

		// Sort players by name using lambda expression
		Comparator<String> sortByName = (String s1, String s2) -> (s1
				.compareTo(s2));

		Arrays.sort(players, sortByName);
		// or this
		Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));
		
		for (int i = 0; i < players.length; i++) {
			System.out.println(players[i]);
		}

	}

}
