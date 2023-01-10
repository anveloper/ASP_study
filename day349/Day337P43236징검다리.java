package day349;

import java.util.Arrays;

class Day337P43236징검다리 {
    public static int day337P43236징검다리(int d, int[] arr, int n) {
        Arrays.sort(arr);
        int l = 1, r = d;
        while (l <= r) {
            int mid = (l + r) / 2;
            int cnt = 0;
            int tmp = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] - tmp < mid)
                    cnt++;
                else
                    tmp = arr[i];
            }
            if (d - arr[arr.length - 1] < mid)
                cnt++;
            if (cnt <= n)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(day337P43236징검다리(25, new int[] { 2, 14, 11, 21, 17 }, 2));
    }
}
