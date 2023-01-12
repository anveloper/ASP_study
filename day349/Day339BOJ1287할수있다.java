package day349;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Day339BOJ1287할수있다 {
    private static List<String> postOpr;
    private static String[] stack;
    private static int sp;
    private static final String ROCK = "ROCK";

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String answer;
        answer = getAnswer(in.readLine());
        System.out.println(answer);

    }

    private static String getAnswer(String expr) {
        StringTokenizer st = new StringTokenizer(expr, "+-/*()", true);
        String tkn;
        String opr;
        postOpr = new ArrayList<String>();
        stack = new String[1000];
        sp = 0;

        // make post expression
        while (st.hasMoreTokens()) {
            tkn = st.nextToken();
            if (tkn.equals("+") || tkn.equals("-")) {
                while (sp > 0) {
                    opr = stack[sp - 1];
                    if (opr.equals("*") || opr.equals("/")) {
                        postOpr.add(opr);
                        sp--;
                    } else {
                        break;
                    }
                }
                stack[sp++] = tkn;
            } else if (tkn.equals("*") || tkn.equals("/")) {
                while (sp > 0) {
                    opr = stack[sp - 1];
                    if (opr.equals("*") || opr.equals("/")) {
                        postOpr.add(opr);
                        sp--;
                    } else {
                        break;
                    }
                }
                stack[sp++] = tkn;
            } else if (tkn.equals("(")) {
                stack[sp++] = tkn;
            } else if (tkn.equals(")")) {
                boolean findflag = false;
                while (sp > 0) {
                    opr = stack[--sp];
                    if (opr.equals("(")) {
                        findflag = true;
                        break;
                    }
                    postOpr.add(opr);
                }
                if (!findflag) {
                    return ROCK;
                }
            } else { // number
                postOpr.add(tkn);
            }
        }
        while (sp > 0) {
            postOpr.add(stack[--sp]);
        }

        // // debug
        // for (int i = 0 ; i < postOpr.size() ; i++) {
        // System.out.print(postOpr.get(i));
        // }
        // System.out.println();

        // calculate using BigInteger
        sp = 0;
        String num1 = null, num2 = null;
        BigInteger big1, big2;
        for (int i = 0; i < postOpr.size(); i++) {
            opr = postOpr.get(i);
            if (isOperator(opr)) {
                num2 = (sp > 0) ? stack[--sp] : null;
                num1 = (sp > 0) ? stack[--sp] : null;
                if (num1 == null || num2 == null
                        || isOperator(num1) || isOperator(num2)
                        || isBracket(num1) || isBracket(num2)) {
                    return ROCK;
                }
                big1 = new BigInteger(num1);
                big2 = new BigInteger(num2);
                if (opr.equals("+")) {
                    stack[sp++] = (big1.add(big2)).toString(10);
                } else if (opr.equals("-")) {
                    stack[sp++] = (big1.subtract(big2)).toString(10);
                } else if (opr.equals("*")) {
                    stack[sp++] = (big1.multiply(big2)).toString(10);
                } else if (opr.equals("/")) {
                    try {
                        stack[sp++] = (big1.divide(big2)).toString(10);
                    } catch (ArithmeticException e) {
                        return ROCK;
                    }
                }
            } else if (isBracket(opr)) {
                return ROCK;
            } else {
                stack[sp++] = opr;
            }
        }
        if (sp != 1) {
            return ROCK;
        } else {
            return stack[0];
        }
    }

    private static boolean isOperator(String opr) {
        if (opr.equals("+") || opr.equals("-") || opr.equals("*") || opr.equals("/")) {
            return true;
        }
        return false;
    }

    private static boolean isBracket(String opr) {
        if (opr.equals("(") || opr.equals(")")) {
            return true;
        }
        return false;
    }
}
