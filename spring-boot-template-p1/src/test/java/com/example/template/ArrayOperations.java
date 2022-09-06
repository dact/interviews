package com.example.template;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayOperations {

    public static final int LIMIT_LENGTH_ARRAY = 1000;
    public static final int LIMIT_ELEMENT_ARRAY = 1000;

    public ArrayOperations(){

    }
    public List<Integer> intersection(Integer[] arrayNumbers1, Integer[] arrayNumbers2) {

        checkConstraints(arrayNumbers1);
        checkConstraints(arrayNumbers2);

        Set<Integer> setNumbers1 = Set.of(arrayNumbers1);
        Set<Integer> setNumbers2 = Set.of(arrayNumbers2);

        Set setIntersectionResult = new HashSet(setNumbers1);
        setIntersectionResult.retainAll(setNumbers2);

        return (List<Integer>) setIntersectionResult.stream().collect(Collectors.toList());
    }

    /*
     */
    private void checkConstraints(Integer[] arrayNumbers) {
        if (arrayNumbers.length > LIMIT_LENGTH_ARRAY) throw new ArrayOperationsException("Exception Limit for array");
        Arrays.stream(arrayNumbers).forEach(n -> {
            if(n > LIMIT_ELEMENT_ARRAY)throw new ArrayOperationsException("Exception Limit for array element");
        });
    }

}
