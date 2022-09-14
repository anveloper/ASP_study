#include <bits/stdc++.h>
using namespace std;

struct Pos {
  int z, y, x;
};

int n, m, visited[2][1001][1001];
int map1[1001][1001];
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};
int Bfs() {
  Pos pos = {0, 0, 0};
  visited[0][0][0] = 1;
  queue<Pos> q;
  q.push(pos);
  while (!q.empty()) {
    pos = q.front();
    q.pop();
    if (pos.y == n - 1 && pos.x == m - 1) {
      return visited[pos.z][pos.y][pos.x];
    }
    for (int i = 0; i < 4; i++) {
      int ny = pos.y + dy[i];
      int nx = pos.x + dx[i];
      int z = pos.z;

      if (ny < 0 || nx < 0 || ny > n - 1 || nx > m - 1)
        continue;

      if (map1[ny][nx] == 0 && visited[z][ny][nx] == 0) {
        visited[z][ny][nx] = visited[z][pos.y][pos.x] + 1;
        q.push({z, ny, nx});
      } else if (map1[ny][nx] == 1 && visited[1][ny][nx] == 0 && z == 0) {
        visited[1][ny][nx] = visited[0][pos.y][pos.x] + 1;
        q.push({1, ny, nx});
      }
    }
  }
  return -1;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  string s;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> s;
    for (int j = 0; j < m; j++) {
      if (s[j] == '0') {
        map1[i][j] = 0;
      } else {
        map1[i][j] = 1;
      }
    }
  }

  cout << Bfs();

  return 0;
}