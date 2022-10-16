#include <bits/stdc++.h>

#define MAX 1004

using namespace std;

int dp[MAX][MAX];
string S, T, ret;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> S >> T;
  for (int i = 1; i <= S.size(); i++) {
    for (int j = 1; j <= T.size(); j++) {
      if (S[i - 1] == T[j - 1])
        dp[i][j] = dp[i - 1][j - 1] + 1;
      else
        dp[i][j] = max(dp[i][j - 1], dp[i - 1][j]);
    }
  }
  int i = S.size();
  int j = T.size();
  while (dp[i][j]) {
    int now = dp[i][j];
    if (dp[i - 1][j] == now - 1 && dp[i][j - 1] == now - 1) {
      ret += S[i - 1];
      i--;
      j--;
    } else if (dp[i - 1][j] == now - 1 && dp[i][j - 1] == now)
      j--;
    else if (dp[i - 1][j] == now)
      i--;
  }
  reverse(ret.begin(), ret.end());
  cout << dp[S.size()][T.size()] << "\n";
  cout << ret << "\n";

  return 0;
}
