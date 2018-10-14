/**
* Solution to hackerrank min swap problem in Java.
*
* @author Isabelle Giuong - github.com/thedeadline
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int counter = 0;
        for (int currentIndex = 0; currentIndex < arr.length-1; currentIndex++) {
            int currentNum = arr[currentIndex];
            if (currentNum != currentIndex+1) {
                int index2 = ((currentNum <= arr.length) ? currentNum : arr.length) - 1;
                int num2 = arr[index2]; //find what's at its index and save it.
                arr[index2] = currentNum; //put the element in its proper spot.
                arr[currentIndex] = num2; //put whatever was in there in currentIndex.
                currentIndex --; //don't move pointer up. recheck number. can probably do this recursively
                counter ++;
            }
        }
        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
