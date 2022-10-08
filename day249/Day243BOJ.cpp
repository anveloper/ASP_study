#include <iostream>
#include <vector>

#define MAX 1000001
using namespace std;

int n;
int dp[MAX][2];
vector<vector<int>> edges;
vector<int> visit;

void dfs(int node) {
  visit[node] = 1;
  dp[node][0] = 0;
  dp[node][1] = 1;
  for (int i = 0; i < edges[node].size(); i++) {
    int cnode = edges[node][i];
    if (visit[cnode])
      continue;
    dfs(cnode);
    dp[node][0] += dp[cnode][1];
    dp[node][1] += min(dp[cnode][0], dp[cnode][1]);
  }
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  cin >> n;
  edges.resize(n + 1);
  visit.resize(n + 1);

  int u, v;
  for (int i = 1; i < n; i++) {
    cin >> u >> v;
    edges[u].push_back(v);
    edges[v].push_back(u);
  }
  dfs(1);
  cout << min(dp[1][0], dp[1][1]);
  return 0;
}