package day399;

import java.io.*;

public class Day352BOJ11720숫자의합 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int sum = 0;

        for (byte value : br.readLine().getBytes())
            sum += (value - '0');

        System.out.print(sum);
    }
}
