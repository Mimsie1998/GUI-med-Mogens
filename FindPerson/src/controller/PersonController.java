/**
 * 
 */
package controller;

import model.Person;
import model.PersonContainer;

/**
 * 
 */
public class PersonController {
	private PersonContainer personContainer;
	
	public PersonController() {
		personContainer = PersonContainer.getInstance();
		
	}
	
	public void addPerson(String name, String address, String phone) {
		Person person = new Person(name, address, phone);
		personContainer.addPerson(person);
	}
	
	public Person findPersonByPhone(String phone) {
		Person person =	personContainer.findPersonByPhone(phone);
		return person;
	
	}
}
