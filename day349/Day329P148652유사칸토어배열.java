package day349;

class Day329P148652유사칸토어배열 {
    public static int day329P148652유사칸토어배열(int n, long l, long r) {
        long ans = r - l + 1; // 1의 최대 갯수

        for (long i = l - 1; i < r; i++)
            ans -= recur(n, i); // 0의 갯수 감소시키기

        return (int) ans;
    }

    private static long recur(int n, long l) {
        long cnt = 0; // 구간 0의 갯수, return만 있어도 됨. 불필요
        if (n == 0)
            return 0; // n차수가 0이 되면 1이므로 0의 갯수는 0개
        if (l % 5 == 2)
            return 1; // 11011의 2번째 자리마다 0의 n차수 만큼 갯수가 늘어남
        return cnt += recur(n - 1, l / 5); // 5^n 차수 내리기
    }

    public static void main(String[] args) {
        System.out.println(day329P148652유사칸토어배열(2, 4, 17));
    }
}
/*
 * 1 (1 <= n <= 20)
 * 11011 << n = 1
 * 1101111011000001101111011 << n = 2
 * 11011110110000011011110111101111011000001101111011000000000000000000000000011011110110000011011110111101111011000001101111011
 * 4:....
 */