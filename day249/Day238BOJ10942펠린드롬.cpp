#include <bits/stdc++.h>

using namespace std;

int arr[2000];
int pal_odd[2000];
int pal_even[2000];
int n, m;

int main() { // g
  ios::sync_with_stdio(false);
  cin.tie(nullptr);

  int n;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> arr[i];
  }

  for (int i = 0; i < n; ++i) {
    for (int j = 1; j < n; ++j) {
      if (i + j >= n || i - j < 0 || arr[i + j] != arr[i - j])
        break;
      pal_odd[i] += 1;
    }
    if (i == n - 1)
      break;
    int l = i, r = i + 1;
    for (int j = 0; j < n; ++j) {
      if (r + j >= n || l - j < 0 || arr[r + j] != arr[l - j])
        break;
      pal_even[i] += 1;
    }
  }

  cin >> m;

  for (int i = 0; i < m; ++i) {
    int s, e;
    cin >> s >> e;
    s--;
    e--;
    int m = (s + e) / 2;
    int len = e - m;
    if ((e - s) % 2 == 0) {
      if (pal_odd[m] >= len) {
        cout << "1\n";
      } else {
        cout << "0\n";
      }
    } else {
      if (pal_even[m] >= len) {
        cout << "1\n";
      } else {
        cout << "0\n";
      }
    }
  }
}
