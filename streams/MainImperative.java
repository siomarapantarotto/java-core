package streams;

import java.util.ArrayList;
import java.util.List;

public class MainImperative {

    public static void main(String[] args) {

        List<Person> people = getPeople();

        // Imperative approach ❌

        ///////////////////////////////////////////////////////////////////////
        // List all
        //
        System.out.println("\nList all the persons:");
        people.forEach(System.out::println);


        ///////////////////////////////////////////////////////////////////////
        // Filter females
        //
        System.out.println("\nFilter only females:");

        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (person.getGender().equals(Gender.FEMALE)) {
                females.add(person);
            }
        }

        females.forEach(System.out::println);

        ///////////////////////////////////////////////////////////////////////
        // TODO: etc etc etc
        //
    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Antonio", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE),
                new Person("Zeno Brown", 121, Gender.MALE)
        );
    }

}