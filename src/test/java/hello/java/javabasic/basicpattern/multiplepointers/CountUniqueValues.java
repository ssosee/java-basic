package hello.java.javabasic.basicpattern.multiplepointers;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class CountUniqueValues {

    @Test
    void test() {
        Assertions.assertThat(countUniqueValues(new int[]{1, 1, 1, 2})).isEqualTo(2);
        Assertions.assertThat(countUniqueValues(new int[]{1, 2, 2, 4, 4, 4, 5, 6})).isEqualTo(5);
        Assertions.assertThat(countUniqueValues(new int[]{})).isEqualTo(0);
        Assertions.assertThat(countUniqueValues(new int[]{-1, 0, 0, 1})).isEqualTo(3);

        Assertions.assertThat(countUniqueValuesBySet(new int[]{1, 1, 1, 2})).isEqualTo(2);
        Assertions.assertThat(countUniqueValuesBySet(new int[]{1, 2, 2, 4, 4, 4, 5, 6})).isEqualTo(5);
        Assertions.assertThat(countUniqueValuesBySet(new int[]{})).isEqualTo(0);
        Assertions.assertThat(countUniqueValuesBySet(new int[]{-1, 0, 0, 1})).isEqualTo(3);
    }

    int countUniqueValues(int[] arr) {
        int i = 0;
        for(int j = 1; j < arr.length; j++) {
            if(arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }

        if(arr.length == 0) return 0;

        return i+1;
    }

    int countUniqueValuesBySet(int[] arr) {
        Set<Integer> set = new HashSet<>();
        // O(N)
        for(int i = 0; i < arr.length; i++) {
            set.add(arr[i]); // O(1)
        }

        return set.size();
    }
}
