package hello.java.javabasic.generics;

import java.util.List;

public class MyGenerics2 {
    /**
     * 제너릭 메소드 선언
     * @param age
     * @return
     * @param <T>
     */
    public <T> T getAge(T age) {
        return age;
    }

    /**
     * 1. <T> 제너릭 타입
     * 2. T 리턴 타입
     * 3. T 파라미터 타입
     */
    public static <T> T 메소드명(T name) {
        return name;
    }
}
