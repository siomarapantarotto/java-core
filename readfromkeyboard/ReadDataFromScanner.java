package readfromkeyboard;

import java.util.*;

// Read input data from scanner
public class ReadDataFromScanner {

    public static void main (String[] args) {
        int firstValue, secondValue, result;
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Enter a first value:");
        firstValue = Integer.parseInt(scanner.nextLine());
        //System.out.println("Enter a second value:");
        secondValue = Integer.parseInt(scanner.nextLine());
        result = firstValue + secondValue;
        System.out.println(result);
    }
}
