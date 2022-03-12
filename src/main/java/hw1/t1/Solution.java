package hw1.t1;

import java.io.*;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'countNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER bottom
     *  2. INTEGER top
     *  3. INTEGER difference
     */

    public static int countNumbers(int bottom, int top, int difference) {
        if (bottom < 0 || top < 0) {
            return 0;
        }

        return (int) IntStream.rangeClosed(bottom, top).filter(num -> shiftDigit(num) - num > difference).count();
    }

    public static int shiftDigit(int number) {
        final String s = String.valueOf(number);
        final String shifted = s.substring(1) + s.charAt(0);
        return Integer.parseInt(shifted);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int bottom = Integer.parseInt(bufferedReader.readLine().trim());

        int top = Integer.parseInt(bufferedReader.readLine().trim());

        int difference = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.countNumbers(bottom, top, difference);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

