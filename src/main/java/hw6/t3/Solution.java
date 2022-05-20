package hw6.t3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Result {

    /*
     * Complete the 'maxRating' function below.
     *
     * The function is expected to return a DOUBLE.
     * The function accepts STRING ratingInfo as parameter.
     */

    public static double maxRating(String ratingInfo) {
        final String regex = "(\\(\\d\\.?\\d?\\))";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(ratingInfo);
        final List<String> results = new ArrayList<>();

        while (matcher.find()) {
            results.add(matcher.group());
        }

        return results.stream().map(s -> s.replaceAll("[()]", "")).mapToDouble(Double::new).max().orElse(0);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String ratingInfo = bufferedReader.readLine();

        double result = Result.maxRating(ratingInfo);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

