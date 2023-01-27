package hello.java.javabasic.basicpattern.multiplepointers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
public class MultiplePointers {

    @Test
    void test() {
        //simpleSumZero(List.of(-3, -2, -1, 0, 1, 2, 3));
        sumZero(List.of(-3, -2, -1, 0, 1, 2, 4));
    }

    void simpleSumZero(List<Integer> arr) {
        for(int i = 0; i < arr.size(); i++) {
            for(int j = i+1; j < arr.size(); j++) {
                if(arr.get(i) + arr.get(j) == 0) {
                    log.info("[{}, {}]", arr.get(i), arr.get(j));
                    return;
                }
            }
        }
    }

    void sumZero(List<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1; // 배열의 마지막 위치
        while (left < right) {
            int sum = arr.get(left) + arr.get(right);
            if(sum == 0) {
                log.info("[{}, {}]", arr.get(left), arr.get(right));
                return;
            } else if(sum > 0) {
                //sum > 0 이면 arr.get(right)가 더 크다는 의미
                //현재 arr는 오름차순으로 정렬되었기 때문
                right--;
            } else {
                left++;
            }
        }
    }
}
