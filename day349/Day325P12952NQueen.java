package day349;

class Day325P12952NQueen {
    static int D, ans = 0;
    static int[] arr;

    static int day325P12952NQueen(int n) {
        D = n;
        arr = new int[D];
        recur(0);
        return ans;
    }

    private static void recur(int d) {
        if (d == D) {
            ans++;
            return;
        }
        for (int i = 0; i < D; i++) {
            arr[d] = i;
            if (check(d))
                recur(d + 1);
        }
    }

    private static boolean check(int d) {
        for (int i = 0; i < d; i++) {
            if (arr[d] == arr[i])
                return false;
            if (Math.abs(d - i) == Math.abs(arr[d] - arr[i]))
                return false;
        }
        return true;
    }

    // public static void main(String[] args) {
    // System.out.println(day325P12952NQueen(12));
    // }
}
