#include <iostream>

using namespace std;

int n, e;

int dist[801][801];
bool check[801][801];

int a, b, c;

int v1, v2;

#define MAX 100000000

void search(int idx) {
  int mini = MAX;
  int sIndex = 0;
  for (int i = 1; i <= n; i++) {
    if (check[idx][i])
      continue;
    if (dist[idx][i] < mini) {
      mini = dist[idx][i];
      sIndex = i;
    }
  }

  if (sIndex == 0)
    return;
  int lIndex = sIndex;

  while (true) {
    int mini = MAX;
    int sIndex = 0;
    for (int i = 1; i <= n; i++) {
      if (check[idx][i])
        continue;
      if (dist[idx][i] > dist[idx][lIndex] + dist[lIndex][i]) {
        dist[idx][i] = dist[idx][lIndex] + dist[lIndex][i];
        dist[i][idx] = dist[idx][i];
      }

      if (dist[idx][i] < mini) {
        mini = dist[idx][i];
        sIndex = i;
      }
    }

    if (sIndex == 0)
      break;
    else {
      lIndex = sIndex;
      check[idx][sIndex] = true;
    }
  }
}

int main() { // g
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> n >> e;

  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      if (i == j)
        check[i][j] = true;
      else
        dist[i][j] = MAX;
    }
  }

  for (int i = 0; i < e; i++) {
    cin >> a >> b >> c;
    dist[a][b] = c;
    dist[b][a] = c;
  }

  cin >> v1 >> v2;

  search(1);
  search(n);
  search(v1);

  int ans = min(dist[1][v1] + 2 * dist[v1][v2] + dist[v1][n],
                dist[1][v2] + 2 * dist[v1][v2] + dist[v2][n]);
  ans = min(ans, dist[1][v1] + dist[v1][v2] + dist[v2][n]);
  ans = min(ans, dist[1][v2] + dist[v1][v2] + dist[v1][n]);

  if (ans >= MAX)
    cout << -1;
  else
    cout << ans;
}