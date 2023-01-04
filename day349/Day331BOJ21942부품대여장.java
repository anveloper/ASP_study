package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Day331BOJ21942부품대여장 {
    static int N, L, F;
    static PriorityQueue<String[]> ans; // 정답 출력 정렬 큐
    static HashMap<String, Long> tmp; // 벌금자 Hash Map
    static HashMap<String, HashMap<String, Integer>> map; // 회원 별 대여 현황

    static int[] m = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    static int[] days;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        String tmpL = st.nextToken();
        String[] s = tmpL.split("/");
        String[] ss = s[1].split(":");
        L = Integer.parseInt(s[0]) * 24 * 60 + Integer.parseInt(ss[0]) * 60 + Integer.parseInt(ss[1]);
        F = Integer.parseInt(st.nextToken());

        ans = new PriorityQueue<>((o1, o2) -> o1[0].compareTo(o2[0]));
        tmp = new HashMap<>();
        map = new HashMap<>();

        days = new int[12];
        for (int i = 1; i < 12; i++)
            days[i] = m[i - 1] + days[i - 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] d = st.nextToken().split("-");
            String[] t = st.nextToken().split(":");
            String b = st.nextToken();
            String u = st.nextToken();

            int m = convert(d[1], d[2], t[0], t[1]);

            if (map.containsKey(u)) { // 첫 대여 인지
                if (map.get(u).containsKey(b)) { // 첫 장비 인지
                    int min = map.get(u).get(b);
                    long dif = m - min; // 아..
                    if (dif > L) { // 기간을 초과했는 지
                        Long p = (dif - L) * F; // 아..
                        if (tmp.containsKey(u)) { // 초범이 아닌지
                            tmp.put(u, tmp.get(u) + p);
                        } else {
                            tmp.put(u, p);
                        }
                    }
                    map.get(u).remove(b);
                } else {
                    map.get(u).put(b, m);
                }
            } else {
                HashMap<String, Integer> tmp = new HashMap<>();
                tmp.put(b, m);
                map.put(u, tmp);
            }
        }
        tmp.forEach((u, p) -> {
            ans.add(new String[] { u, " " + p });
        });

        if (ans.isEmpty()) {
            System.out.println(-1);
        } else {
            while (!ans.isEmpty()) {
                String[] r = ans.poll();
                sb.append(r[0] + r[1]).append("\n");
            }
            System.out.println(sb);
        }
        br.close();
    }

    private static int convert(String month, String day, String hour, String minute) {
        return days[Integer.parseInt(month) - 1] * 24 * 60 + Integer.parseInt(day) * 24 * 60
                + Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
    }
}
