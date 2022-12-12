package day349;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Day309BOJ18111마인 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int N = Integer.valueOf(str[0]);
        int M = Integer.valueOf(str[1]);
        int B = Integer.valueOf(str[2]);
        int[][] field = new int[N][M];

        int sum = B;
        int time = -1;
        int height = -1;
        int max = -1;

        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.valueOf(str[j]);
                sum += field[i][j];
            }
        }

        max = sum / (N * M);

        for (int i = max; i >= 0; i--) {
            int nowTime = 0;
            for (int[] x : field) {
                for (int y : x) {
                    if (y > i) {
                        nowTime += (y - i) * 2;
                    } else if (y < i) {
                        nowTime += (i - y);
                    }
                }
            }

            if (time == -1 || time > nowTime) {
                time = nowTime;
                height = i;
            }
        }

        System.out.print(time + " " + height);
        bw.close();
        br.close();
    }
}
