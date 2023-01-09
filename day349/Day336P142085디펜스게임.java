package day349;

import java.util.PriorityQueue;

public class Day336P142085디펜스게임 {
    public static int day336P142085디펜스게임(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int ans = 0;
        for (int e : enemy) {
            pq.add(e); // 내림차순으로 k를 사용할 대상 우선순위를 정한다.
            n -= e; // 군인 n을 소모하여 라운드 정리
            if (n < 0) { // 적이 초과되어 n이 음수가 될 경우
                if (k == 0) // 무적권 k도 없다면
                    return ans; // 이번 라운드 반환 종료
                n += pq.poll(); // 무적권을 가장 큰 e 라운드에 사용하고, 소모되었던 군인 복구
                k--; // 무적권 감소
            }
            ans++; // 라운드 증가
        }
        return enemy.length;
    }

    public static void main(String[] args) {
        System.out.println(day336P142085디펜스게임(7, 3, new int[] { 4, 2, 4, 5, 3, 3, 1 }));
        System.out.println(day336P142085디펜스게임(2, 4, new int[] { 3, 3, 3, 3 }));
    }
}
