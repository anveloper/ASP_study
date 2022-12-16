package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day312BOJ25682체스판BestSol누적합 {
	static int N, M, K;
	static int[][] b, w;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		b = new int[N + 1][M + 1];
		w = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				if (str.charAt(j - 1) == 'B') {
					if (check(i, j)) {
						sumWhite(i, j);
					} else {
						sumBlack(i, j);
					}
				} else {
					if (check(i, j)) {
						sumBlack(i, j);
					} else {
						sumWhite(i, j);
					}
				}
			}
		}
		int ans = 2000 * 2000; // 최소값 비교

		for (int i = 0; i <= N - K; i++) {
			for (int j = 0; j <= M - K; j++) {
				int bm = b[i + K][j + K] - b[i][j + K] - b[i + K][j] + b[i][j];
				int wm = w[i + K][j + K] - w[i][j + K] - w[i + K][j] + w[i][j];
				int tm = Math.min(bm, wm);
				ans = Math.min(ans, tm);
			}
		}
		System.out.println(ans);
		br.close();
	}

	private static boolean check(int r, int c) {
		return r % 2 == 1 && c % 2 == 1 || r % 2 == 0 && c % 2 == 0;
	}

	private static void sumWhite(int r, int c) {
		b[r][c] = sum(b, r, c);
		w[r][c] = sum(w, r, c) + 1;
	}

	private static void sumBlack(int r, int c) {
		b[r][c] = sum(b, r, c) + 1;
		w[r][c] = sum(w, r, c);
	}

	private static int sum(int[][] a, int r, int c) {
		return a[r - 1][c] + a[r][c - 1] - a[r - 1][c - 1];
	}
}
