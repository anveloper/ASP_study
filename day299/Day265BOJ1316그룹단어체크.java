package ASP_study.day299;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day265BOJ1316그룹단어체크 {
	static int N, cnt;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		cnt = 0;

		for (int i = 0; i < N; i++)
			if (check())
				cnt++;

		System.out.println(cnt);
		br.close();
	}

	private static boolean check() throws Exception {
		String str = br.readLine();
		boolean[] check = new boolean[26];
		int prev = 0;
		for (int i = 0; i < str.length(); i++) {
			int current = str.charAt(i);
			if (prev != current)
				if (!check[current - 'a']) {
					check[current - 'a'] = true;
					prev = current;
				} else
					return false;
		}

		return true;
	}
}
