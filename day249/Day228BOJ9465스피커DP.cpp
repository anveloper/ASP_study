#include <algorithm>
#include <iostream>

using namespace std;

int st[100010][2], d[100010][2];

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);

  int t;
  cin >> t;

  while (t--) {
    int n;
    cin >> n;

    for (int i = 0; i < 2; i++)
      for (int j = 0; j < n; j++)
        cin >> st[j][i];

    d[0][0] = st[0][0];
    d[0][1] = st[0][1];
    d[1][0] = d[0][1] + st[1][0];
    d[1][1] = d[0][0] + st[1][1];

    for (int i = 2; i < n; i++) {
      d[i][0] = max(d[i - 1][1], d[i - 2][1]) + st[i][0];
      d[i][1] = max(d[i - 1][0], d[i - 2][0]) + st[i][1];
    }

    cout << max(d[n - 1][0], d[n - 1][1]) << "\n";
  }
}