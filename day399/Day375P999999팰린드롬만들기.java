package day399;

class Solution {
    static int N, ans;

    public int solution(String plain) {
        N = plain.length() - 1;
        ans = plain.length();

        for (int i = 0; i <= N; i++) {
            String tmp = plain.substring(i); // 앞쪽부터 잘라서 팰린드롭 체크 후에 아닌 길이 만큼 ans에 추가
            if (check(tmp, 0, N - i))
                break;
            ans++; // 팰린드롬이 아닌 만큼을 뒤에 붙혀주기 위한 값 추가
        }
        return ans;
    }

    static boolean check(String s, int st, int ed) {
        while (st <= ed) {
            if (s.charAt(st++) != s.charAt(ed--))
                return false; // 팰린드롬 여부 확인
        }
        return true;
    }
}