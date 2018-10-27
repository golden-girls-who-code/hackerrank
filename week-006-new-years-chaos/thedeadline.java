import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int bribes = 0;
        boolean tooChaotic = false;
        int currentIndex = q.length-1; //start at the back because people only bribe those in front of them
        while(currentIndex > 0 && !tooChaotic){
            int correctNumber = currentIndex+1; //number that should be at this index
            if (q[currentIndex] == correctNumber){
                currentIndex--; //this number is at its index, so move on.
            }            
            else if ( q[currentIndex-1] == correctNumber ){ //the correct number was moved up one
                q[currentIndex-1] = q[currentIndex]; //move number in currIndex to the one ahead
                q[currentIndex] = correctNumber; //move our correct number to where it belongs, not necessary, but I chose to do it
                bribes += 1;
                currentIndex--;
            }
            else if ( q[currentIndex-2] == correctNumber ){  //the correct number was moved up 2x
                q[currentIndex-2] = q[currentIndex-1];  //so shift the 2 ahead of it up
                q[currentIndex-1] = q[currentIndex];
                q[currentIndex] = correctNumber; //move our correct number to where it belongs, not necessary, but I chose to do it
                bribes += 2;
                currentIndex--;
            }
            else{
                tooChaotic = true;
            }
        }
        if(tooChaotic){
            System.out.println("Too chaotic");
        }
        else{
            System.out.println(bribes);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}

