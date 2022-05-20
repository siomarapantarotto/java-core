package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainDeclarative {

    public static void main(String[] args) {

        List<Person> people = getPeople();

        // Declarative approach ✅

        ///////////////////////////////////////////////////////////////////////
        // List all Persons
        //
        System.out.println("\nList all Persons:");

        List<Person> persons = people.stream().toList();
        //.collect(Collectors.toList());

        persons.forEach(System.out::println);

        ///////////////////////////////////////////////////////////////////////
        // Filter females
        // Filters take a Predicate (true or false)
        //
        System.out.println("\nFilter only females:");

        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .toList();
        //.collect(Collectors.toList());

        females.forEach(System.out::println);

        ///////////////////////////////////////////////////////////////////////
        // Filter males
        //
        System.out.println("\nFilter only males:");

        List<Person> males = people.stream()
                .filter(person -> person.getGender().equals(Gender.MALE))
                .toList();
        //.collect(Collectors.toList());

        males.forEach(System.out::println);

        ///////////////////////////////////////////////////////////////////////
        // Sort
        //
        System.out.println("\nSort by descending age:");

        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getGender).reversed())
                .toList();
        //.collect(Collectors.toList());

        sorted.forEach(System.out::println);

        ///////////////////////////////////////////////////////////////////////
        // All match
        //
        System.out.println("\nAll match age > 8?");

        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 8);

        System.out.println(allMatch);

        ///////////////////////////////////////////////////////////////////////
        // Any match
        //
        System.out.println("\nAny match age > 121?");

        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 121);

        System.out.println(anyMatch);

        ///////////////////////////////////////////////////////////////////////
        // None match
        //
        System.out.println("\nNone match name equals Antonio?");

        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Antonio"));

        System.out.println(noneMatch);

        ///////////////////////////////////////////////////////////////////////
        // Max
        //
        System.out.println("\nMax:");

        people.stream()
                .max(Comparator.comparing(Person::getAge))

                .ifPresent(System.out::println);

        ///////////////////////////////////////////////////////////////////////
        // Min
        //
        System.out.println("\nMin");

        people.stream()
                .min(Comparator.comparing(Person::getAge))

                .ifPresent(System.out::println);

        ///////////////////////////////////////////////////////////////////////
        // Group
        //
        System.out.println("\nGroup Persons:");

        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
            //System.out.println();
        });

        ///////////////////////////////////////////////////////////////////////
        // Filter oldest female
        //
        System.out.println("\nFilter oldest female:");

        Optional<String> oldestFemaleAge = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);

        oldestFemaleAge.ifPresent(System.out::println);

        ///////////////////////////////////////////////////////////////////////
        // Filter youngest male
        //
        System.out.println("\nFilter youngest male:");

        Optional<String> youngestMaleAge = people.stream()
                .filter(person -> person.getGender().equals(Gender.MALE))
                .min(Comparator.comparing(Person::getAge))
                .map(Person::getName);

        youngestMaleAge.ifPresent(System.out::println);

        ///////////////////////////////////////////////////////////////////////
        // Filter name first letter
        //
        System.out.println("\nFilter name starting with 'z or 'Z'");

        List<Person> nameFirstLetter = people.stream()
                .filter(person -> person.getName().startsWith("Z"))
                .toList();
        //.collect(Collectors.toList());

        nameFirstLetter.forEach(System.out::println);

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
