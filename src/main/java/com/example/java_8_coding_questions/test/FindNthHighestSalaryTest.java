package com.example.java_8_coding_questions.test;

import java.util.*;
import java.util.stream.Collectors;

public class FindNthHighestSalaryTest {

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("anil", 1000);
        map1.put("bhavna", 1300);
        map1.put("micael", 1500);
        map1.put("tom", 1600);//output
        map1.put("ankit", 1200);
        map1.put("daniel", 1700);
        map1.put("james", 1400);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("anil", 1000);
        map2.put("ankit", 1200);
        map2.put("bhavna", 1200);
        map2.put("james", 1200);
        map2.put("micael", 1000);
        map2.put("tom", 1300);
        map2.put("daniel", 1300);


        //first approach
        // this is not proper way to get Nth Highest salary
        Map.Entry<String, Integer> nthHighestSalary = getNthHighestSalary(2, map1);

        System.out.println(nthHighestSalary);

        //second approach : best way
        Map<Integer, List<Map.Entry<String, Integer>>> integerListMap = map2.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue));
        //here it will print key with entryset as value but we want to value as a name only
        System.out.println(integerListMap);

        //here it will map values with name only
        /*Map<Integer, List<String>> listMap = map2.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())));*/

        //this is best approach to get Nth highest Salary
        nthHighestSalaryFeasibleApproach(map2, 3);

    }

    private static void nthHighestSalaryFeasibleApproach(Map<String, Integer> map2, int num) {
        Map.Entry<Integer, List<String>> nthHighestSalaryMap = map2.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList())
                .get(num - 1);
        //System.out.println(listMap);
        System.out.println(nthHighestSalaryMap);
    }

    public static Map.Entry<String, Integer> getNthHighestSalary(int num, Map<String, Integer> map1) {
        return map1.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList())
                .get(num - 1);
    }

}
