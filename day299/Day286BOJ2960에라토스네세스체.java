package ASP_study.day299;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Day286BOJ2960에라토스네세스체 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		br.close();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];

		for (int i = 2; i <= N; i++) {
			arr[i] = i;
		}

		for (int i = 2; i <= N; i++) {
			if (arr[i] == 0)
				continue;

			for (int j = i; j <= N; j += i) {
				if (arr[j] != 0) {
					arr[j] = 0;
					K--;

					if (K == 0)
						bw.write(String.valueOf(j));
				}
			}
		}

		bw.write(String.valueOf(""));
		bw.flush();
		bw.close();
	}
}