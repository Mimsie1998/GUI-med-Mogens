package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.Person;
import model.PersonContainer;

class PersonControllerTest {

    @BeforeAll
    static void init () {
        PersonContainer oc = PersonContainer.getInstance();
        oc.addPerson(new Person("Seb", "Aalborg", "1234"));
    }

    @Test
    void testFindPerson() 
    {
        PersonController personController = new PersonController();
        assertNotNull(personController.findPersonByPhone("1234"));
    }

    @Test
    void testAddPerson()
    {
        PersonContainer personContainer = PersonContainer.getInstance();
        PersonController personController = new PersonController();
        personController.addPerson("Seb", "Aalborg", "1234");
        assertFalse(personContainer.getPersons().isEmpty(), "PersonContainer should not be null");
    }
}