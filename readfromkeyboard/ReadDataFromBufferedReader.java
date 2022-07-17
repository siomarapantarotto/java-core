package readfromkeyboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Read input data from buffered reader
public class ReadDataFromBufferedReader {

    public static void main(String[] args) {
        int firstValue, secondValue, result;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("Enter a first value:");
            firstValue = Integer.parseInt(bufferedReader.readLine());
            //System.out.println("Enter a second value:");
            secondValue = Integer.parseInt(bufferedReader.readLine());
            result = firstValue + secondValue;
            System.out.println(result);
        } catch (IOException ioException) {
            //System.out.println(ioException);
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
    }
    }

}
