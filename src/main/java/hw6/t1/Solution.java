package hw6.t1;

import java.io.*;

class Result {

    /*
     * Complete the 'numberOfOccurrences' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING text
     *  2. STRING target
     */

    public static int numberOfOccurrences(String text, String target) {
        return (text.length() - text.replaceAll(target, "").length()) / target.length();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String text = bufferedReader.readLine();

        String target = bufferedReader.readLine();

        int result = Result.numberOfOccurrences(text, target);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
