package day349;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day303BOJ17609회문 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String s = br.readLine();

            checkP(s);
            System.out.println(checkP(s));
        }
    }

    private static int checkP(String s) {
        int result = 0;
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {

            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                result = 1;

                int l = left + 1;
                int r = right;

                while (l <= r) {
                    if (l > r)
                        break;
                    if (s.charAt(l) == s.charAt(r)) {
                        l++;
                        r--;
                    } else {
                        result++;
                        break;
                    }
                }

                l = left;
                r = right - 1;
                while (l <= r) {
                    if (s.charAt(l) == s.charAt(r)) {
                        l++;
                        r--;
                    } else {
                        result++;
                        break;
                    }
                }
                if (result >= 2)
                    result -= 1;
                return result;
            }
        }
        return result;
    }
}