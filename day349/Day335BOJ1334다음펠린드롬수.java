package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day335BOJ1334다음펠린드롬수 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] number = br.readLine().trim().toCharArray();

        int mid = number.length / 2;

        int left = 0, right = number.length - 1;

        boolean bigger = false;
        boolean plus = false;
        int sameCount = 0;

        if (number.length == 1)
            bigger = true;
        while (left <= right) {
            if (number[left] == number[right] && left != right) {
                sameCount++;
                if (sameCount == mid)
                    bigger = true;
            } else if (number[left] < number[right]) {
                bigger = true;
                number[right] = number[left];
            } else if (number[left] > number[right]) {
                bigger = false;
                number[right] = number[left];
            }
            if (bigger && (left == right || right - left == 1)) {
                while (number[left] == '9') {
                    number[right] = number[left] = '0';
                    left--;
                    right++;
                    if (left == -1) {
                        plus = true;
                        number[right - 1] = '1';
                        break;
                    }
                }
                if (!plus)
                    number[right] = ++number[left];
                break;
            }
            left++;
            right--;
        }
        if (plus)
            System.out.print(1 + String.valueOf(number));
        else
            System.out.print(number);
    }
}
