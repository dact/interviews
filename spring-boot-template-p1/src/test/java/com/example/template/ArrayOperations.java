package com.example.template;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayOperations {

    public static final int LIMIT_LENGTH_ARRAY = 1000;
    public static final int LIMIT_ELEMENT_ARRAY = 1000;

    public ArrayOperations(){

    }

    public Integer[] intersection(int[] nums1, int[] nums2) {

        checkConstraints(nums1);
        checkConstraints(nums2);

        Set set1 = new HashSet<>();
        Set set2 = new HashSet<>();

        Arrays.stream(nums1).forEach(n -> set1.add(n));
        Arrays.stream(nums2).forEach(n -> set2.add(n));

        Set result = new HashSet(set1);
        result.retainAll(set2);

        Integer[] array = (Integer[]) result.stream().toArray(Integer[]::new);
        return array;
    }

    public List<Integer> intersectionV2(Integer[] nums1, Integer[] nums2) {

        checkConstraints2(nums1);
        checkConstraints2(nums2);

        Set<Integer> set1 = Set.of(nums1);
        //Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(nums2));
        //Set<Integer> targetSet2 = new HashSet<Integer>(Arrays.stream(array).boxed().collect(Collectors.toList()));
        Set<Integer> set2 = Set.of(nums2);

        Set result = new HashSet(set1);
        result.retainAll(set2);

        return (List<Integer>) result.stream().collect(Collectors.toList());
    }

    /*
     */
    private void checkConstraints(int[] nums1) {
        if (nums1.length> LIMIT_LENGTH_ARRAY) throw new ArrayOperationsException("Exception Limit for array");
        Arrays.stream(nums1).forEach(n->{
            if(n> LIMIT_ELEMENT_ARRAY)throw new ArrayOperationsException("Exception Limit for array element");
        });
    }

    private void checkConstraints2(Integer[] nums1) {
        if (nums1.length> LIMIT_LENGTH_ARRAY) throw new ArrayOperationsException("Exception Limit for array");
        Arrays.stream(nums1).forEach(n->{
            if(n> LIMIT_ELEMENT_ARRAY)throw new ArrayOperationsException("Exception Limit for array element");
        });
    }

}
