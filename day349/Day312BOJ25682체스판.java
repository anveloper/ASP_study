package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day312BOJ25682체스판 {
	static int N, M, K, ans = 2000 * 2000;
	static char[][] map;
	static int[][][] asum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[N + 1][M + 1];
		asum = new int[N + 1][M + 1][2]; // 누적합 배열 0 B 1 W

		for (int i = 1; i < N + 1; i++) {
			String str = br.readLine();
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = str.charAt(j - 1);
				count(i, j, map[i][j]);
			}
		}

		for (int i = 1; i <= N - K + 1; i++) {
			for (int j = 1; j <= M - K + 1; j++) {
				solve(i, j, i + K - 1, j + K - 1);
			}
		}

		System.out.println(ans);
		br.close();
	}

	private static void solve(int r1, int c1, int r2, int c2) {
		int tmp = 2000 * 2000;
		int stB = asum[r2][c2][0] - asum[r1 - 1][c2][0] - asum[r2][c1 - 1][0] + asum[r1 - 1][c1 - 1][0];
		int stW = asum[r2][c2][1] - asum[r1 - 1][c2][1] - asum[r2][c1 - 1][1] + asum[r1 - 1][c1 - 1][1];
		tmp = Math.min(stB, stW);
		ans = Math.min(tmp, ans);
	}

	private static void count(int r, int c, char color) {
		asum[r][c][0] = asum[r - 1][c][0] + asum[r][c - 1][0] - asum[r - 1][c - 1][0];
		asum[r][c][1] = asum[r - 1][c][1] + asum[r][c - 1][1] - asum[r - 1][c - 1][1];

		if (r % 2 == c % 2) {
			if (color == 'W')
				asum[r][c][0]++;
			else if (color == 'B')
				asum[r][c][1]++;
		} else {
			if (color == 'B')
				asum[r][c][0]++;
			else if (color == 'W')
				asum[r][c][1]++;
		}
	}

}
