package hello.java.javabasic.algorithm.baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://www.acmicpc.net/problem/2447">별 찍기</a>
 */

// drawStarBottom(9)
// drawStarBottom(3) + 아래
// drawStarBottom(1) + 아래
// drawStarMiddle(9)
// 1 + drawStarMiddle(3) + 중간
//      drawStarMiddle(1) + 중간
//      drawStarTop(9)
// 2 + drawStarTop(3) + 위
//      drawStarTop(1) + 위
//

public class CountingStars {

    static int initInput = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        initInput = input/3;
        System.out.print(drawStarTop(input/3));
        // drawStarBottom(9)
        // drawStarBottom(3) + 아래
        // drawStarBottom(1) + 아래
        // drawStarMiddle(9)
        // 1 + drawStarMiddle(3) + 중간
        //      drawStarMiddle(1) + 중간
        //      drawStarTop(9)
        //      2 + 위 + 위
    }

    public static String drawStarTop(int input) {
        if(input == 0) return "\n"+drawStarMiddle(initInput);
        return "***" + drawStarTop(input - 1);
    }

    public static String drawStarMiddle(int input) {
        if(input == 0) return "\n"+drawStarBottom(initInput);
        return "* *"+ drawStarMiddle(input - 1);
    }

    public static String drawStarBottom(int input) {
        if(input == 0) return "";
        return "***" + drawStarBottom(input - 1);
    }
}
