package hello.java.javabasic.algorithm.baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        System.out.println(factorial(input));
    }
    static int factorial(int input) {
        // 0! 은 1
        if(input <= 1) return 1;
        return factorial(input - 1) * input;
    }
}
