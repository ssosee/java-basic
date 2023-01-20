package hello.java.javabasic.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 제너릭 클래스 선언
 * @param <T>
 */
public class MyGenerics<T> {
    List<T> list = new ArrayList<>();

    public void add(T element) {
        list.add(element);
    }

    public T getElement(int index) {
        return list.get(index);
    }

    public <T> MyGenerics getMyGenerics() {
        return new MyGenerics();
    }
}