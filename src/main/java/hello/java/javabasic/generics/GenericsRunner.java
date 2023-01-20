package hello.java.javabasic.generics;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GenericsRunner {

    static <X> X doubleValue(X value) {
        return value;
    }
    static <X extends List> void duplicate(X value) {
        value.addAll(value);
    }

    /**
     * 상한 경계 와일드 카드
     * @param numbers
     * @return
     */
    static Number sumOfNumberList(List<? extends Number> numbers) {
        double sum = 0.0;
        for(Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }

    /**
     * 하한 경계 와일드 카드
     * @param numbers
     */
    static void addACoupleOfValues(List<? super Number> numbers) {
        numbers.add(1);
        numbers.add(1.0);
        numbers.add(1.0f);
    }

    public static void main(String[] args) {

        String s = doubleValue(new String());
        Integer integer = doubleValue(Integer.valueOf(5));
        ArrayList<Object> objects = doubleValue(new ArrayList<>());

        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 3));
        duplicate(numbers);
        log.info("numbers={}", numbers);

        log.info("int=={}", sumOfNumberList(List.of(1, 2, 3)));
        log.info("float=={}", sumOfNumberList(List.of(1.1f, 2.1f, 3.1f)));
        log.info("long=={}", sumOfNumberList(List.of(1l, 1l, 3l)));
        log.info("double=={}", sumOfNumberList(List.of(1.0d, 2.0d, 3.0d)));

        MyCustomList<String> list = new MyCustomList<>();
        list.addElement("Element 1");
        list.addElement("Element 2");
        log.info(list.get(0));
        String value = list.get(1);

        MyCustomList<Integer> list2 = new MyCustomList<>();
        list2.addElement(Integer.valueOf(5));
        list2.addElement(Integer.valueOf(7));
        Integer number = list2.get(1);
        log.info("number={}", number);

        /**
         * 숫자만 사용 가능한 제너릭 선언
         */
        MyNumberList<Long> list3 = new MyNumberList<>();

    }
}
