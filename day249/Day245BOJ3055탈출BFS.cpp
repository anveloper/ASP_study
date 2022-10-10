#include <iostream>
#include <queue>
#define pii pair<int, int>
using namespace std;

int R, C;
char board[51][51];
int dr[] = {-1, 1, 0, 0};
int dc[] = {0, 0, -1, 1};
int visited[51][51][2];

int main(void) {
  queue<pii> q, w;

  cin >> R >> C;
  for (int i = 0; i < R; i++) {
    for (int j = 0; j < C; j++) {
      cin >> board[i][j];

      if (board[i][j] == 'S') {
        visited[i][j][0] = 1;
        q.push({i, j});
      }

      if (board[i][j] == '*') {
        visited[i][j][1] = 1;
        w.push({i, j});
      }
    }
  }

  while (!w.empty()) {
    int r = w.front().first;
    int c = w.front().second;
    w.pop();

    for (int i = 0; i < 4; i++) {
      int nr = r + dr[i];
      int nc = c + dc[i];

      if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
        if (visited[nr][nc][1] == 0 && board[nr][nc] == '.') {
          visited[nr][nc][1] = visited[r][c][1] + 1;
          w.push({nr, nc});
        }
      }
    }
  }

  while (!q.empty()) {
    int r = q.front().first;
    int c = q.front().second;
    q.pop();

    for (int i = 0; i < 4; i++) {
      int nr = r + dr[i];
      int nc = c + dc[i];

      if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
        if (visited[nr][nc][0] == 0 && board[nr][nc] != 'X' &&
            (visited[r][c][0] + 1 < visited[nr][nc][1] ||
             visited[nr][nc][1] == 0)) {
          if (board[nr][nc] == 'D') {
            cout << visited[r][c][0];
            return 0;
          }

          visited[nr][nc][0] = visited[r][c][0] + 1;
          q.push({nr, nc});
        }
      }
    }
  }

  cout << "KAKTUS";

  return 0;
}