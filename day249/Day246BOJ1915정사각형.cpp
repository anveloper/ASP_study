#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int n, m, ans = 0;
int arr[1001][1001];

int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    string s;
    cin >> s;
    for (int j = 0; j < m; j++) {
      arr[i][j + 1] = s[j] - 48;
    }
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= m; j++) {
      if (arr[i][j] != 0) {
        arr[i][j] =
            min(min(arr[i - 1][j], arr[i][j - 1]), arr[i - 1][j - 1]) + 1;
        ans = max(arr[i][j], ans);
      }
    }
  }
  cout << ans * ans << endl;
  return 0;
}