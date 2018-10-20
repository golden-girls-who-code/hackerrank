/**
* Solution to hackerrank min swap problem in Java: https://www.hackerrank.com/challenges/minimum-swaps-2/problem
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
        int counter = 0, currentIndex = 0;
        //using while loop in this case means I don't have to do currentIndex-- to recheck the new number in that position
        while (currentIndex < arr.length-1) {
            int currentNum = arr[currentIndex];
            if (currentNum == currentIndex+1 || currentNum == 0) {
                currentIndex ++;
            }
            else{
              // handle non-consecutive test case where the number is bigger than arrayindex.
                int index2 = ((currentNum <= arr.length) ? currentNum : arr.length) - 1;
                int num2 = arr[index2]; //find what's at its index and save it.
                /** I know n >= 1 so I can set ones that were swapped into the right position to 0
                * and then skip it when I get to it later instead of putting it in the proper spot and recheck.
                * This change takes the time complexity from N to N/2
                */
                arr[index2] = 0;
                arr[currentIndex] = num2; //put whatever was in there in currentIndex.
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
