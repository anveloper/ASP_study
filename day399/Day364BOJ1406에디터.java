
import java.io.*;
import java.util.*;

public class Day364BOJ1406에디터 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int m = Integer.parseInt(br.readLine());

        Stack<Character> stackL = new Stack<>();
        Stack<Character> stackR = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stackL.push(s.charAt(i));
        }

        for (int i = 0; i < m; i++) {
            String command = br.readLine();
            char c = command.charAt(0);

            if (c == 'L') {
                if (stackL.size() != 0) {
                    stackR.push(stackL.pop());
                }
            }

            else if (c == 'D') {
                if (stackR.size() != 0) {
                    stackL.push(stackR.pop());
                }
            } else if (c == 'B') {
                if (stackL.size() != 0) {
                    stackL.pop();
                }
            } else if ((c == 'P')) {
                char t = command.charAt(2);
                stackL.push(t);
            }
        }

        while (stackL.size() != 0) {
            stackR.push(stackL.pop());
        }

        while (stackR.size() != 0) {
            bw.write(stackR.pop());
        }

        bw.flush();
        bw.close();
    }
}
