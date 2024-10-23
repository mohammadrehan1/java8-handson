package com.example.java_8_coding_questions.test;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PracticeTestThird {

    public static void main(String[] args) {

        //seperate odd and even number
        seperateOddAndEven();

        //frequency of eah char in string
        frequencyOfEachCharInString();

        //sort names in reverse order
        sortNamesInReverseOrder();

        //print multiple of five from the list
        printMultpleOfFive();

        //3 max and 3 min numbers from list
        printThreeMaxAndMinFromList();

        //merge two unsorted array
        mergeTwoArrayInSingleSortedArray();

        System.out.println();
        //print List of String in increasing order of their length
        printStringInIncreasingOrderOfLength();

        //sum and average of elements
        findSumAndAverageOfArray();

        //reversed an Integer array
        reverseIntegerArray();

        //check if string is palindrome
        isStringPlaindrome();

        //find last element of an array
        findLastElementOfList();

        //remove duplicate element from list
        removeDuplicateFromList();

        //frequency of each elemnt in List
        frequencyOfEachElementInList();

        //find Longest string in given list
        List<String> stringList = findLongestString();

        //join list of string with prefix,suffix,and delimitter
        joinListWithPrefixSuffixAndDelimitter(stringList);

        //maximum and minimum in given integer list
        findMaxAndMinInGivenList();

        //sum of all digits of number
        sumOfAllDigitOfNumber();


        // find second Largest number in Integer List
        findSecondLargeNumberInList();

        //find common element between two list
        findCommonElements();

        //reverse each word of string
        reverseEachWordOfString();

        //find duplicate element from list
        findDauplicateElements();

        //fibonacci series
        printFiboNacciSeries();

        System.out.println();

        //Anagram program
        //An anagram of a string is another string that contains the same characters,
        // only the order of characters can be different.
        // For example, “abcd” and “dabc” are an anagram of each other.

        String s1 = "abcd";
        String s2 = "dabc";

        String sortedS1 = Arrays.stream(s1.split("")).sorted().collect(Collectors.joining(""));
        String sortedS2 = Arrays.stream(s2.split("")).sorted().collect(Collectors.joining(""));
        String isAnagram = sortedS1.equals(sortedS2) ? "yes" : "no";
        System.out.println(s1 + " and " + s2 + " are anagram? " + isAnagram);

        // find most repeated elements in an array
        printMostRepeatedElementsOfArray();


        //Extract duplicate elements from an array
        List<Integer> duplicateElements = Arrays.asList(1, 2, 2, 2, 3, 3, 4, 5, 1, 1, 56, 7, 8, 9, 10);
        List<Integer> extractDuplicateElement = duplicateElements.stream().filter(el -> duplicateElements.indexOf(el) != duplicateElements.lastIndexOf(el)).distinct().collect(Collectors.toList());
        System.out.println("extractDuplicateElement: " + extractDuplicateElement);

        //Print duplicate characters in a string
        String word = "rohttoh";
        String extractDuplicateCharFromString = Arrays.stream(word.split("")).filter(c -> word.indexOf(c) != word.lastIndexOf(c)).distinct().collect(Collectors.joining(" "));
        System.out.println("extractDuplicateCharFromString: " + extractDuplicateCharFromString);

        //Find the first repeated character in a string
        Arrays.stream(word.split("")).filter(e -> word.indexOf(e) != word.lastIndexOf(e)).findFirst().ifPresent(i -> System.out.println("first repeated char in string is : " + i));


        //Find the first non-repeated character in a string
        Arrays.stream(word.split("")).filter(c -> word.indexOf(c) == word.lastIndexOf(c)).findFirst().ifPresent(i -> System.out.println("first non repeated char in string is: " + i));


        //Print the first 10 odd numbers
        Stream.iterate(1, f -> f + 2).limit(15).forEach(i -> System.out.print(i + " "));

        System.out.println();
        //Get the last element of an array
        int[] intArray = {0, 1, 2, 3, 4, 5};
        Arrays.stream(intArray).boxed().reduce((a, b) -> b).ifPresent(i -> System.out.println("alst element of array is: " + i));

        //Calculate the age of a person in years
        LocalDate dob = LocalDate.of(1992, 11, 06);
        LocalDate currentDate = LocalDate.now();

        int age = Period.between(dob, currentDate).getYears();
        System.out.println("age in years : " + age);

        //get max frequent character in string
        String inputString = "My name is Rehan";
        Arrays.stream(inputString.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
                .stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).ifPresent(i -> System.out.println("most frequent char in string is: " + i));

        //sorts the entries of a Map by keys in the natural order and collects the sorted entries in a LinkedHashMap
        Map<String, Integer> unsortedMap = Map.of("a", 1, "c", 3, "b", 2, "e", 5, "d", 4);

        LinkedHashMap<String, Integer> sortedByKeyInNaturalOrder = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("sortedByKeyInNaturalOrder: " + sortedByKeyInNaturalOrder);

        LinkedHashMap<String, Integer> sortedByKeyInDescOrder = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("sortedByKeyInDescOrder: "+sortedByKeyInDescOrder);


        //reverse integer array with java 8
        int[] a = {1, 2, 2, 2, 3, 3, 4, 5, 1, 1, 56, 7, 8, 9, 10};
        IntStream.range(0, a.length/2).forEach( (i) -> {int t = a[i];
        a[i] = a[a.length-1-i];
        a[a.length-1-i] = t;
        });
        Arrays.stream(a).forEach(i -> System.out.print(i+" "));
        System.out.println();



    }

    private static void printMostRepeatedElementsOfArray() {
        int[] elements = {2, 3, 1, 4, 4, 1, 4, 333, 3, 333, 2, 2, 2, 5, 222};

        Arrays.stream(elements).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).ifPresent(System.out::println);
    }

    private static void printFiboNacciSeries() {
        Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]}).limit(20).map(a -> a[0]).forEach(arr -> System.out.print(arr + " "));
    }

    private static void findDauplicateElements() {
        List<String> stringListt = Arrays.asList("Rehan", "Akash", "Rehan", "Jitendra", "Akash");
        Set<String> set = new HashSet<>();
        List<String> duplElements = stringListt.stream().filter(el -> !set.add(el)).collect(Collectors.toList());
        System.out.println("duplicate Elements: " + duplElements);
    }

    private static void findCommonElements() {
        List<Integer> integerList1 = Arrays.asList(4, 6, 1, 2, 4, 7);
        List<Integer> integerList2 = Arrays.asList(56, 2, 5, 9, 60, 4, 1);
        List<Integer> commonElements = integerList1.stream().filter(integerList2::contains).collect(Collectors.toList());
        System.out.println("commonElements: " + commonElements);
    }

    private static void reverseEachWordOfString() {
        String s = "Rehan is a good man";
        String reverseString = Arrays.stream(s.split(" ")).map(word -> new StringBuffer(word).reverse()).collect(Collectors.joining(" "));
        System.out.println("reverseString: " + reverseString);
    }

    private static void findSecondLargeNumberInList() {
        List<Integer> integerList = Arrays.asList(2, 4, 5, 6, 7, 13, 10, 14, 16, 32);
        integerList.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(i -> System.out.println("second large number in list is: " + i));
    }

    private static void sumOfAllDigitOfNumber() {
        Integer n = 54960;
        String numberInString = n.toString();

        int sumOfAllDigit = Arrays.stream(numberInString.split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println("sumOfAllDigit: " + sumOfAllDigit);
    }

    private static void findMaxAndMinInGivenList() {
        List<Integer> integerList = Arrays.asList(2, 4, 5, 1, 7, 8, 11, 98, 37, 13);
        integerList.stream().min(Comparator.naturalOrder()).ifPresent(i -> System.out.println("min number from list is " + i));

        integerList.stream().max(Comparator.naturalOrder()).ifPresent(i -> System.out.println("max number from list: " + i));
    }

    private static void joinListWithPrefixSuffixAndDelimitter(List<String> stringList) {
        String joinedString = stringList.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.println("joinedString: " + joinedString);
    }

    private static List<String> findLongestString() {
        List<String> stringList = Arrays.asList("Rehan", "Aftaab", "John", "Tom", "Senorita");
        stringList.stream().reduce((a, b) -> a.length() > b.length() ? a : b).ifPresent(a -> System.out.println("longest string in list is: " + a));
        return stringList;
    }

    private static void frequencyOfEachElementInList() {
        List<Integer> integerList = Arrays.asList(2, 4, 5, 6, 7, 8, 9, 10, 1, 3, 4, 4, 6, 2);
        Map<Integer, Long> freqOfEachElement = integerList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("freqOfEachElement: " + freqOfEachElement);
    }

    private static void removeDuplicateFromList() {
        List<Integer> integerList = Arrays.asList(1, 3, 2, 1, 1, 5, 2, 4, 9);
        List<Integer> removedDuplicates = integerList.stream().distinct().collect(Collectors.toList());
        System.out.println("removedDuplicates: " + removedDuplicates);
    }

    private static void findLastElementOfList() {
        List<Integer> integerList = Arrays.asList(2, 4, 6, 2, 8, 45, 3);
        integerList.stream().skip(integerList.size() - 1).findFirst().ifPresent(i -> System.out.println("last element of list is: " + i));
    }

    private static void isStringPlaindrome() {
        // Palindrome number exapmle : 545, 151, 34543, 343, 171, 48984
        //Palindrome String exapmle: "abba", "RACEcar",
        String str = "abba";
        String str1 = "RACEcar";

        boolean isPalindrome = IntStream.range(0, str.length() / 2).boxed().noneMatch(i -> str.charAt(i) != str.charAt(str.length() - 1 - i));
        String check = isPalindrome ? "yes" : "no";
        System.out.println(str + " is palindrome? " + check);
    }

    private static void reverseIntegerArray() {
        int[] firstArray = new int[]{2, 34, 8, 1, 2, 9, 117};
        int[] secondArray = new int[]{5, 1, 3, 0, 1, 4, 14, 10};
        int[] mergedArray = IntStream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).sorted().toArray();
        System.out.println("mergedArray: ");
        Arrays.stream(mergedArray).forEach(i -> System.out.print(i + " "));
        System.out.println();
        List<Integer> reverseInArray = IntStream.range(0, mergedArray.length).boxed().map(i -> mergedArray[mergedArray.length - 1 - i]).collect(Collectors.toList());
        System.out.println("reverseInArray: " + reverseInArray);
    }

    private static void findSumAndAverageOfArray() {
        int[] firstArray = new int[]{2, 34, 8, 1, 2, 9, 117};
        int[] secondArray = new int[]{5, 1, 3, 0, 1, 4, 14, 10};
        int sum = IntStream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).sum();
        double avg = IntStream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).average().getAsDouble();
        System.out.println("sum: " + sum);
        System.out.println("avg: " + avg);
    }

    private static void printStringInIncreasingOrderOfLength() {
        List<String> stringList = Arrays.asList("Rehan", "John", "Monika", "Abraham", "Senorita", "Julie");
        String stringInIncreasingOrderOfLength = stringList.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.joining(" "));
        System.out.println("stringInIncreasingOrderOfLength: " + stringInIncreasingOrderOfLength);
    }

    private static void mergeTwoArrayInSingleSortedArray() {
        int[] firstArray = new int[]{2, 34, 8, 1, 2, 9, 117};
        int[] secondArray = new int[]{5, 1, 3, 0, 1, 4, 14, 10};
        int[] mergedSortedArray = IntStream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).sorted().toArray();
        Arrays.stream(mergedSortedArray).forEach(i -> System.out.print(i + " "));
    }

    private static void printThreeMaxAndMinFromList() {
        List<Integer> numbers = Arrays.asList(2, 6, 1, 8, 16, 33, 7, 53);
        List<Integer> threeMinFromList = numbers.stream().sorted().limit(3).collect(Collectors.toList());
        System.out.println("threeMinFromList: " + threeMinFromList);
        List<Integer> threeMaxFromList = numbers.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
        System.out.println("threeMaxFromList: " + threeMaxFromList);
    }

    private static void printMultpleOfFive() {
        List<Integer> multipleOfFive = IntStream.range(1, 20).boxed().filter(i -> i % 5 == 0).collect(Collectors.toList());
        System.out.println("multipleOfFive: " + multipleOfFive);
    }

    private static void sortNamesInReverseOrder() {
        List<String> names = Arrays.asList("Akash", "Zebra", "Pankaj", "John", "Ponta", "Julie");
        List<String> reversedNames = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("sort names in reverse order: " + reversedNames);
    }

    private static void frequencyOfEachCharInString() {
        String inputString = "My name is Rehan";
        Map<String, Long> freqOfEachCharInString = Arrays.stream(inputString.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("freqOfEachCharInString: " + freqOfEachCharInString);
    }

    private static void seperateOddAndEven() {
        Map<Boolean, List<Integer>> seperateOddAndEven = IntStream.range(1, 15).boxed().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("seperateOddAndEven: " + seperateOddAndEven);
    }
}
