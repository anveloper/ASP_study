package ASP_study.day299;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day298BOJ2075N번째큰수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		for (int j = 0; j < n; j++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());

				if (pq.peek() < num) {
					pq.poll();
					pq.offer(num);
				}
			}
		}

		System.out.println(pq.peek());

	}
}
