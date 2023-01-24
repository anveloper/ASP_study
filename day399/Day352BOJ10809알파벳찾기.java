package day399;

import java.io.*;

public class Day352BOJ10809알파벳찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        String S = br.readLine();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (arr[ch - 'a'] == -1) {
                arr[ch - 'a'] = i;
            }
        }

        for (int val : arr) {
            System.out.print(val + " ");
        }
    }
}
