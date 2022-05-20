package hw6.t4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Result {

    /*
     * Complete the 'ipAddresses' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING ipAddressesInfo as parameter.
     */

    public static String ipAddresses(String ipAddressesInfo) {
        final String regex = "((\\b25[0-5]|\\b2[0-4][0-9]|\\b[01]?[0-9][0-9]?)(\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3})";;
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(ipAddressesInfo);
        final List<String> results = new ArrayList<>();

        while (matcher.find()) {
            results.add(matcher.group());
        }

        return String.join("<->",results);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String ipAddressesInfo = bufferedReader.readLine();

        String result = Result.ipAddresses(ipAddressesInfo);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


