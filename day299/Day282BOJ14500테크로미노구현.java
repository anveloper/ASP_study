package ASP_study.day299;

import java.io.*;
import java.util.*;

public class Day282BOJ14500테크로미노구현 {
	static int N, M, max, answer;
	static int[][] board;
	static boolean[][] isVisited;
	static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static void dfs(int r, int c, int depth, int sum) {
		if (answer >= (4 - depth) * max + sum)
			return;
		if (depth == 4) {
			if (sum > answer)
				answer = sum;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + drc[i][0];
			int nc = c + drc[i][1];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M || isVisited[nr][nc])
				continue;
			isVisited[nr][nc] = true;
			dfs(r, c, depth + 1, sum + board[nr][nc]);
			dfs(nr, nc, depth + 1, sum + board[nr][nc]);
			isVisited[nr][nc] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		isVisited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] > max)
					max = board[i][j];
			}
		}
		br.close();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				isVisited[i][j] = true;
				dfs(i, j, 1, board[i][j]);
				isVisited[i][j] = false;
			}
		}
		System.out.println(answer);
	}

}
