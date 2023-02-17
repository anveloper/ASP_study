package day399;

class Solution {
    static int N, ans = 0;

    public int solution(int[] ck) {
        N = ck.length - 1;
        for (int i = 0; i < N; i++) { // 투 포인터 기준을 모든 idx에 대하여 확인
            int l = i, r = i + 1; // i를 기준으로 좌, 우로 움직이는 투 포인터 초기화
            int lsum = ck[l], rsum = ck[r]; // i를 기준으로 좌우 쿠키들의 합 초기화
            while (true) {
                if (lsum == rsum) // 같을때, 현재 ans와 비교하여 더 많이 담았는 지 비교
                    ans = Math.max(ans, lsum);
                if (l > 0 && lsum <= rsum) // 0에 도달하지 않았을 때, 우합 비교 후 포인터 이동
                    lsum += ck[--l];
                else if (r < N && lsum >= rsum) // 최대길이 idx에 도달하지 않았을 때, 좌합 비교후 포인터 이동
                    rsum += ck[++r];
                else
                    break;
            }
        }
        return ans;
    }
}