import java.io.*;

public class Day358BOJ14916거스름돈 {
    static int N, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (N > 0) {
            if (N % 5 == 0) {
                ans += N / 5;
                N = 0;
                break;
            }
            N -= 2;
            ans++;
        }

        if (N == 0) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
        br.close();
    }
}
