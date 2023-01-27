package hello.java.javabasic.basicpattern.recursion;

import org.junit.jupiter.api.Test;

public class Recursion {

    @Test
    void test() {
        //countDown(5);
        //System.out.println(sumRange(3));
        System.out.println(factorial(100));
    }
    void countDown(int num) {
        if(num <= 0) {
            System.out.println("All Done");
            return;
        }
        System.out.println(num);
        num--;
        countDown(num);
    }
    // num = 3 일때
    // print 3
    // countDown(2)
    // print 2
    // countDown(1)
    // print 1
    // countDown(0)
    // print "All Done"
    // return;

    int sumRange(int num) {
        if(num == 1) {
            return 1;
        }
        return num + sumRange(num - 1);
    }
    // num = 3 일때
    // return 3 + sumRange(2)
    //            return 2 + sumRange(1)
    //                       return 1

//    int factorial(int num) {
//        int total = 1;
//        for(int i = num; i > 0; i--) {
//            total *= i;
//        }
//        return total;
//    }

    int factorial(int num) {
        if(num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }
    // num = 3 일때
    // return 3 * factorial(2)
    //            return 2 * factorial(1)
    //                       return 1
}
