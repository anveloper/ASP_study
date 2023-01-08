#include <iostream>
using namespace std;
int n, i, f;
string s, a;
int main()
{
    cin >> s;
    a = s;
    n = a.size();
    string p(n, '9');
    if (a == p)
    {
        for (i = 0; i < n; i++)
            a[i] = '0';
        a[0] = '1', a += '0', n++;
        s.insert(s.begin(), '0');
    }
    for (i = n - 1; i >= n / 2; i--)
        a[i] = a[n - i - 1];
    for (i = 0; i < n; i++)
        if (a[i] != s[i])
        {
            f = a[i] > s[i];
            break;
        }
    for (i = n / 2; !f && i < n; i++)
    {
        if (a[i] > s[i] || a[n - i - 1] > s[n - i - 1])
            break;
        if (a[i] == '9')
        {
            if (!(n % 2) || i != n / 2)
                a[n - i - 1] = '0';
            a[i] = '0';
            continue;
        }
        if (a[i] <= s[i])
        {
            if (i != n - i - 1)
                a[n - i - 1]++;
            a[i]++, i--;
        }
    }
    cout << a << endl;
}
