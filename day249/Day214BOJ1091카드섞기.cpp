#include <stdio.h>

int n;
int p[48], s[48], prv[48], cur[48];

bool check() {
  for (int i = 0; i < n; i++) {
    if (p[i] != cur[i]) {
      return false;
    }
  }
  return true;
}

int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d", &p[i]);
    cur[i] = i % 3;
  }

  for (int i = 0; i < n; i++) {
    scanf("%d", &s[i]);
  }

  int cnt = 0;
  while (true) {
    if (check()) {
      printf("%d", cnt);
      return 0;
    }

    for (int i = 0; i < n; i++) {
      prv[i] = cur[i];
    }

    bool fin = true;
    for (int i = 0; i < n; i++) {
      cur[i] = prv[s[i]];

      if (cur[i] != (i % 3)) {
        fin = false;
      }
    }

    if (fin) {
      break;
    }
    cnt++;
  }
  printf("-1");
  return 0;
}