package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Day333BOJ1918후위표기식 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Character, Integer> pMap = new HashMap<>();
        pMap.put('(', 0);
        pMap.put(')', 0);
        pMap.put('+', 1);
        pMap.put('-', 1);
        pMap.put('*', 2);
        pMap.put('/', 2);

        Stack<Character> st = new Stack<>();
        StringBuffer sb = new StringBuffer();
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('A' <= c && c <= 'Z') {
                sb.append(c);
                continue;
            }
            if (c == '(') {
                st.add(c);
                continue;
            }
            if (c == ')') {
                while (st.peek() != '(') {
                    sb.append(st.pop());
                }
                st.pop();
                continue;
            }
            while (!st.isEmpty() && pMap.get(st.peek()) >= pMap.get(c)) {
                sb.append(st.pop());
            }
            st.add(c);
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        System.out.println(sb);
    }
}
