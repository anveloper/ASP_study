#include <bits/stdc++.h>
using namespace std;

#define cost first
#define st second.first
#define en second.second

using ll = long long;
using ld = long double;

typedef pair<ll, ll> pll;
typedef pair<int, int> pii;

int mst;

int v, e;

vector<pair<int, pii>> edges;

int parent[10005];

int fnd(int node) {
  if (node == parent[node]) {
    return node;
  }
  return parent[node] = fnd(parent[node]);
}

void uni(int node1, int node2) {
  int root1 = fnd(node1);
  int root2 = fnd(node2);
  parent[root1] = root2;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> v >> e;
  while (e--) {
    int a, b, c;
    cin >> a >> b >> c;
    edges.push_back({c, {a, b}});
  }
  for (int i = 1; i <= v; i++) {
    parent[i] = i;
  }
  sort(edges.begin(), edges.end());
  for (auto cur : edges) {
    int root1 = fnd(cur.st);
    int root2 = fnd(cur.en);
    if (root1 == root2)
      continue;
    mst += cur.cost;
    uni(cur.st, cur.en);
  }
  cout << mst;
}