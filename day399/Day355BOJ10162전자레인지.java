import java.util.Scanner;

public class Day355BOJ10162전자레인지 {
    static int T, A, B, C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        if (T >= 300) {
            A = T / 300;
            T -= 300 * A;
        }
        if (T >= 60) {
            B = T / 60;
            T -= 60 * B;
        }
        if (T % 10 != 0) {
            System.out.println(-1);
        } else {
            C = T / 10;
            System.out.println(A + " " + B + " " + C);
        }
        sc.close();
    }
}
