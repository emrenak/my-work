package sampleMavenProj;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String surname;

	public Person(String surname){
		this.surname = surname;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public static List<Person> createShortList(){
		List<Person> p = new  ArrayList<Person>();
		p.add(new Person("R"));
		return p;
	}
}
