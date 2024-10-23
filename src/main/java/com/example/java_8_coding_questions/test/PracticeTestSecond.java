package com.example.java_8_coding_questions.test;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PracticeTestSecond {

    public static void main(String[] args) {

        //seperateOddAndEvenNumbers
        Map<Boolean, List<Integer>> seperateOddEven = IntStream.range(1, 15).boxed().collect(Collectors.partitioningBy(i -> i % 2 == 0));

        System.out.println("seperateOddEven: " + seperateOddEven);

        //frequency of each character in string
        frequencyOfEachCharInString();

        //sort list of names in reverse order
        List<String> names = Arrays.asList("Akash", "Zebra", "Pankaj", "John", "Ponta", "Julie");
        List<String> reversedList = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("reversedList: " + reversedList);

        //print multiple of five from the list
        List<Integer> multpleofFive = IntStream.range(1, 35).boxed().filter(i -> i % 5 == 0).collect(Collectors.toList());
        System.out.println("multpleofFive: " + multpleofFive);

        //3 max and 3 min numbers from list
        printThreeMinAndMaxFromList();

        //merge two unsorted array into single sorted array
        int[] firstArray = new int[]{2, 34, 8, 1, 2, 9, 117};
        int[] secondArray = new int[]{5, 1, 3, 0, 1, 4, 14, 10};

        int[] singleSortedArray = IntStream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).sorted().toArray();
        Arrays.stream(singleSortedArray).forEach(i -> System.out.print(i + " "));

        System.out.println();
        //print List of String in increasing order of their length
        printListOfStringInIncreasingOrderOfTheirLength();

        //
        //reversed an Integer array
        reverseIntegerArray();

        // //check if string is palindrome
        String s = "aka";
        boolean isPalindrome = IntStream.range(0, s.length() / 2).noneMatch(i -> s.charAt(i) != s.charAt(s.length() - 1 - i));
        System.out.println(s + " is palindrome: " + (isPalindrome ? "yes" : "no"));

        //find last element of an array
        findLastElementOfList(multpleofFive);

        // //find Longest string in given list
        findLongestStringInList(names);

        //join list of string with prefix,suffix,and delimitter
        String joinedString = names.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.println("joinedString: " + joinedString);

        //maximum and minimum in given integer list
        printMaxAndMinFromList(multpleofFive);

        //sum of all digits of number
        sumOfAllDigitOfNumber();

        // find second Largest number in Integer List
        findSecondLargeNumberInList();

        //find common element between two list
        findCommonElementBetweenTwoList();

        //reverse each word of string
        reverseEachWordOfStringList();

        //find strings which start with number
        stringWhichStartWithNumber();

        ////find duplicate element from list
        findDuplicateFromStringList();

        //fibonacci series
        printFibonacciSeries();

        //Anagram program
        isStringsAnagram();

        // find most repeated elements in an array
        mostRepeatedElementInList();

        //Extract duplicate elements from an array
        extractDuplicateElementsFromList();

        //Print duplicate characters in a string
        printDuplicateCharFromString();

        //Find the first repeated character in a string
        findFirstRepeatedCharInString();


        //Find the first non-repeated character in a string
        findFirstNonRepeatedCharInString();

        //Print the first 10 odd numbers
        printFirstTenOddNumber();

        System.out.println();
        //Get the last element of an array
        lastElementOfArray();

        System.out.println();

        //Calculate the age of a person in years
        personAgeInYears();

        //sorts the entries of a Map by keys in the natural order and collects the sorted entries in a LinkedHashMap
        sortsMapEntriesByKeyInNaturalOrder();

        //sorts map in desc order
        Map<String, Integer> unsortedMap = Map.of("a", 1, "c", 3, "b", 2, "e", 5, "d", 4);
        LinkedHashMap<String, Integer> sortMapByKeyInDescOrder = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("sortMapByKeyInDescOrder: " + sortMapByKeyInDescOrder);

        //reverse integer array
        reverseIntegerArrayWithJava8();


    }

    private static void reverseIntegerArrayWithJava8() {
        int[] a = {1, 2, 2, 2, 3, 3, 4, 5, 1, 1, 56, 7, 8, 9, 10};

       /* for (int i =0; i<a.length/2; i++){
            int t = a[i];
            a[i] = a[a.length-1-i];
            a[a.length-1-i] = t;
        }*/

        IntStream.range(0, a.length / 2).boxed().forEach((i) -> {
            int t = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = t;
        });
        Arrays.stream(a).forEach(i -> System.out.print(i + " "));
    }

    private static void sortsMapEntriesByKeyInNaturalOrder() {
        Map<String, Integer> unsortedMap = Map.of("a", 1, "c", 3, "b", 2, "e", 5, "d", 4);
        LinkedHashMap<String, Integer> sortMapByKey = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("sortMapByKey: " + sortMapByKey);

        //key with max value
        unsortedMap.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).ifPresent(System.out::println);
    }

    private static void personAgeInYears() {
        LocalDate dob = LocalDate.of(1992, 11, 06);
        LocalDate cuurentDate = LocalDate.now();

        int ageInYears = Period.between(dob, cuurentDate).getYears();
        System.out.println("Person age in years is: " + ageInYears);
    }

    private static void lastElementOfArray() {
        int[] intArray = {0, 1, 2, 3, 4, 5};
        Arrays.stream(intArray).reduce((a, b) -> b).ifPresent(System.out::print);
    }

    private static void printFirstTenOddNumber() {
        Stream.iterate(1, n -> n + 2).limit(10).forEach(i -> System.out.print(i + " "));
    }

    private static void findFirstNonRepeatedCharInString() {
        String word = "rohttoh";
        Arrays.stream(word.split("")).filter(c -> word.indexOf(c) == word.lastIndexOf(c)).findFirst().ifPresent(ch -> System.out.println("first non repeated char in string is: " + ch));
    }

    private static void findFirstRepeatedCharInString() {
        String word = "rohttoh";
        Arrays.stream(word.split("")).filter(c -> word.indexOf(c) != word.lastIndexOf(c)).findFirst().ifPresent(sr -> System.out.print("first repeated char in string is: " + sr));
    }

    private static void printDuplicateCharFromString() {
        String word = "rohttoh";
        List<Character> duplicateChar = Arrays.stream(word.split("")).filter(c -> word.indexOf(c) != word.lastIndexOf(c)).map(ch -> ch.charAt(0)).distinct().collect(Collectors.toList());
        System.out.println("duplicateChar: " + duplicateChar);
    }

    private static void extractDuplicateElementsFromList() {
        List<Integer> duplicateElements = Arrays.asList(1, 2, 2, 2, 3, 3, 4, 5, 1, 1, 56, 7, 8, 9, 10);
        List<Integer> extractedDuplicates = duplicateElements.stream().filter(el -> duplicateElements.indexOf(el) != duplicateElements.lastIndexOf(el)).distinct().collect(Collectors.toList());
        System.out.println("extractedDuplicates: " + extractedDuplicates);
    }

    private static void mostRepeatedElementInList() {
        int[] elements = {2, 3, 1, 4, 4, 1, 4, 333, 3, 333, 2, 2, 2, 5, 222};
        Map<Integer, Long> countByElement = Arrays.stream(elements).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        countByElement.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).ifPresent(i -> System.out.println("most repeated element in list is: " + i));
    }

    private static void isStringsAnagram() {
        String str = "abcd";
        String str1 = "dabc";

        String sortStr = Arrays.stream(str.split("")).sorted().collect(Collectors.joining(""));
        String sortStr1 = Arrays.stream(str1.split("")).sorted().collect(Collectors.joining(""));

        System.out.println("Given string :" + str + " and " + str1 + " are Anagram: " + (sortStr.equals(sortStr1) ? "Yes" : "No"));
    }

    private static void printFibonacciSeries() {
        List<Integer> fibonacciSeries = Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]}).limit(12).map(ar -> ar[0]).collect(Collectors.toList());
        System.out.println("fibonacciSeries: " + fibonacciSeries);
    }

    private static void findDuplicateFromStringList() {
        Set<String> set = new HashSet<>();
        List<String> stringList = Arrays.asList("Rehan", "Akash", "Rehan", "Jitendra", "Akash");

        Set<String> duplicateStringFromList = stringList.stream().filter(el -> !set.add(el)).collect(Collectors.toSet());
        System.out.println("duplicateStringFromList: " + duplicateStringFromList);
    }

    private static void stringWhichStartWithNumber() {
        List<String> stringList = Arrays.asList("Rehan", "Varun", "9Vistara", "2Kajol");
        List<String> stringStartWithNumber = stringList.stream().filter(str -> Character.isDigit(str.charAt(0))).collect(Collectors.toList());
        System.out.println("stringStartWithNumber: " + stringStartWithNumber);
    }

    private static void reverseEachWordOfStringList() {
        String sss = "Rehan is a good man";
        String reversedStrings = Arrays.stream(sss.split(" ")).map(word -> new StringBuffer(word).reverse()).collect(Collectors.joining(" "));
        System.out.println("reversedStrings: " + reversedStrings);
    }

    private static void findCommonElementBetweenTwoList() {
        List<Integer> inList = Arrays.asList(2, 34, 8, 1, 2, 9, 117);
        List<Integer> commonElementBetweenList = Arrays.asList(4, 8, 6, 7, 12, 68).stream().filter(inList::contains).collect(Collectors.toList());
        System.out.println("commonElementBetweenList: " + commonElementBetweenList);
    }

    private static void findSecondLargeNumberInList() {
        List<Integer> inList = Arrays.asList(2, 34, 8, 1, 2, 9, 117);
        inList.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(i -> System.out.println("second large number in list is: " + i));
    }

    private static void sumOfAllDigitOfNumber() {
        int n = 53478;
        String ns = String.valueOf(n);
        int sum = Arrays.stream(ns.split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println("sum of all digit of number " + n + " is: " + sum);
    }

    private static void printMaxAndMinFromList(List<Integer> multpleofFive) {
        Integer maxNumberInList = multpleofFive.stream().max(Comparator.naturalOrder()).get();
        System.out.println("maxNumberInList: " + maxNumberInList);
        multpleofFive.stream().min(Comparator.naturalOrder()).ifPresent(i -> System.out.println("min number from list: " + i));
    }

    private static void findLongestStringInList(List<String> names) {
        names.stream().reduce((a, b) -> a.length() > b.length() ? a : b).ifPresent(ss -> System.out.println("longest string in list: " + ss));
    }

    private static void findLastElementOfList(List<Integer> multpleofFive) {
        int lastElement = multpleofFive.stream().skip(multpleofFive.size() - 1).findFirst().get();
        System.out.println("List is :" + multpleofFive);
        System.out.println("last elemenet of list is : " + lastElement);
    }

    private static void reverseIntegerArray() {
        int[] a = {23, 78, 12, 1, 5, 34, 9};
        int[] array = IntStream.range(0, a.length).boxed().mapToInt(i -> a[a.length - 1 - i]).toArray();
        Arrays.stream(array).forEach(i -> System.out.print(i + " "));
    }

    private static void printListOfStringInIncreasingOrderOfTheirLength() {
        List<String> stringList = Arrays.asList("Rehan", "John", "Monika", "Abraham", "Senorita", "Julie");
        stringList.stream().sorted(Comparator.comparing(String::length)).forEach(s -> System.out.print(s + " "));
    }

    private static void printThreeMinAndMaxFromList() {
        List<Integer> intList = Arrays.asList(3, 56, 12, 34, 89, 11, 7, 2, 29);
        List<Integer> threeMinNumber = intList.stream().sorted().limit(3).collect(Collectors.toList());
        System.out.println("threeMinNumber: " + threeMinNumber);

        List<Integer> threeMaxNumber = intList.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
        System.out.println("threeMaxNumber: " + threeMaxNumber);
    }

    private static void frequencyOfEachCharInString() {
        String inputString = "My name is Rehan";
        Map<String, Long> freqOfEachChar = Arrays.stream(inputString.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("freqOfEachChar: " + freqOfEachChar);
    }
}
