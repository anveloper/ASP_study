package ASP_study.day299;

import java.util.*;

public class Day271BOJ1543문서검색 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		String fT = sc.nextLine();
		sc.close();
		int cnt = 0;

		text = text.replaceAll(fT, "1");

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == '1') {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
