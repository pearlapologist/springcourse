package org.example.dao;

import org.example.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private static final String URL = "jdbc:mysql://localhost:3306/first_db";
    private static final String USERNAME = "root";
    private static final String PSWD = "hjkl;789";
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PSWD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Person> index() {
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM person";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));
                person.setAge(resultSet.getInt("age"));

                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

    public Person show(int id) {
        //    return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
  return null;
    }

    public void save(Person person) {
/*        person.setId(++PEOPLE_COUNT);
        people.add(person);*/
        try {
            Statement statement = connection.createStatement();
            String SQL ="INSERT INTO person VALUES("+1+",'"+ person.getName() +
                    "', "+person.getAge()+", '"+ person.getEmail()+"')";
        statement.executeUpdate(SQL);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int id, Person personUpdate) {
/*        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(personUpdate.getName());
        personToBeUpdated.setAge(personUpdate.getAge());
        personToBeUpdated.setEmail(personUpdate.getEmail());*/
    }

    public void delete(int id) {
        // people.removeIf(p->p.getId()==id);
    }
}
