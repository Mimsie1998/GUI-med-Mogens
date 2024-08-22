/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * 
 */
public class PersonContainer {
	private static PersonContainer instance;
	private ArrayList<Person> persons;
	private PersonContainer() {
		super();
		persons = new ArrayList<>();
	} 
	
	public static PersonContainer getInstance() {
		if (instance == null) {
			instance = new PersonContainer();
		}
		return instance;
	}
	
	
	
	
	public void addPerson(Person newPerson) {
		persons.add(newPerson);
	}

	public Person findPersonByPhone(String phone) {
		Person person = null;
		int index = 0;
		boolean found = false;
		int size = persons.size();
		while(index < size && !found) {
			Person element = persons.get(index);
			if (element.getPhone().equals(phone)) {
				person = element;
				found = true;
			}
			index ++;
			
		}
		return person;
	}
	
}
