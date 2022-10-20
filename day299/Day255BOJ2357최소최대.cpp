#include <bits/stdc++.h>
using namespace std;

int main() { // g
  int n, m, k, i;
  scanf("%d %d", &n, &m);
  for (k = 1; k < n; k <<= 1)
    ;
  vector<int> mx;
  vector<int> mn;
  mx.resize(k << 1);
  mn.resize(k << 1);
  for (i = k; i < n + k; i++) {
    scanf("%d", &mx[i]);
    mn[i] = mx[i];
  }
  while (i < k << 1) {
    mx[i] = 0;
    mn[i++] = 1e9;
  }
  for (i = k - 1; i > 0; i--) {
    mx[i] = max(mx[i * 2], mx[i * 2 + 1]);
    mn[i] = min(mn[i * 2], mn[i * 2 + 1]);
  }
  while (m--) {
    int a, b;
    scanf("%d %d", &a, &b);
    if (a > b) {
      a ^= b;
      b ^= a;
      a ^= b;
    }
    a += k - 1;
    b += k - 1;
    int mxn = 0;
    int mnn = 1234567890;
    while (a <= b) {
      mxn = max(mxn, mx[a]);
      mxn = max(mxn, mx[b]);
      mnn = min(mnn, mn[a]);
      mnn = min(mnn, mn[b]);
      a = (a + 1) / 2;
      b = (b - 1) / 2;
    }
    printf("%d %d\n", mnn, mxn);
  }
}