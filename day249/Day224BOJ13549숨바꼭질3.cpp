#include <cstring>
#include <iostream>
#include <queue>
#include <stdio.h>

using namespace std;

#define MAX_SIZE 100000 + 1

int N, K;
bool visit[MAX_SIZE];

int BFS() {
  priority_queue<pair<int, int>, vector<pair<int, int>>,
                 greater<pair<int, int>>>
      q;
  q.push({0, N});
  visit[N] = true;
  while (!q.empty()) {
    int time = q.top().first;
    int x = q.top().second;
    q.pop();

    if (x == K)
      return time;

    if (x * 2 < MAX_SIZE && !visit[x * 2]) {
      q.push({time, x * 2});
      visit[x * 2] = true;
    }

    if (x + 1 < MAX_SIZE && !visit[x + 1]) {
      q.push({time + 1, x + 1});
      visit[x + 1] = true;
    }

    if (x - 1 >= 0 && !visit[x - 1]) {
      q.push({time + 1, x - 1});
      visit[x - 1] = true;
    }
  }
}

int main() {
  scanf("%d %d", &N, &K);
  printf("%d\n", BFS());
  return 0;
}
