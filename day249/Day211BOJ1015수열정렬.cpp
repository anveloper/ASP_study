#include <stdio.h>

int main() {
  int n, a[51] = {0}, b[51] = {0};

  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }

  int cnt = 0;
  for (int i = 1; i < 1001; i++) {
    for (int j = 0; j <= n; j++) {
      int p = i;
      if (p == a[j]) {
        b[j] = cnt;
        cnt++;
      }
    }
  }
  for (int i = 0; i < n; i++)
    printf("%d ", b[i]);

  return 0;
}
