package hw6.t2;

import java.io.*;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

class Result {

    /*
     * Complete the 'firstWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING postText as parameter.
     */

    public static String firstWords(String postText) {
        return Arrays.stream(postText.split("([.!?])")).map(String::trim).map(s -> Arrays.stream(s.split("([^\\w\\'\\-])")).findFirst()).filter(Optional::isPresent).map(Optional::get).map(String::toUpperCase).collect(Collectors.joining("_"));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String postText = bufferedReader.readLine();

        String result = Result.firstWords(postText);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
