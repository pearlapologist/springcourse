package org.example.dao;

import org.example.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Ummm", 24, "ummmmm@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Мне скучно", 19,"fdf;;sfs@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "И лень",17, "vovatidebyl@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Katy",20, "katyyy@gmail.com"));
    }
    public List<Person> index(){
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
    public void update(int id, Person personUpdate){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(personUpdate.getName());
        personToBeUpdated.setAge(personUpdate.getAge());
        personToBeUpdated.setEmail(personUpdate.getEmail());
    }
    public void delete(int id){
      people.removeIf(p->p.getId()==id);
    }
}
