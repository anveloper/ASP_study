#include <bits/stdc++.h>
using namespace std;

char a[25][25];
int visited[25][25], check[30];
int R, C, ret;
int dr[4] = {-1, 1, 0, 0};
int dc[4] = {0, 0, -1, 1};
string s;

void dfs(int r, int c, int cnt) {
  ret = max(ret, cnt);
  for (int i = 0; i < 4; i++) {
    int nr = r + dr[i];
    int nc = c + dc[i];

    if (nr < 0 || nc < 0 || nr >= R || nc >= C || check[a[nr][nc] - 'A'])
      continue;

    check[a[nr][nc] - 'A'] = 1;
    dfs(nr, nc, cnt + 1);
    check[a[nr][nc] - 'A'] = 0;
  }
}

int main() {
  cin >> R >> C;
  for (int i = 0; i < R; i++) {
    cin >> s;
    for (int j = 0; j < C; j++) {
      a[i][j] = s[j];
    }
  }

  check[a[0][0] - 'A'] = 1;

  dfs(0, 0, 1);
  cout << ret;
  return 0;
}