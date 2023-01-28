package hello.java.javabasic.algorithm.baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(input));
    }
    public static int fibonacci(int input) {
        if(input == 0) return 0;
        else if (input == 1) return 1;
        return fibonacci(input - 2) + fibonacci(input - 1);
    }
}
