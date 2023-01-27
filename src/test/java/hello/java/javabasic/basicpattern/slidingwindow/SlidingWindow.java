package hello.java.javabasic.basicpattern.slidingwindow;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class SlidingWindow {

    @Test
    void test() {
        log.info("result={}", simpleMaxSubarraySum(new int[]{2, 6, 9, 2, 1, 8, 5, 6, 3}, 3));
    }

    // O(N^2)
    int simpleMaxSubarraySum(int[] arr, int num) {
        if(num > arr.length) {
            return 0;
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length - num + 1; i++) {
            int sum = 0;
            for(int j = 0; j < num; j++) {
                sum += arr[i + j];
            }
            if(sum > max) {
                max = sum;
            }
        }
        return max;
    }

    // O(N)
    int maxSubarraySum(int[] arr, int num) {
        int maxSum = 0;
        int tempSum = 0;

        if(arr.length < num) {
            return 0;
        }
        // 첫 시작 위치 배열의 합 계산
        for(int i = 0; i < num; i++) {
            maxSum += arr[i];
        }

        // 교집합 정보 공유를 위함
        tempSum = maxSum;

        // 슬라이딩 윈도우
        for(int i = num; i < arr.length; i++) {
            // 윈도우 크기를 유지하면서
            // 기존 값에서
            // 새롭게 추가된 값은 더하고,
            // 필요없는 값은 뺀다.
            tempSum = tempSum - arr[i - num] + arr[i]; // 양쪽 끝 원소만 갱신
            maxSum = Math.max(maxSum, tempSum); // 최댓값 계산
        }

        return maxSum;
    }
}
