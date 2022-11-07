package ASP_study.day299;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day274BOJ1300K번째수이진탐색 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		binary_search(N, K);
	}

	public static void binary_search(int n, int k) {
		int l = 1;
		int r = k;
		while (l <= r) {
			int m = (l + r) / 2;
			int count = 0;
			for (int i = 1; i <= n; i++) {
				count += Math.min(m / i, n);
			}
			if (count < k)
				l = m + 1;
			else
				r = m - 1;
		}
		System.out.println(l);
	}
}
