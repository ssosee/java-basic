package hello.java.javabasic.generics;

import java.util.ArrayList;

/**
 * 숫자만 가능한 제너릭
 * @param <T>
 */
public class MyNumberList<T extends Number> {
    ArrayList<T> list = new ArrayList<>();

    public void addElement(T element) {
        list.add(element);
    }

    public void removeElement(T element) {
        list.remove(element);
    }

    public T get(int index) {
        return list.get(index);
    }

    public String toString() {
        return list.toString();
    }
}
