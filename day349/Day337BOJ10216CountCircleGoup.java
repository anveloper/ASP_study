package day349;

import java.io.*;
import java.util.*;

public class Day337BOJ10216CountCircleGoup {
    static int n, a[][], i, j, R, x, y, p[], X, Y, re;

    static int P(int x) {
        if (x == p[x])
            return x;
        return p[x] = P(p[x]);
    }

    static void u(int x, int y) {
        x = P(x);
        y = P(y);
        p[x] = x < y ? x : y;
        p[y] = x < y ? x : y;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(r.readLine());
        for (; n-- > 0;) {
            re = i = j = Integer.parseInt(r.readLine());
            p = new int[j];
            a = new int[j][3];
            for (; j-- > 0;) {
                StringTokenizer t = new StringTokenizer(r.readLine());
                a[j][0] = Integer.parseInt(t.nextToken());
                a[j][1] = Integer.parseInt(t.nextToken());
                a[j][2] = Integer.parseInt(t.nextToken());
                p[j] = j;
            }
            for (x = 0; x < i; x++)
                for (y = x + 1; y < i; y++) {
                    X = a[x][0] - a[y][0];
                    Y = a[x][1] - a[y][1];
                    R = a[x][2] + a[y][2];
                    if (X * X + Y * Y <= R * R)
                        if (P(x) != P(y)) {
                            re--;
                            u(x, y);
                        }
                }
            w.write(re + "\n");
        }
        w.flush();
    }
}
