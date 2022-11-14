package ASP_study.day299;

import java.io.*;
import java.util.*;

public class Day281BOJ17144공청기구현 {
	static int R, C, T; // 행
	static int[][] map;

	static class Machine {
		int upX, upY;
		int downX, downY;

		public Machine(int upX, int upY, int downX, int downY) {
			super();
			this.upX = upX;
			this.upY = upY;
			this.downX = downX;
			this.downY = downY;
		}
	}

	static Machine machine;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		boolean isMachine = false;
		machine = null;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1 && !isMachine) { // (0,0) ~ (R,C) 위에서부터 검사하므로 downX는 +1
					machine = new Machine(i, j, i + 1, j);
					map[i + 1][j] = -1;
					isMachine = true;
				}
			}
		}

		for (int t = 1; t <= T; t++) {
			map = dust();
			cleaner();
		}
		int ans = 0;
		for (int[] ma : map) {
			for (int m : ma) {
				if (m > 0)
					ans += m;
			}
		}
		System.out.println(ans);
	}

	public static int[][] dust() {
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int[][] newmap = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					int res = map[i][j] / 5;
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int nx = i + dr[d];
						int ny = j + dc[d];

						if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1)
							continue;
						if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != -1) {
							cnt++;
							newmap[nx][ny] += res;
						}

					}
					newmap[i][j] += map[i][j] - (cnt * res);

				}
			}
		}
		newmap[machine.upX][machine.upY] = -1;
		newmap[machine.downX][machine.downY] = -1;
		return newmap;
	}

	public static void cleaner() {
		windUp();
		windDown();
	}

	public static void windUp() {
		int x = machine.upX;
		int y = machine.upY;

		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		for (int d = 0; d < 4; d++) {

			while (true) {
				int nx = x + dr[d];
				int ny = y + dc[d];
				if (nx >= 0 && nx <= machine.upX && ny >= 0 && ny <= C - 1) {
					map[x][y] = map[nx][ny];
					x = nx;
					y = ny;
				} else {
					break;
				}
			}
		}
		map[machine.upX][machine.upY] = -1;
		map[machine.upX][machine.upY + 1] = 0;
	}

	public static void windDown() {
		int sx = machine.downX;
		int sy = machine.downY;
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		for (int d = 0; d < 4; d++) {
			while (true) {
				int nx = sx + dr[d];
				int ny = sy + dc[d];
				if (nx >= machine.downX && nx <= R - 1 && ny >= 0 && ny <= C - 1) {
					map[sx][sy] = map[nx][ny];
					sx = nx;
					sy = ny;
				} else {
					break;
				}

			}
		}
		map[machine.downX][machine.downY] = -1;
		map[machine.downX][machine.downY + 1] = 0;
	}
}
