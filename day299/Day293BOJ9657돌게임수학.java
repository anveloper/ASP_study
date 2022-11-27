package ASP_study.day299;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Day293BOJ9657돌게임수학 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		bw.write((N % 7 == 0 || N % 7 == 2) ? "CY" : "SK");
		bw.flush();
		bw.close();
		br.close();
	}
}
