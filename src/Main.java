import javax.swing.*;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Max Day
 * Created At: 2023/05/31
 */

/**
 * NOTE: there is a very important difference between Double[] and double[]. Double[] is the object and double[] is the primitive data type
 */

public class Main {
    public static void main(String[] args) {
        double[] dArr = new double[5];
        Arrays.setAll(dArr, i -> Double.parseDouble(JOptionPane.showInputDialog("Please enter a double"))); // I will never return to using a for loop for this
        double search = Double.parseDouble(JOptionPane.showInputDialog("Enter the value you would like to search for"));
        int index = searchDouble(dArr, search);
        if (searchDouble(dArr, search) >= 0) {
            System.out.print("The Original array is: ");
            print(dArr);
            System.out.print("\nThe array with the removed element is: ");
            print(deleteArrayIndex(dArr, index));
        } else System.out.printf("The number %s was not found", search);
    }

    public static void print(double[] dArr) {
        Arrays.stream(dArr).mapToObj(v -> v + ", ").forEach(System.out::print);
        System.out.println("\b\b"); // removes random trailing comma
    }

    public static int searchDouble(double[] dArr, double search) { // could also use Arrays.binarySearch
        return IntStream.range(0, dArr.length).filter(i -> dArr[i] == search).findFirst().orElse(-1); // This is so sexy i love it
    }

    public static double[] deleteArrayIndex(double[] dArr, int index) { // this is kinda cheating but nobody in the real world is using for loops to delete elements of arrays
        double[] ddArr = new double[dArr.length - 1];
        System.arraycopy(dArr, 0, ddArr, 0, index);
        System.arraycopy(dArr, index + 1, ddArr, index, ddArr.length - index);
        return ddArr;
    }

    public static double[] deleteArrayIndex2(double[] dArr, int index) { //loop version of the above code
        double[] ddArr = new double[dArr.length - 1];
        int ddArrIndex = 0;
        for (int i = 0; i < dArr.length; i++) {
            if (i != index) {
                ddArr[ddArrIndex] = dArr[i];
                ddArrIndex++;
            }
        }
        return ddArr;
    }
}