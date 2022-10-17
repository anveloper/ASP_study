#include <algorithm>
#include <iostream>
using namespace std;
int arr[10001];
int dp[10001];
int N;
int main(void) {
  cin >> N;
  for (int i = 1; i <= N; i++)
    cin >> arr[i];

  for (int i = 1; i <= N; i++) {
    dp[i] = arr[i];
    for (int j = 1; j <= i; j++)
      dp[i] = min(dp[i], dp[i - j] + dp[j]);
  }
  cout << dp[N];
}