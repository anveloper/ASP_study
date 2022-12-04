package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Day301BOJ12738가장긴증가부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(input[i]);
		int[] sequence = new int[N];
		sequence[0] = A[0];
		int answer = 1;
		for (int i = 1; i < N; i++) {
			if (sequence[answer - 1] < A[i]) {
				sequence[answer] = A[i];
				answer++;
			} else {
				int low = 0;
				int high = answer;
				int middle = (low + high) / 2;
				while (low < high) {
					if (sequence[middle] < A[i])
						low = middle + 1;
					else
						high = middle;
					middle = (low + high) / 2;
				}
				sequence[middle] = A[i];
			}
		}
		System.out.print(answer);
	}
}