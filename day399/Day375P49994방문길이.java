package day399;

class Solution {
    static int N, dir, idx = 5, jdx = 5, ans = 0;
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 }; // 상-> 하 -> 좌 -> 우
    static int[][] map;
    static boolean[][] visited;
    // static HashSet<String> set = new HashSet<>();

    public int solution(String dirs) {
        N = dirs.length();
        map = new int[11][11]; // 5,5 를 기준으로 0,0 부터 10,10 까지 이동
        visited = new boolean[11 * 12 + 11][11 * 12 + 11]; // 좌표 방문 처리, r*최대값+c 로 배열 압축

        for (int i = 0; i < N; i++) {
            char cmd = dirs.charAt(i);
            if (cmd == 'U')
                dir = 0;
            else if (cmd == 'D')
                dir = 1;
            else if (cmd == 'L')
                dir = 2;
            else if (cmd == 'R')
                dir = 3;

            int nr = idx + dr[dir];
            int nc = jdx + dc[dir];

            if (index(nr, nc))
                continue;

            // set.add("" + idx + jdx + nr + nc); // + 문자열 우선 연산
            // set.add("" + nr + nc + idx + jdx);

            // set으로 방문처리하는 것보다 속도가 빠르다.
            if (!visited[idx * 12 + jdx][nr * 12 + nc] && !visited[nr * 12 + nc][idx * 12 + jdx]) {
                visited[idx * 12 + jdx][nr * 12 + nc] = true;
                visited[nr * 12 + nc][idx * 12 + jdx] = true; // 시점-> 종점, 종점 -> 시점 둘다 방문처리
                ans++;
            }

            idx = nr;
            jdx = nc;
        }

        // return set.size() / 2; // set.add 연산이 더 느림.
        return ans;
    }

    static boolean index(int r, int c) {
        return r < 0 || r >= 11 || c < 0 || c >= 11;
    }
}