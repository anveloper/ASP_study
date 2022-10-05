#include <iostream>
#define endl "\n"
#define MAX 200 + 1
using namespace std;

int N, Max;
int Arr[MAX];
int DP[MAX];

void Input() {
  cin >> N;
  for (int i = 1; i <= N; i++) {
    cin >> Arr[i];
  }
}
void Solution() {
  for (int i = 1; i <= N; i++) {
    DP[i] = 1;
    for (int j = 1; j <= i; j++) {
      if (Arr[j] < Arr[i] && DP[i] < DP[j] + 1) {
        DP[i] = DP[j] + 1;
      }
    }
    if (Max < DP[i])
      Max = DP[i];
  }
  cout << N - Max << endl;
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