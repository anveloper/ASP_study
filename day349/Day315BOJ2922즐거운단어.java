package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day315BOJ2922즐거운단어 {
    static enum Type {
        BLANK, VOWEL, CONSONANT, LWORD
    }

    static Type[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        arr = new Type[str.length()];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '_')
                arr[i] = Type.BLANK;
            else
                switch (c) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        arr[i] = Type.VOWEL;
                        break;
                    case 'L':
                        arr[i] = Type.LWORD;
                        break;
                    default:
                        arr[i] = Type.CONSONANT;
                        break;
                }
        }

        System.out.println(recur(0));
        br.close();
    }

    private static long recur(int idx) {
        if (idx == arr.length) {
            int c = 0, v = 0;
            boolean l = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == Type.LWORD) {
                    l = true;
                }
                if (arr[i] == Type.CONSONANT || arr[i] == Type.LWORD) {
                    c++;
                    v = 0;
                } else if (arr[i] == Type.VOWEL) {
                    v++;
                    c = 0;
                }
                if (c > 2 || v > 2) {
                    return 0;
                }
            }
            if (l)
                return 1;
            else
                return 0;
        }
        if (arr[idx] == Type.BLANK) {
            long result = 0L;
            arr[idx] = Type.CONSONANT;
            result += 20 * recur(idx + 1);
            arr[idx] = Type.VOWEL;
            result += 5 * recur(idx + 1);
            arr[idx] = Type.LWORD;
            result += recur(idx + 1);
            arr[idx] = Type.BLANK;
            return result;
        }
        return recur(idx + 1);
    }
}
