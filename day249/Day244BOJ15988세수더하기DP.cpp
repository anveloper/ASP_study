#include <iostream>

#define endl "\n"
#define MAX 1000001
#define MOD 1000000009

using namespace std;

int n;
long long dp[MAX];

int main(void) {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int t;
  cin >> t;
  for (int tc = 1; tc <= t; tc++) {
    cin >> n;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    for (int i = 4; i <= n; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
    }
    cout << dp[n] % MOD << endl;
  }

  return 0;
}
