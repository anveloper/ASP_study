package day699;

public class Day672BOJ1613역사 {
  static int N, K, S;
  static boolean[][] map;

  public static void main(String[] args) throws Exception {
    N = read();
    K = read();
    map = new boolean[N + 1][N + 1];
    for (int i = 0; i < K; i++) {
      int a = read();
      int b = read();
      map[a][b] = true;
    }
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        for (int k = 1; k <= N; k++) {
          if (map[j][i] && map[i][k])
            map[j][k] = true;
        }
      }
    }
    S = read();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < S; i++) {
      int s = read();
      int e = read();

      int ans = 0;
      if (map[s][e])
        ans = -1;
      if (map[e][s])
        ans = 1;

      sb.append(ans).append("\n");
    }
    System.out.println(sb);
  }

  static int read() throws Exception {
    int c, n = System.in.read() & 15;
    while ((c = System.in.read()) > 32) {
      n = (n << 3) + (n << 1) + (c & 15);
    }
    return n;
  }
}