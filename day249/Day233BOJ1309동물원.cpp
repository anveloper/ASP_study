#include <iostream>
int mod = 9901, d[100001] = {0, 3, 7}, n, i = 3;
int main() {
  std::cin >> n;
  for (; i <= n; i++)
    d[i] = (2 * d[i - 1] + d[i - 2]) % mod;
  std::cout << d[n];
}