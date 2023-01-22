package hello.java.javabasic.basicpattern.frequencycounters;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

@Slf4j
public class FrequencyCounters {

    @Test
    void test() {
        List<Double> arr1 = new ArrayList<>() {{
            add(1d);
            add(2d);
            add(3d);
            add(5d);
            add(5d);
        }};
        List<Double> arr2 = new ArrayList<>() {{
            add(25d);
            add(1d);
            add(9d);
            add(4d);
            add(25d);
        }};
//        boolean result1 = simpleFrequencyCounters(arr1, arr2);
//        log.info("result1={}", result1);
        boolean result2 = frequencyCounters(arr1, arr2);
        log.info("result2={}", result2);
    }


    /**
     * 첫 번째 배열에 값의 제곱값이 두 번째 배열에 포함되어 있으면 참을 반환하는 함수를 작성하세요.
     * 첫 번째 배열의 값의 제곱값이 두 번째 배열에 중복으로 존재하면 거짓 입니다.
     * (두 번째 배열의 순서는 상관 없습니다.)
     *
     * 예시
     * A[1, 2, 3], B[1, 4, 9] -> true
     * A[1, 2, 3], B[4, 9, 1] -> true (순서는 상관 없습니다.)
     * A[1, 2, 3], B[1, 9] -> false (4가 없어서 거짓)
     * A[1, 2, 1], B[1, 1, 4] -> true
     * A[1, 2, 1], B[4, 1, 4] -> false (빈도가 다르기 때문에 거짓, 4대신 1이 있어야 참)
     */

    // O(N^2)
    boolean simpleFrequencyCounters(List<Double> arr1, List<Double> arr2) {
        // arr1과 arr2의 크기가 다르면 거짓
        if(arr1.size() != arr2.size()) {
            return false;
        }
        for(int i = 0; i < arr1.size(); i++) { // O(N)
            // indexOf(): 처음 발견되는 인덱스 반환, 찾지 못하면 -1 반환
            int value = arr2.indexOf(Math.pow(arr1.get(i), 2));
            // 찾지 못하면 false
            if(value == -1) {
                return false;
            }
            // 찾으면 해당 값 삭제
            arr2.remove(value); // O(N)
        }
        return true;
    }

    boolean frequencyCounters(List<Double> arr1, List<Double> arr2) {
        // arr1과 arr2의 크기가 다르면 거짓
        if(arr1.size() != arr2.size()) {
            return false;
        }

        // key: 배열 값, value: 갯수
        Map<Double, Integer> frequencyCounters1 = new HashMap<>();
        Map<Double, Integer> frequencyCounters2 = new HashMap<>();

        //O(N)
        for(Double num : arr1) {
            if(frequencyCounters1.containsKey(num)) {
                Integer count = frequencyCounters1.get(num);
                frequencyCounters1.put(num, ++count);
            } else {
                frequencyCounters1.put(num, 1);
            }
        }
        //O(N)
        for(Double num : arr2) {
            if(frequencyCounters2.containsKey(num)) {
                Integer count = frequencyCounters2.get(num);
                frequencyCounters2.put(num, ++count);
            } else {
                frequencyCounters2.put(num, 1);
            }
        }

        /**
         * arr1[1, 2, 3], arr2[4, 1, 4] 일때
         * frequencyCounters1[1:1, 2:1, 3:1]
         * frequencyCounters2[4:2, 1:1]
         */
        //O(N)
        for (Map.Entry<Double, Integer> doubleIntegerEntry : frequencyCounters1.entrySet()) {
            Double key = doubleIntegerEntry.getKey();
            double powKey = Math.pow(key, 2);
            //O(1)
            if(!frequencyCounters2.containsKey(powKey)) {
                return false;
            }
            //O(1)
            if(!frequencyCounters2.get(powKey).equals(frequencyCounters1.get(key))) {
                return false;
            }
        }

        return true;
    }
}
