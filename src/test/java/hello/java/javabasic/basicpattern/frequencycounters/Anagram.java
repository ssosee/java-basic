package hello.java.javabasic.basicpattern.frequencycounters;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Anagram {

    @Test
    void test() {
        Assertions.assertThat(validAnagram("", "")).isTrue();
        Assertions.assertThat(validAnagram("aaz", "zza")).isFalse();
        Assertions.assertThat(validAnagram("anagram", "nagaram")).isTrue();
        Assertions.assertThat(validAnagram("rat", "car")).isFalse();
        Assertions.assertThat(validAnagram("awesome", "awesom")).isFalse();
        Assertions.assertThat(validAnagram("amanaplanacanalpanama", "acanalmanplanpamana")).isFalse();
        Assertions.assertThat(validAnagram("qwerty", "qeywrt")).isTrue();
        Assertions.assertThat(validAnagram("texttwisttime", "timetwisttext")).isTrue();
        Assertions.assertThat(validAnagram("minkai", "kaimin")).isTrue();
    }

    boolean validAnagram(String arrStr1, String arrStr2) {
        // 소문자로 변경하고 char 배열로 변환
        char[] chars1 = arrStr1.toLowerCase().toCharArray();
        char[] chars2 = arrStr2.toLowerCase().toCharArray();

        // 배열의 길이가 다르면
        if(chars1.length != chars2.length) {
            return false;
        }

        // key: 문자, value: 문자 갯수 로 표현
        Map<Character, Integer> strCounter1 = new HashMap<>();
        Map<Character, Integer> strCounter2 = new HashMap<>();

        for(Character ch : chars1) {
            if(strCounter1.containsKey(ch)) {
                Integer counter = strCounter1.get(ch);
                strCounter1.put(ch, ++counter);
            } else {
                strCounter1.put(ch, 1);
            }
        }

        for(Character ch : chars2) {
            if(strCounter2.containsKey(ch)) {
                Integer counter = strCounter2.get(ch);
                strCounter2.put(ch, ++counter);
            } else {
                strCounter2.put(ch, 1);
            }
        }

        for(Map.Entry<Character, Integer> entry : strCounter1.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            // strCounter2에 strCounter1의 key(문자)가 없으면
            if(!strCounter2.containsKey(key)) {
                return false;
            }
            // strCounter2와 strCounter1의 value가 다르면
            if(!strCounter2.get(key).equals(value)) {
                return false;
            }
        }

        return true;
    }
}
