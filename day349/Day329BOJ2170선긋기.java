package day349;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Day329BOJ2170선긋기 {
    static class Node {
        int l;
        int r;

        Node(int h, int o) {
            l = Integer.min(h, o);
            r = h + o - l;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Node> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(arr, (A, B) -> A.l == B.l ? A.r - B.r : A.l - B.l);
        int ans = arr.get(0).r - arr.get(0).l, r = arr.get(0).r;
        for (int i = 1; i < N; i++) {
            if (arr.get(i).l <= r) {
                ans += Integer.max(0, arr.get(i).r - r);
                r = Integer.max(r, arr.get(i).r);
            } else {
                ans += arr.get(i).r - arr.get(i).l;
                r = arr.get(i).r;
            }
        }
        System.out.println(ans);
    }
}

