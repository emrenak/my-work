package sampleMavenProj;

import java.util.Collections;
import java.util.List;

public class App {
	public static void main(String[] args) {
		System.out.println("=== RunnableTest ===");

		// Anonymous Runnable
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				System.out.println("Hello world one!");
			}
		};

		// Lambda Runnable
		Runnable r2 = () -> System.out.println("Hello world two!");

		// Run em!
		r1.run();
		r2.run();

		List<Person> personList = Person.createShortList();
		
		// Print Asc
		System.out.println("=== Sorted Asc SurName ===");
		Collections.sort(personList, (Person p1, Person p2) -> p1.getSurname().compareTo(p2.getSurname()));

		for (Person p : personList) {
			System.out.println(p.getSurname());
		}

		// Print Desc
		System.out.println("=== Sorted Desc SurName ===");
		Collections.sort(personList,(p1, p2) -> p2.getSurname().compareTo(p1.getSurname()));

		for (Person p : personList) {
			System.out.println(p.getSurname());
		}
	}
}
