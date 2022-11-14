package ASP_study.day299;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day280BOJ14499주사위구현 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M, x, y, K;
	static int[][] map;
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Dice dice = new Dice();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < K; ++i) {
			int curDir = Integer.parseInt(st.nextToken());

			x += dx[curDir];
			y += dy[curDir];

			if (!isIn(x, y)) {
				x -= dx[curDir];
				y -= dy[curDir];
				continue;
			}

			if (curDir == 1)
				dice.right();
			else if (curDir == 2)
				dice.left();
			else if (curDir == 3)
				dice.up();
			else
				dice.down();

			if (map[x][y] == 0) {
				map[x][y] = dice.down;
			} else {
				dice.down = map[x][y];
				map[x][y] = 0;

			}
			sb.append(dice.up + "\n");
		}
		System.out.println(sb.toString());
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

	static class Dice {
		int up;
		int down;
		int front;
		int back;
		int left;
		int right;

		public void right() {
			int tmp = right;

			right = up;
			up = left;
			left = down;
			down = tmp;
		}

		public void left() {
			int tmp = right;

			right = down;
			down = left;
			left = up;
			up = tmp;
		}

		public void up() {
			int tmp = up;

			up = front;
			front = down;
			down = back;
			back = tmp;
		}

		public void down() {
			int tmp = up;

			up = back;
			back = down;
			down = front;
			front = tmp;
		}

	}
}