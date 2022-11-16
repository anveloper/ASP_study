package ASP_study.day299;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day283BOJ14890경사로구현 {
	static int N, L, CNT;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		CNT = 0;
		for (int i = 0; i < N; i++) {
			check(map[i]);
		}

		for (int i = 0; i < N; i++) {
			int temp[] = new int[N];
			for (int j = 0; j < N; j++) {
				temp[j] = map[j][i];
			}
			check(temp);
		}
		System.out.println(CNT);
	}

	private static void check(int[] map) {

		int f = map[0];
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			if (map[i] != f) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			CNT++;
			return;
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (map[i] == f)
				cnt++;
			else if (map[i] == f + 1) {
				if (cnt >= L)
					cnt = 1;
				else
					return;
			} else if (map[i] == f - 1) {
				if (i + L - 1 < N) {
					for (int j = i; j < i + L; j++) {
						if (map[j] != f - 1)
							return;
					}
					i += (L - 1);
					cnt = 0;
				} else
					return;
			} else
				return;
			f = map[i];
		}
		CNT++;
	}
}