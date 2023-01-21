package day349;

import java.io.*;
import java.util.*;

public class Day349BOJ7453합이0네정수 {

    static int N;
    static long ans = 0;
    static int[][] data;
    static int preSum[][];
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        data = new int[N][4];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
            data[i][2] = Integer.parseInt(st.nextToken());
            data[i][3] = Integer.parseInt(st.nextToken());
        }

        preSum = new int[2][N * N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                preSum[0][count] = data[i][0] + data[j][1];
                preSum[1][count++] = data[i][2] + data[j][3];
            }
        }
        Arrays.sort(preSum[0]);
        Arrays.sort(preSum[1]);
        int l = 0;
        int r = preSum[0].length - 1;

        int end = N * N;
        while (l < end && 0 <= r) {
            int sum = preSum[0][l] + preSum[1][r];
            int firstCnt = 1;
            int secondCnt = 1;
            if (sum == 0) {
                while (l <= end - 2 && preSum[0][l] == preSum[0][l + 1]) {
                    firstCnt++;
                    l++;
                }
                while (0 < r && preSum[1][r] == preSum[1][r - 1]) {
                    secondCnt++;
                    r--;
                }
                ans += (long) firstCnt * secondCnt;
            }

            if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println(ans);
    }
}
