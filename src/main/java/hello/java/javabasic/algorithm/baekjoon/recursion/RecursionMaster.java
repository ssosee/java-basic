package hello.java.javabasic.algorithm.baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RecursionMaster {

    static Map<String, Integer> result = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i = 0; i < caseNum; i++) {
            String input = br.readLine();
            System.out.println(isPalindrome(input, cnt)+" "+result.get(input));
        }
    }

    public static int recursion(String s, int l, int r, int cnt) {
        result.put(s, ++cnt);
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1, cnt);
    }
    public static int isPalindrome(String s, int cnt) {
        return recursion(s, 0, s.length()-1, cnt);
    }
}
