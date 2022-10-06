#include <algorithm>
#include <iostream>
using namespace std;

int dp[10001];
int arr[101];

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n, k;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  dp[0] = 0;
  fill(dp + 1, dp + k + 1, 10001);
  for (int i = 0; i < n; i++) {
    for (int j = arr[i]; j <= k; j++) {
      dp[j] = min(dp[j], dp[j - arr[i]] + 1);
    }
  }

  if (dp[k] == 10001)
    cout << "-1";
  else
    cout << dp[k];
  return 0;
}