package ASP_study.day299;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day266BOJ1120문자열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] str1 = st.nextToken().toCharArray();
		char[] str2 = st.nextToken().toCharArray();
		int result = str1.length;
		for (int i = 0; i < str2.length - str1.length + 1; i++) {
			int tmp = 0;
			for (int j = 0; j < str1.length; j++) {
				if (str1[j] != str2[j + i]) {
					tmp++;
				}
			}
			if (result > tmp) {
				result = tmp;
			}
		}
		System.out.println(result);
		br.close();
	}
}
