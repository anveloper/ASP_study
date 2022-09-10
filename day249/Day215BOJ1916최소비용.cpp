#include <bits/stdc++.h>
using namespace std;

typedef pair<int, int> pii;

int n, m, s, e, a, b, c, ans[1001];
bool visited[1001]{};
vector<pii> g[1001];
priority_queue<pii, vector<pii>, greater<pii>> pq;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> m;
  while (m--) {
    cin >> a >> b >> c;
    g[a].push_back({b, c});
  }
  cin >> s >> e;
  fill(ans, ans + 1001, INT32_MAX);
  ans[s] = 0;
  pq.push({0, s});
  while (1) {
    while (!pq.empty() && visited[pq.top().second]) {
      pq.pop();
    }
    if (pq.empty()) {
      break;
    }
    int cur{pq.top().second};
    pq.pop();
    visited[cur] = true;
    for (pii next : g[cur]) {
      if (ans[cur] + next.second < ans[next.first]) {
        ans[next.first] = ans[cur] + next.second;
        pq.push({ans[next.first], next.first});
      }
    }
  }
  cout << ans[e];
}