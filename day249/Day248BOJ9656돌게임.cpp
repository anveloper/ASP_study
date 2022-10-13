#include <iostream>
#define endl "\n"
#define MAX 1010
using namespace std;
int N;
int DP[MAX];
void Input() { cin >> N; }
void Solution() {
  DP[1] = 0;
  DP[2] = 1;
  DP[3] = 0;
  for (int i = 4; i <= N; i++) {
    if (DP[i - 1] == 0 || DP[i - 3] == 0)
      DP[i] = 1;
    else
      DP[i] = 0;
  }
  if (DP[N] == 1)
    cout << "SK" << endl;
  else
    cout << "CY" << endl;
}
void Solve() {
  Input();
  Solution();
}
int main(void) {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  Solve();
  return 0;
}
