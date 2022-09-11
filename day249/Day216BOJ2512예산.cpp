#include <bits/stdc++.h>
using namespace std;

int n, k, t, arr[10001];

int solve(int t) {
  int s = 0, e = t;

  while (s <= e) {
    int sum = 0, m = (s + e) / 2;

    for (int i = 0; i < n; i++)
      sum += (arr[i] > m ? m : arr[i]);

    if (sum > k)
      e = m - 1;
    else if (sum < k)
      s = m + 1;
    else
      return m;
  }
  return e;
}

int main() {
  cin.sync_with_stdio(!cin.tie(0));
  cin >> n;
  for (int i = 0; i < n; i++)
    cin >> arr[i], t = max(t, arr[i]);
  cin >> k;

  cout << solve(t);
}
