#include <iostream>

using namespace std;

int N;

int arr[101];
long long dp[101][21];

int main() {
  long long ans;
  cin >> N;
  for (int i = 1; i <= N; i++) {
    cin >> arr[i];
  }

  int target = arr[N];

  dp[1][arr[1]] = 1;
  for (int i = 2; i <= N - 1; i++) {
    for (int j = 0; j <= 20; j++) {
      if (dp[i - 1][j] == 0)
        continue;
      if (j + arr[i] <= 20) {
        dp[i][j + arr[i]] += dp[i - 1][j];
      }
      if (j - arr[i] >= 0) {
        dp[i][j - arr[i]] += dp[i - 1][j];
      }
    }
  }

  ans = dp[N - 1][target];
  cout << ans;
  return 0;
}