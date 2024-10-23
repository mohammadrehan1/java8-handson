package com.example.java_8_coding_questions.test;

import com.example.java_8_coding_questions.model.BlogPost;
import com.example.java_8_coding_questions.model.BlogPostType;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PracticeTestInitial {

    public static void main(String[] args) {

        //seperateOddAndEvenNumbers
        seperateOddAndEvenNumbers();


        //frequencyOfEachCharacterInString
        frequencyOfEachCharacterInString();


        List<BlogPost> blogPostsList = getBlogPostsList();

        //get max from each group result
        getMaxFromGroup(blogPostsList);

        //sort list of names in reverse order
        List<String> names = Arrays.asList("Akash", "Zebra", "Pankaj", "John", "Ponta", "Julie");
        List<String> reversedNames = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("reversedNames: " + reversedNames);

        //print multiple of five from the list
        List<Integer> multipleOfFive = IntStream.range(1, 20).boxed().filter(i -> i % 5 == 0).collect(Collectors.toList());
        System.out.println("multipleOfFive: " + multipleOfFive);

        //3 max and 3 min numbers from list
        List<Integer> numbers = Arrays.asList(2, 6, 1, 8, 16, 33, 7, 53);
        List<Integer> threeMaxFromList = numbers.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
        System.out.println("threeMaxFromList: " + threeMaxFromList);

        List<Integer> threeMinNumberFromList = numbers.stream().sorted().limit(3).collect(Collectors.toList());
        System.out.println("threeMinNumberFromList: " + threeMinNumberFromList);

        //merge two unsorted arrays into single sorted array
        int[] firstArray = new int[]{2, 34, 8, 1, 2, 9, 117};
        int[] secondArray = new int[]{5, 1, 3, 0, 1, 4, 14, 10};
        int[] mergedSortedArray = IntStream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).sorted().toArray();
        Arrays.stream(mergedSortedArray).forEach(i -> System.out.print(i + " "));

        System.out.println();
        int[] sortedMergeArrayWithoutDuplicate = IntStream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).sorted().distinct().toArray();
        Arrays.stream(sortedMergeArrayWithoutDuplicate).forEach(i -> System.out.print(i + " "));

        System.out.println();
        //print List of String in increasing order of their length
        List<String> stringList = Arrays.asList("Rehan", "John", "Monika", "Abraham", "Senorita", "Julie");
        String stringInIncreasingOrderOfTheirLength = stringList.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.joining(" "));
        System.out.println("List of String in increasing order of their length: " + stringInIncreasingOrderOfTheirLength);

        //reversed an Integer array
        // IntStream.range(0, sortedMergeArrayWithoutDuplicate.length).boxed().map(i -> sortedMergeArrayWithoutDuplicate[sortedMergeArrayWithoutDuplicate.length-1-i]).forEach(i -> System.out.print(i+" "));

        IntStream.range(0, sortedMergeArrayWithoutDuplicate.length / 2).boxed().forEach((i) -> {
            int t = sortedMergeArrayWithoutDuplicate[i];
            sortedMergeArrayWithoutDuplicate[i] = sortedMergeArrayWithoutDuplicate[sortedMergeArrayWithoutDuplicate.length - 1 - i];
            sortedMergeArrayWithoutDuplicate[sortedMergeArrayWithoutDuplicate.length - 1 - i] = t;

        });
        Arrays.stream(sortedMergeArrayWithoutDuplicate).forEach(i -> System.out.print(i + " "));

        System.out.println();

        //check if string is palindrome
        // Palindrome number exapmle : 545, 151, 34543, 343, 171, 48984
        //Palindrome String exapmle: "abba", "RACEcar",
        isStringPalindrome();

        //find last element of an array
        List<Integer> integerList = Arrays.asList(2, 4, 6, 2, 8, 45, 3);
        integerList.stream().reduce((a, b) -> b).ifPresent(i -> System.out.println("last Element is : " + i));

        integerList.stream().skip(integerList.size() - 1).findFirst().ifPresent(i -> System.out.println("last Element is : " + i));

        //frequency of each elemnt in List
        List<Integer> integerrList = Arrays.asList(2, 4, 5, 6, 7, 8, 9, 10, 1, 3, 4, 4, 6, 2);
        Map<Integer, Long> freqOfEachElement = integerrList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("frequency of each elemnt in List: " + freqOfEachElement);

        //find Longest string in given list
        List<String> stringgList = Arrays.asList("Rehan", "Aftaab", "John", "Tom", "Senorita");
        stringgList.stream().reduce((a, b) -> a.length() > b.length() ? a : b).ifPresent(ss -> System.out.println("longest string in list is: " + ss));

        //maximum and minimum in given integer list
        findMaxAndMinFromList(integerrList);

        //sum of all digits of number
        sumOfAllDigits();

        // find second Largest number in Integer List
        numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(i -> System.out.println("second large number in list is: " + i));

        //find common element between two list
        List<Integer> integerList1 = Arrays.asList(4, 6, 1, 2, 4, 7);
        List<Integer> integerList2 = Arrays.asList(56, 2, 5, 9, 60, 4, 1);

        List<Integer> commonElements = integerList1.stream().filter(integerList2::contains).distinct().collect(Collectors.toList());
        System.out.println("commonElements: " + commonElements);

        //reverse each word of string
        String s = "My name is Rehan";
        String reversedEachWord = Arrays.stream(s.split(" ")).map(word -> new StringBuffer(word).reverse()).collect(Collectors.joining(" "));
        System.out.println("reversedEachWord: " + reversedEachWord);

        //find strings which start with number
        List<String> strringList = Arrays.asList("Rehan", "Varun", "9Vistara", "2Kajol");
        String stringStartWithNumber = strringList.stream().filter(st -> Character.isDigit(st.charAt(0))).collect(Collectors.joining(" "));
        System.out.println("stringStartWithNumber: " + stringStartWithNumber);

        //find duplicate element from list
        List<String> striingList = Arrays.asList("Rehan", "Akash", "Rehan", "Jitendra", "Akash");

        Set<String> set = new HashSet<>();

        List<String> duplicatesElements = striingList.stream().filter(el -> !set.add(el)).collect(Collectors.toList());
        System.out.println("duplicatesElements: " + duplicatesElements);

        //fibonacci series
        Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]}).limit(10).map(ar -> ar[0]).forEach(i -> System.out.print(i + " "));

        System.out.println();
        //Anagram program
        //An anagram of a string is another string that contains the same characters,
        // only the order of characters can be different.
        // For example, “abcd” and “dabc” are an anagram of each other.

        isStringsAnagram();

        // find most repeated elements in an array
        findMostRepeatedElementInArray();

        //Extract duplicate elements from an array
        List<Integer> duplicateElements = Arrays.asList(1, 2, 2, 2, 3, 3, 4, 5, 1, 1, 56, 7, 8, 9, 10);
        List<Integer> extractDuplicateElements = duplicateElements.stream().filter(e -> duplicateElements.indexOf(e) != duplicateElements.lastIndexOf(e)).distinct().collect(Collectors.toList());
        System.out.println("extractDuplicateElements: " + extractDuplicateElements);

        //Print duplicate characters in a string
        String word = "rohttoh";
        System.out.println("original String " + word);

        String extractDuplicateCharFromWord = Arrays.stream(word.split("")).filter(c -> word.indexOf(c) != word.lastIndexOf(c)).distinct().collect(Collectors.joining(" "));
        System.out.println("extractDuplicateCharFromWord: " + extractDuplicateCharFromWord);

        //Find the first repeated character in a string
        Arrays.stream(word.split("")).filter(c -> word.indexOf(c) != word.lastIndexOf(c)).findFirst().ifPresent(i -> System.out.print("first repeated char in string is : " + i));

        System.out.println();
        //Find the first non-repeated character in a string
        Arrays.stream(word.split("")).filter(c -> word.indexOf(c) == word.lastIndexOf(c)).findFirst().ifPresent(i -> System.out.print("first non repeated char in string is: " + i));

        System.out.println();
        //Print the first 10 odd numbers
        Stream.iterate(1, f -> f + 2).limit(10).forEach(i -> System.out.print(i + " "));

        //Get the last element of an array
        int[] intArray = {0, 1, 2, 3, 4, 5};
        Arrays.stream(intArray).reduce((a, b) -> b).ifPresent(i -> System.out.println("last element of array is : " + i));

        //Calculate the age of a person in years
        LocalDate dob = LocalDate.of(1992, 11, 06);
        LocalDate current = LocalDate.now();
        int age = Period.between(dob, current).getYears();
        System.out.println("age is: " + age);

        //get max frequent character in string
        String inputString = "My name is Rehan";
        Arrays.stream(inputString.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).ifPresent(i -> System.out.println("most frequent char in string is :" + i));


        //sorts the entries of a Map by keys in the natural order and collects the sorted entries in a LinkedHashMap
        Map<String, Integer> unsortedMap = Map.of("a", 1, "c", 3, "b", 2, "e", 5, "d", 4);

        LinkedHashMap<String, Integer> sortedMapUsingKey = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("sortedMapUsingKey: " + sortedMapUsingKey);

        printStringWithoutDuplicate();

    }

    private static void printStringWithoutDuplicate() {
        String con="india";
        Map<Character, Integer> map = new HashMap<>();

        String result ="";

        for(int i=0; i<con.length();i++){
            if(!map.containsKey(con.charAt(i))){
                result+=con.charAt(i);
                map.put(con.charAt(i), 1);
            }
        }

        System.out.println("String without duplicate is : "+result);
    }

    private static void findMostRepeatedElementInArray() {
        int[] elements = {2, 3, 1, 4, 4, 1, 4, 333, 3, 333, 2, 2, 2, 5, 222};
        Arrays.stream(elements).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).ifPresent(i -> System.out.println("most repeated element in array is: " + i));
    }

    private static void isStringsAnagram() {
        String s1 = "abcd";
        String s2 = "dabc";

        String sortedS1 = Arrays.stream(s1.split("")).sorted().collect(Collectors.joining(" "));

        String sortedS2 = Arrays.stream(s2.split("")).sorted().collect(Collectors.joining(" "));

        String isAnagram = sortedS1.equals(sortedS2) ? "Yes" : "No";

        System.out.println(s1 + " and " + s2 + " are Anagram: " + isAnagram);
    }

    private static void sumOfAllDigits() {
        Integer num = 3479;
        String ns = num.toString();
        int sumOfAllDigits = Arrays.stream(ns.split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println("sumOfAllDigits: " + sumOfAllDigits);
    }

    private static void isStringPalindrome() {
        String s = "abba";
        boolean isPalindrome = IntStream.range(0, s.length() / 2).noneMatch(i -> s.charAt(i) != s.charAt(s.length() - 1 - i));
        System.out.println(s + " is palindrome: " + (isPalindrome ? "yes" : "no"));
    }

    private static void findMaxAndMinFromList(List<Integer> integerrList) {
        integerrList.stream().max(Comparator.naturalOrder()).ifPresent(i -> System.out.println("max number from list is: " + i));

        integerrList.stream().min(Comparator.naturalOrder()).ifPresent(i -> System.out.println("min number from list is: " + i));
    }


    private static void getMaxFromGroup(List<BlogPost> blogPostsList) {
        Map<BlogPostType, Optional<BlogPost>> getMaxFromGroup = blogPostsList.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.maxBy(Comparator.comparing(BlogPost::getLikes))));
        System.out.println("getMaxFromGroup: " + getMaxFromGroup);
    }

    private static void frequencyOfEachCharacterInString() {
        String inputString = "My name is Rehan";
        Map<String, Long> frqOfEachChar = Arrays.stream(inputString.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("frequency Of Each Char: " + frqOfEachChar);
    }

    private static void seperateOddAndEvenNumbers() {
        Map<Boolean, List<Integer>> seperateOddEven = IntStream.range(1, 15).boxed().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("seperateOddEve: " + seperateOddEven);
    }

    private static List<BlogPost> getBlogPostsList() {
        List<BlogPost> blogPosts = Arrays.asList(new BlogPost("IT", "Java", BlogPostType.NEWS, 10),
                new BlogPost("ECOM", "business", BlogPostType.GUIDE, 17),
                new BlogPost("Automobile", "Car", BlogPostType.NEWS, 2));
        return blogPosts;
    }
}
