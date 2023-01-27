package hello.java.javabasic.basicpattern.recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HelperMethodRecursion {

    @Test
    void test() {
        //System.out.println(collectOddValues(new int[]{1, 2, 3, 4, 5}));
        System.out.println(collectOddValuesPureRecursion(new int[]{1, 2, 3}));
    }

    List<Integer> collectOddValues(int[] arr) {
        List<Integer> result = new ArrayList<>();
        helper(arr, result);

        return result;
    }

    List<Integer> helper(int[] helperInput, List<Integer> result) {

        if(helperInput.length == 0) {
            return result;
        }
        if(helperInput[0] % 2 != 0) {
            result.add(helperInput[0]);
        }

        int[] sliceArray = Arrays.copyOfRange(helperInput, 1, helperInput.length);
        return helper(sliceArray, result);
    }

    List<Integer> collectOddValuesPureRecursion(int[] arr) {
        List<Integer> result = new ArrayList<>();

        if(arr.length == 0) {
            return result;
        }

        if(arr[0] % 2 != 0) {
            result.add(arr[0]);
        }
        int[] sliceArray = Arrays.copyOfRange(arr, 1, arr.length);
        result.addAll(collectOddValuesPureRecursion(sliceArray));

        return result;
    }
    // collectOddValuesPureRecursion([1, 2, 3])
    // result=[1], [1].addAll(collectOddValuesPureRecursion([2, 3]))
    //               result = [], [].addAll(collectOddValuesPureRecursion([3]))
    //                            result = [3], [3].addAll(collectOddValuesPureRecursion([]))
}
