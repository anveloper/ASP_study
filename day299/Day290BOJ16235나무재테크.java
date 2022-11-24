package ASP_study.day299;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day290BOJ16235나무재테크 {

	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static int N, M, K;
	static int[][] map;
	static Deque<Tree> treeList;

	static class Tree {
		int row;
		int col;
		int age;

		public Tree(int row, int col, int age) {
			super();
			this.row = row;
			this.col = col;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Tree [row=" + row + ", col=" + col + ", age=" + age + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], 5);
		}

		Comparator<Tree> comparator = new Comparator<Tree>() {
			@Override
			public int compare(Tree A, Tree B) {
				return A.age - B.age;
			}
		};

		treeList = new LinkedList<>();

		int[][] plusArr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				plusArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int a = Integer.parseInt(st.nextToken());
			treeList.add(new Tree(r, c, a));
		}

		for (int i = 1; i <= K; i++) {
			spring(map);
			autumn(map);
			winter(map, plusArr);
		}

		System.out.println(treeList.size());

	}

	static void spring(int[][] map) {

		Queue<Tree> dList = new LinkedList<>();

		for (int i = 0; i < treeList.size();) {
			Tree nowTree = treeList.poll();
			if (map[nowTree.row][nowTree.col] >= nowTree.age) {
				map[nowTree.row][nowTree.col] -= nowTree.age;
				nowTree.age++;
				i++;
				treeList.add(nowTree);
			} else {
				dList.add(nowTree);
			}
		}

		for (Tree t : dList) {
			map[t.row][t.col] += t.age / 2;
		}
	}

	static void autumn(int[][] map) {
		Queue<Tree> templist = new LinkedList<>();

		for (Tree t : treeList) {
			if (t.age % 5 == 0) {
				templist.add(t);
			}
		}

		while (!templist.isEmpty()) {
			Tree t = templist.poll();

			for (int i = 0; i < 8; i++) {
				int nr = t.row + dr[i];
				int nc = t.col + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;

				treeList.addFirst(new Tree(nr, nc, 1));
			}
		}
	}

	static void winter(int[][] map, int[][] plusArr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += plusArr[i][j];
			}
		}
	}

	static void print(int[][] map) {
		for (int[] data : map) {
			System.out.println(Arrays.toString(data));
		}
	}
}
