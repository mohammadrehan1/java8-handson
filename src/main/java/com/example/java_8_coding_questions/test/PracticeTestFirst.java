package com.example.java_8_coding_questions.test;

import com.example.java_8_coding_questions.model.BlogPost;
import com.example.java_8_coding_questions.model.BlogPostType;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PracticeTestFirst {

    public static void main(String[] args) {

        //seperate odd and even numbers
        List<Integer> integerList = Arrays.asList(14, 19, 17, 37, 24, 10, 62, 90, 46);
        Map<Boolean, List<Integer>> seperatedOddAndEven = integerList.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("seperatedOddAndEven: " + seperatedOddAndEven);

        //frequency of each character in String
        String inputString = "My name is Rehan";
        Map<String, Long> eachCharFreq = Arrays.stream(inputString.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("eachCharFreq : " + eachCharFreq);

        //find string which occurs more than one
        String mostOccurChar = eachCharFreq.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get();
        System.out.println("mostOccurChar : " + mostOccurChar);

        List<BlogPost> blogPosts = getBlogPostsList();

        //Getting the Average from Grouped Results
        Map<BlogPostType, Double> averageFromGroupResult = blogPosts.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.averagingInt(BlogPost::getLikes)));
        System.out.println("averageFromGroupResult: " + averageFromGroupResult);

        ////sum value of Likes
        Map<BlogPostType, Integer> sumOfLikes = blogPosts.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.summingInt(BlogPost::getLikes)));
        System.out.println("sumOfLikes: " + sumOfLikes);

        ////Getting the Maximum or Minimum from Grouped Results
        Map<String, Optional<BlogPost>> maxLikeBlogPostFromGroup = blogPosts.stream().collect(Collectors.groupingBy(BlogPost::getTitle, Collectors.maxBy(Comparator.comparing(BlogPost::getLikes))));
        System.out.println("maxLikeBlogPostFromGroup: " + maxLikeBlogPostFromGroup);

        //sort list of names in reverse order
        List<String> names = Arrays.asList("Akash", "Zebra", "Pankaj", "John", "Ponta", "Julie");
        List<String> reversedNames = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("reversedNames: " + reversedNames);

        //print multiple of five from the list
        List<Integer> multipleOfFive = Stream.iterate(0, i -> i + 5).filter(i -> i != 0 && i % 5 == 0).limit(10).collect(Collectors.toList());
        System.out.println(multipleOfFive);

        //print max three and min numbers
        List<Integer> numbers = Arrays.asList(2, 6, 1, 8, 16, 33, 7, 53);
        List<Integer> maxThree = numbers.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
        System.out.println("maxThree: " + maxThree);

        //mereg two unsortedarray into sorted single array
        int[] firstArray = new int[]{2, 34, 8, 1, 2, 9, 117};
        int[] secondArray = new int[]{5, 1, 3, 0, 1, 4, 14, 10};
        int[] mergedSortedArray = IntStream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).sorted().toArray();
        Arrays.stream(mergedSortedArray).forEach(i -> System.out.print(i + " "));

        System.out.println();
        //mereg two unsortedarray into sorted single array without duplicate
        int[] mergedSortedArrayWithoutDuplicate = IntStream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).sorted().distinct().toArray();
        Arrays.stream(mergedSortedArrayWithoutDuplicate).forEach(i -> System.out.print(i + " "));

        System.out.println();
        //print List of String in increasing order of their length
        List<String> namesInIncreasingOrderOfLenght = names.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        System.out.println("namesInIncreasingOrderOfLenght: " + namesInIncreasingOrderOfLenght);

        //sum and average of all elemnts of array
        int sumOfAllArrayElements = Arrays.stream(mergedSortedArrayWithoutDuplicate).sum();
        System.out.println("sumOfAllArrayElements: " + sumOfAllArrayElements);

        double averageOfAllArrayElements = Arrays.stream(mergedSortedArrayWithoutDuplicate).average().getAsDouble();
        System.out.println("averageOfAllArrayElements: " + averageOfAllArrayElements);

        //reversed an Integer array
        int[] reversedArray = IntStream.rangeClosed(1, mergedSortedArrayWithoutDuplicate.length).map(i -> mergedSortedArrayWithoutDuplicate[mergedSortedArrayWithoutDuplicate.length - i]).toArray();
        Arrays.stream(reversedArray).forEach(i -> System.out.print(i + " "));

        //check if string is palindrome
        String str = "abba";
        String str1 = "RACEcar";
        boolean isPalindrome = IntStream.range(0, str.length() / 2).noneMatch(i -> str.charAt(i) != str.charAt(str.length() - i - 1));
        System.out.println("isPalindrome: " + isPalindrome);

        //find last element of an array
        int lastElementOfList = numbers.stream().skip(numbers.size() - 1).findFirst().get();
        System.out.println("lastElementOfList: " + lastElementOfList);

        //remove duplicate element from list
        List<Integer> integerList1 = Arrays.asList(1, 3, 2, 1, 1, 5, 2, 4, 9);
        List<Integer> removedDuplicateFromList = integerList1.stream().distinct().collect(Collectors.toList());
        System.out.println("removedDuplicateFromList: " + removedDuplicateFromList);

        ////frequency of each elemnt in List
        List<Integer> integerList11 = Arrays.asList(2, 4, 5, 6, 7, 8, 9, 10, 1, 3, 4, 4, 6, 2);
        Map<Integer, Long> freqOfEachEle = integerList11.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("freqOfEachEle: " + freqOfEachEle);

        //find Longest string in given list
        List<String> stringList = Arrays.asList("Rehan", "Aftaab", "John", "Tom", "Senorita");
        String longestString = stringList.stream().reduce((a, b) -> a.length() > b.length() ? a : b).get();
        System.out.println("longestString: " + longestString);

        String joinedWithPreSuffixAndDelimiter = stringList.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.println("joinedWithPreSuffixAndDelimiter: " + joinedWithPreSuffixAndDelimiter);

        //max number from list
        int maxNumber = numbers.stream().max(Comparator.naturalOrder()).get();
        System.out.println("maxNumber: " + maxNumber);

        //min number from list
        int minNumber = numbers.stream().min(Comparator.naturalOrder()).get();
        System.out.println("minNumber: " + minNumber);

        //sum of all digits of number
        Integer digit = 13450;
        String digInStr = digit.toString();
        Integer sum = Arrays.stream(digInStr.split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println("sum of all digigts: " + sum);

        // find second Largest number in Integer List
        int secondLargeNum = numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("secondLargeNum: " + secondLargeNum);

        //find common element between two list
        List<Integer> integerList111 = Arrays.asList(4, 6, 1, 2, 4, 7);
        List<Integer> integerList222 = Arrays.asList(56, 2, 5, 9, 60, 4, 1);
        List<Integer> commonEle = integerList111.stream().filter(integerList222::contains).collect(Collectors.toList());
        System.out.println("commonElement : " + commonEle);

        //reverse each word of string
        String s = "Rehan is a good man";
        String reversedStr = Arrays.stream(s.split(" ")).map(word -> new StringBuffer(word).reverse()).collect(Collectors.joining(" "));
        System.out.println("reversedStr: " + reversedStr);

        //find strings which start with number
        List<String> stringListt = Arrays.asList("Rehan", "Varun", "9Vistara", "2Kajol");
        List<String> stringStartWithDigit = stringListt.stream().filter(st -> Character.isDigit(st.charAt(0))).collect(Collectors.toList());
        System.out.println("stringStartWithDigit: " + stringStartWithDigit);

        //find duplicate element from list
        Set<String> set = new HashSet<>();
        List<String> nameList = Arrays.asList("Rehan", "Akash", "Rehan", "Jitendra", "Akash");
        List<String> duplicateElements = nameList.stream().filter(name -> !set.add(name)).collect(Collectors.toList());
        Set<String> dupplicateElements = nameList.stream().filter(nm -> Collections.frequency(nameList, nm)>1).collect(Collectors.toSet());
        System.out.println("duplicateElements: " + duplicateElements);
        System.out.println("dupplicateElements using frequency method : " + dupplicateElements);


        //fibonacci series
        List<Integer> fibonacciSeries = Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]}).map(arr -> arr[0]).limit(15).collect(Collectors.toList());
        System.out.println("fibonacciSeries: " + fibonacciSeries);

        //Anagram program
        //An anagram of a string is another string that contains the same characters,
        // only the order of characters can be different.
        // For example, “abcd” and “dabc” are an anagram of each other.
        String ss = "abcd";
        String ss1 = "dabc";
        String sortedStr = Arrays.stream(ss.split("")).sorted().collect(Collectors.joining(""));
        String sortedStr1 = Arrays.stream(ss1.split("")).sorted().collect(Collectors.joining(""));

        boolean isAnagram = sortedStr.equals(sortedStr1);
        System.out.println("isAnagram " + isAnagram);

        // find most repeated elements in an array
        int[] elements = {2, 3, 1, 4, 4, 1, 4, 333, 3, 333, 2, 2, 2, 5, 222};
        Map<Integer, Long> elemntByCount = Arrays.stream(elements).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int mostRepeatedEl = elemntByCount.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get();
        System.out.println("mostRepeatedEl: "+mostRepeatedEl);

        //Extract duplicate elements from an array
        List<Integer> duplicateElementtt = Arrays.asList(1, 2,2,2,3, 3, 4, 5,1,1,56, 7, 8, 9, 10);
        List<Integer> extractedDuplicateElement = duplicateElementtt.stream().filter(i -> duplicateElements.indexOf(i) != duplicateElements.lastIndexOf(i)).collect(Collectors.toList());
        System.out.println("extractedDuplicateElement: "+extractedDuplicateElement);

        List<Integer> duplicateElementss = Arrays.asList(1, 2,2,2,3, 3, 4, 5,1,1,56, 7, 8, 9, 10);
        System.out.println("maxed Elements " + duplicateElements);

        //Print duplicate characters in a string
        String word = "rohttoh";
        List<Character> duplicateChar = Arrays.stream(word.split("")).filter(c -> word.indexOf(c) != word.lastIndexOf(c)).map(st -> st.charAt(0)).distinct().collect(Collectors.toList());
        System.out.println("duplicateChar: "+duplicateChar);

        //Find the first repeated character in a string
        String firstRepeatedChar = Arrays.stream(word.split("")).filter(c -> word.indexOf(c) != word.lastIndexOf(c)).findFirst().get();
        System.out.println("firstRepeatedChar: "+firstRepeatedChar);

        //Find the first non-repeated character in a string
        String firstNonRepeatedChar = Arrays.stream(word.split("")).filter(c -> word.indexOf(c) == word.lastIndexOf(c)).findFirst().get();
        System.out.println("firstNonRepeatedChar: "+firstNonRepeatedChar);

        //Print the first 10 odd numbers
        Stream.iterate(1, i -> i+2).limit(10).forEach( j-> System.out.print(j+" "));

        //Get the last element of an array
        int[] intArray = {0,1,2,3,4,5};
        int lastElement = Arrays.stream(intArray).reduce((a,b) -> b).getAsInt();
        System.out.println("lastElement: "+lastElement);



        //Calculate the age of a person in years
        LocalDate currentDate = LocalDate.now();
        LocalDate dob = LocalDate.of(1992, 11, 06);

        int age = Period.between(dob, currentDate).getYears();
        System.out.println("age in years: "+age);

        //get max frequent character in string


        //get Nth highest likes in blogPost


    }

    private static List<BlogPost> getBlogPostsList() {
        List<BlogPost> blogPosts = Arrays.asList(new BlogPost("IT", "Java", BlogPostType.NEWS, 10),
                new BlogPost("ECOM", "business", BlogPostType.GUIDE, 17),
                new BlogPost("Automobile", "Car", BlogPostType.NEWS, 2));
        return blogPosts;
    }
}
