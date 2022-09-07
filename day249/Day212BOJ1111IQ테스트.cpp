#include <stdio.h>

int main() {
  int n, a, b, v[50], i;
  scanf("%d", &n);
  for (i = 0; i < n; i++)
    scanf("%d", v + i);
  if (n == 1 || (n == 2 && v[0] != v[1])) {
    puts("A");
    return 0;
  }
  if (n == 2) {
    printf("%d\n", v[0]);
    return 0;
  }
  if (v[0] == v[1]) {
    if (v[1] != v[2]) {
      puts("B");
      return 0;
    }
    a = 1, b = 0;
  } else {
    if ((v[2] - v[1]) % (v[1] - v[0])) {
      puts("B");
      return 0;
    }
    a = (v[2] - v[1]) / (v[1] - v[0]);
    b = v[1] - a * v[0];
  }
  for (i = 3; i < n; i++)
    if (v[i] != a * v[i - 1] + b)
      break;
  if (i < n)
    puts("B");
  else
    printf("%d\n", a * v[n - 1] + b);
  return 0;
}
