package hw1.t2;

import java.io.*;

class Result {

    /*
     * Complete the 'sumOfNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER size as parameter.
     */

    public static int sumOfNumbers(int size) {
        if (size <= 0 || size > 9) {
            return 0;
        }

        int sum = 0;

        for (int n = 1; n <= size; n++) {
            for (int l = n; l <= size; l++) {
                sum += l;
            }
        }
        return 4 * sum - 2 * size;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int size = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.sumOfNumbers(size);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

