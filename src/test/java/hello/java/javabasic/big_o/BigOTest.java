package hello.java.javabasic.big_o;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BigOTest {

    @Test
    void addUpToTest() {
        //log.info("result1={}", addUpTo1(1000000000));
        //log.info("result2={}", addUpTo2(1000000000));
        //countUpAndDown(100);
        printAllPairs(100);
    }

    int addUpTo1(int n) {
        long startTime = System.currentTimeMillis();

        int total = 0;
        for (int i = 0; i <= n; i++) {
            total += i;
        }

        long endTime = System.currentTimeMillis();
        log.info("{}ms", endTime - startTime);

        return total;
    }

    int addUpTo2(int n) {
        long startTime = System.currentTimeMillis();
        // 등차수열의 합
        // sum  : 결과
        // a    : 초항
        // n    : 항의 갯수
        // d    : 공차
        // sum = n(2a + (n - 1)d) / 2
        int total = n * (n + 1) / 2;

        long endTime = System.currentTimeMillis();
        log.info("{}ms", endTime - startTime);

        return total;
    }

    void countUpAndDown(int n) {
        long startTime = System.currentTimeMillis();
        log.info("카운트 업 시작!");
        for(int i = 0; i < n; i++) {
            log.info("i={}", i);
        }
        log.info("카운트 다운 시작!");
        for(int j = n-1; j >= 0; j--) {
            log.info("i={}", j);
        }
        long endTime = System.currentTimeMillis();
        log.info("끝!, {}ms", endTime - startTime);
    }

    void printAllPairs(int n) {
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                log.info("i={}, j={}", i, j);
            }
        }
        long endTime = System.currentTimeMillis();
        log.info("끝!, {}ms", endTime - startTime);
    }

    // O(1)
    void quiz(int n) {
        for(int i = 0; i < Math.min(n, 10); i++) {
            log.info("i={}", i);
        }
    }

    Integer sum(List<Integer> arr) {
        Integer total = 0; // 상수 1개
        // i: 상수 1개
        for(int i = 0; i < arr.size(); i++) {
            total += arr.get(i);
        }
        return total;
    }

    List<Double> getDouble(List<Double> arr) {
        List<Double> newArr = new ArrayList<>();
        for(int i = 0; i < arr.size(); i++) {
            newArr.add(2 * arr.get(i));
        }
        return newArr;
    }
}
