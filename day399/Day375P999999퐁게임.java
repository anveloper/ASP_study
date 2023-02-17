package day399;

class Solution {
    static int N, ans = 0;
    static int[][] map;
    static boolean isPossible; // 교체 후 가능한 지 여부

    public int solution(int[][] board) {
        N = board.length;
        map = board;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                isPossible = false;
                swap(i, j, i, j + 1);
                if (check('r', i))
                    isPossible = true; // i번째 row가 가능한 지,
                if (check('c', j))
                    isPossible = true; // 변경된 j번째 col이 가능한 지,
                if (check('c', j + 1))
                    isPossible = true; // 변경된 j+1번째 col이 가능 한 지
                if (isPossible)
                    ans++;
                swap(i, j, i, j + 1);

                // j 인덱스 재사용 행, 열 동시 탐색
                isPossible = false;
                swap(j, i, j + 1, i);
                if (check('r', j))
                    isPossible = true; // 변경된 j번째 row가 가능한 지,
                if (check('r', j + 1))
                    isPossible = true; // 변경된 j+1번째 row가 가능한 지
                if (check('c', i))
                    isPossible = true; // i번째 col이 가능한 지
                if (isPossible)
                    ans++;
                swap(j, i, j + 1, i);
            }
        }

        return ans == 0 ? -1 : ans; // 가능한게 없다면 -1
    }

    static boolean check(char type, int idx) {
        int cnt = 1;
        boolean flag = false;
        for (int i = 1; i < N; i++) {
            if (type == 'r') {
                if (map[idx][i] == map[idx][i - 1]) // row방향으로 연속 되는 지
                    cnt++;
                else {
                    if (cnt > 2)
                        return true;
                    cnt = 1;
                }
            } else if (type == 'c') {
                if (map[i][idx] == map[i - 1][idx]) // col방향으로 연속되는 지
                    cnt++;
                else {
                    if (cnt > 2)
                        return true;
                    cnt = 1;
                }
            }
        }
        if (cnt > 2)
            flag = true;
        return flag;
    }

    static void swap(int i, int j, int k, int l) {
        int tmp = map[i][j];
        map[i][j] = map[k][l];
        map[k][l] = tmp;
    }
}