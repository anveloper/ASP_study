import java.io.*;

public class Day371BOJ16120PPAP {
    static int cnt;
    static char[] crr;
    static boolean ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        crr = br.readLine().toCharArray();
        ans = true;
        for (int i = 0; i < crr.length; i++) {
            if (crr[i] == 'P') {
                cnt++;
            } else {
                if (i + 1 < crr.length && crr[i + 1] == 'P' && cnt > 1) {
                    i++;
                    cnt--;
                } else {
                    ans = false;
                    break;
                }
            }
        }
        System.out.println(ans && cnt == 1 ? "PPAP" : "NP");
        br.close();
    }
}
