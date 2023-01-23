package day399;

import java.util.*;
import java.io.*;

public class Day350BOJ3986좋은단어 {
    static int N, ans = 0;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.length() % 2 == 1)
                continue;
            stack = new Stack<>();
            stack.push(s.charAt(0));
            for (int j = 1; j < s.length(); j++) {
                if (stack.size() > 0 && stack.peek() == s.charAt(j)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(j));
                }
            }
            if (stack.isEmpty())
                ans++;
        }
        System.out.print(ans);
    }
}
