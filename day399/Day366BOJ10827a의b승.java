import java.io.*;
import java.math.*;
import java.util.*;

public class Day366BOJ10827a의b승 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        BigDecimal a = new BigDecimal(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        BigDecimal res = pow(a, b);

        System.out.print(res.toPlainString());
    }

    public static BigDecimal pow(BigDecimal a, int b) {
        if (b == 1)
            return a;
        BigDecimal half = pow(a, b / 2);
        return (b % 2 == 0) ? half.multiply(half) : a.multiply(half.multiply(half));
    }
}
