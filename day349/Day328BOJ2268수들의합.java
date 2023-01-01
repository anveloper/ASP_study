package day349;

import java.io.*;
import java.util.*;

public class Day328BOJ2268수들의합 { // goo선생님
    static int num, numOfQueries;
    static long[] tree, arr;

    static long sum(int pos) {
        long ret = 0;
        while (pos > 0) {
            ret += tree[pos];
            pos &= (pos - 1);
        }
        return ret;
    }

    static void add(int pos, long val) {
        while (pos < tree.length) {
            tree[pos] += val;
            pos += (pos & -pos);
        }
    }

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();
        num = in.nextInt();
        numOfQueries = in.nextInt();
        tree = new long[num + 1];
        arr = new long[num + 1];
        for (int idx = 0; idx < numOfQueries; idx++) {
            int type = in.nextInt();
            int i = in.nextInt();
            int j = in.nextInt();
            long val;
            if (type == 0) {
                if (i <= j)
                    val = sum(j) - sum(i - 1);
                else
                    val = sum(i) - sum(j - 1);
                sb.append(val).append("\n");
            } else {
                add(i, j - arr[i]);
                arr[i] = j;
            }
        }
        System.out.println(sb);
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;

        public InputReader(InputStream st) {
            this.stream = st;
        }

        public int read() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}