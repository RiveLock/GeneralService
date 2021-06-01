/**
 * CollectorTest
 * @description
 * @author jixinshi
 * @date 2021/3/30 10:11 AM
 * @version 2.11.2
 */
package com.happy.exercise.steam;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

/**
 * CollectorTest
 * @description
 * @author jixinshi
 */
public class CollectorTest {

    @Test
    public void collect() {
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd", "dd");

//        Map<String, Integer> result = givenList.stream()
//                .collect(toMap(Function.identity(), String::length));

        Map<String, Integer> result = givenList.stream()
                .collect(toMap(Function.identity(), String::length, (item, identicalItem) -> item));

        System.out.println(result);
    }
}
