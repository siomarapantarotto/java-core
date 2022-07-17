package readfromkeyboard;

import java.util.Scanner;

class Student {
    String name;
    int age;
    float percent;
    boolean isLocal;
    char grade;

    Student(String name, int age, float percent, boolean isLocal, char grade) {
        this.name = name;
        this.age = age;
        this.percent = percent;
        this.isLocal = isLocal;
        this.grade = grade;
    }

    public void displayDetails() {
        System.out.println("Details..............");
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Percent: " + this.percent);
        System.out.println(this.isLocal
                ? "Nationality: Brazilian"
                : "Nationality: Foreigner");
        System.out.println("Grade: " + this.grade);
    }
}

public class ReadStudentData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.next();
        System.out.println("Enter your age: ");
        int age = sc.nextInt();
        System.out.println("Enter your percent: ");
        float percent = sc.nextFloat();
        System.out.println("Are you local (enter true or false): ");
        boolean isLocal = sc.nextBoolean();
        System.out.println("Enter your grade(enter A, or, B or, C or, D): ");
        char grade = sc.next().toCharArray()[0];
        Student std = new Student(name, age, percent, isLocal, grade);
        std.displayDetails();
    }
}
