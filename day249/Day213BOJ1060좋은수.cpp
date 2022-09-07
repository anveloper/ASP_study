#include <algorithm>
#include <climits>
#include <cstdio>
#include <vector>

using namespace std;

int dat[52];
int main() { // 구선생님
  int L;
  scanf("%d", &L);
  for (int i = 0; i < L; i++) {
    scanf("%d", &dat[i]);
  }
  sort(dat, dat + L);
  int n;
  scanf("%d", &n);
  vector<pair<long long, int>> vals;
  for (int i = 0; i < L; i++) {
    int prevnum = 0;
    if (i > 0)
      prevnum = dat[i - 1];
    vals.emplace_back(0, dat[i]);
    for (int j = 1; j <= n && prevnum + j <= dat[i] - j; j++) {
      long long cnt = j * (long long)(dat[i] - prevnum - j) - 1;
      vals.emplace_back(cnt, prevnum + j);
      if (dat[i] - j != prevnum + j)
        vals.emplace_back(cnt, dat[i] - j);
    }
  }
  for (int i = 0; i < n; i++)
    vals.emplace_back(LLONG_MAX, dat[L - 1] + i + 1);
  sort(vals.begin(), vals.end());
  for (int i = 0; i < n; i++)
    printf("%d%c", vals[i].second, " \n"[i + 1 == n]);
  return 0;
}