package day799;

import java.io.*;
import java.util.*;

public class Day759BOJ1236성지키기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;
		String[] arr = new String[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine();
			if(arr[i].contains("X") == false) {
				count++;
			}
		}
		int max = count;
		count = 0;
		
		for(int i = 0; i < M; i++) {
			int counts = 0;
			for(int j = 0; j < N; j++) {
				if(arr[j].charAt(i) == '.') {
					counts++;
				}
			}
			if(counts == N) count++;
		}
		max = Math.max(max, count);
		
		System.out.println(max);
	}
}
