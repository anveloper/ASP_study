package ASP_study.day299;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day278BOJ12904 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();

		while (S.length() != T.length()) {
			char ch = T.charAt(T.length() - 1);
			T = T.substring(0, T.length() - 1);
			if (ch == 'B') {
				StringBuilder sb = new StringBuilder(T);
				T = (sb.reverse()).toString();
			}
		}

		if (S.equals(T)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}