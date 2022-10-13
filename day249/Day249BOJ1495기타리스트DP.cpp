#include <algorithm>
#include <iostream>

using namespace std;

int N, S, M;
int arr[52];
int dp[52][1001];

int main() {
  cin >> N >> S >> M;
  for (int i = 1; i <= N; i++) {
    cin >> arr[i];
  }
  for (int i = 0; i <= N + 1; i++) {
    fill(dp[i], dp[i] + (M + 1), -1);
  }

  dp[0][S] = 1;
  for (int i = 1; i <= N; i++) {
    for (int j = 0; j <= M; j++) {
      if (dp[i - 1][j] == 1) {
        if (j + arr[i] <= M) {
          dp[i][j + arr[i]] = 1;
        }
        if (j - arr[i] >= 0) {
          dp[i][j - arr[i]] = 1;
        }
      }
    }
  }
  int ans = -1;
  for (int j = 0; j <= M; j++) {
    if (dp[N][j] == 1) {
      ans = max(ans, j);
    }
  }
  cout << ans;
  return 0;
}