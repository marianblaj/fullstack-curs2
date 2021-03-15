package composition;

import domain.Person;

import java.util.List;

public interface PersonProvider {
    List<Person> readPersons();
}
