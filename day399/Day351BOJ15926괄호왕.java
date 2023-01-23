package day399;

import java.util.*;
import java.io.*;

public class Day351BOJ15926괄호왕 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        Stack<Integer> s = new Stack<>();
        s.add(-1);
        int answer = 0;
        for (int i = 0; i < num; i++) {
            char c = str.charAt(i);
            if (c == '(')
                s.add(i);
            else {
                s.pop();
                if (s.empty()) {
                    s.add(i);
                    continue;
                }
                int idx = s.peek();
                answer = Math.max(answer, i - idx);
            }
        }
        System.out.print(answer);
    }
}
