package ASP_study.day299;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day262BOJ1213팰린드롬만들기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();

		int[] arr = new int[26];

		for (int i = 0; i < line.length(); i++) {
			arr[line.charAt(i) - 'A']++;
		}

		int isOne = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0)
				isOne++;
		}

		String answer = "";
		StringBuilder sb = new StringBuilder();
		if (isOne > 1)
			answer += "I'm Sorry Hansoo";
		else {
			for (int i = 0; i < arr.length; i++) {

				for (int r = 0; r < arr[i] / 2; r++) {
					sb.append((char) (i + 65));
				}
			}
			answer += sb.toString();
			String end = sb.reverse().toString();

			sb = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] % 2 == 1) {
					sb.append((char) (i + 65));
				}
			}
			answer += sb.toString() + end;
		}
		System.out.println(answer);
	}
}
