#include <algorithm>
#include <iostream>
#include <queue>
#include <set>
#include <string>
#include <utility>

std::string s;
int dx[4] = {0, 0, -1, 1};
int dy[4] = {-1, 1, 0, 0};
std::set<std::string> visited;
std::queue<std::pair<std::string, int>> q;

void BFS() {
  q.push(std::make_pair(s, 0));
  visited.insert(s);
  while (!q.empty()) {
    std::string curr = q.front().first;
    int cnt = q.front().second;
    q.pop();
    if (curr == "123456780") {
      std::cout << cnt;
      return;
    }

    int idx = curr.find("0");
    for (int i = 0; i < 4; i++) {
      int nx = (idx % 3) + dx[i];
      int ny = (idx / 3) + dy[i];
      std::string temp = curr;
      temp[idx] = temp[ny * 3 + nx];
      temp[ny * 3 + nx] = '0';
      if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3 &&
          visited.find(temp) == visited.end()) {
        q.push(std::make_pair(temp, cnt + 1));
        visited.insert(temp);
      }
    }
  }
  std::cout << -1;
}

int main() {
  std::string temp;
  for (int i = 0; i < 9; i++) {
    std::cin >> temp;
    s += temp;
  }
  BFS();
}