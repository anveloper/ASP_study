package ASP_study.day299;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Day263BOJ11478서로다른부분문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		HashSet<String> hs = new HashSet<>();

		for (int i = 1; i <= S.length(); i++) {
			int length = i;
			while (length <= S.length()) {
				hs.add(S.substring(length - i, length));
				length++;
			}
		}

		System.out.println(hs.size());
	}
}