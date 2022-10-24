#include <iostream>
#include <map>
#include <string>
using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  map<string, int> m;
  string s;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> s;
    s.erase(0, s.find('.') + 1);
    m[s]++;
  }

  for (auto i : m) {
    cout << i.first << ' ' << i.second << '\n';
  }
  return 0;
}