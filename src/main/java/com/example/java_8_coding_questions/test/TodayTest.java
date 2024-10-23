package com.example.java_8_coding_questions.test;

import com.example.java_8_coding_questions.model.BlogPost;
import com.example.java_8_coding_questions.model.BlogPostType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TodayTest {

    public static void main(String[] args) {

        //seperate odd and even number
        Map<Boolean, List<Integer>> seperatedOddEven = IntStream.range(1, 10).boxed().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("seperatedOddEven: " + seperatedOddEven);

        //frequency of each character in String
        String inputString = "My name is Rehan";
        Map<String, Long> freqOfEachChar = Arrays.stream(inputString.split("")).filter(word -> !word.equals(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("freqOfEachChar: " + freqOfEachChar);

        //most frequent char
        freqOfEachChar.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).ifPresent(System.out::print);

        System.out.println();
        List<BlogPost> blogPosts = getBlogPostsList();

        Map<String, Optional<BlogPost>> maxFromGroupResult = blogPosts.stream().collect(Collectors.groupingBy(BlogPost::getTitle, Collectors.maxBy(Comparator.comparing(BlogPost::getLikes))));
        System.out.println("maxFromGroupResult: " + maxFromGroupResult);


        //sort list of names in reverse order
        List<String> names = Arrays.asList("Akash", "Zebra", "Pankaj", "John", "Ponta", "Julie");
        List<String> reversedNames = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(reversedNames);

        // //print multiple of five from the list
        IntStream.range(0, 50).boxed().filter(i -> i % 5 == 0 && i != 0).forEach(i -> System.out.print(i + " "));
        System.out.println();

        //3 max and 3 min numbers from list
        System.out.println("max three from list: ");
        List<Integer> numbers = Arrays.asList(2, 6, 1, 8, 16, 33, 7, 53);
        numbers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(i -> System.out.print(i + " "));
        System.out.println();


        System.out.println("min three from list: ");
        numbers.stream().sorted().limit(3).forEach(i -> System.out.print(i + " "));

        System.out.println();

        //print List of String in increasing order of their length
        String namesList = names.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.joining(" "));
        System.out.println("List of String in increasing order of their length: " + namesList);

        //reverse integer array
        int[] firstArray = new int[]{2, 34, 8, 1, 2, 9, 117};

        IntStream.range(0, firstArray.length).map(i -> firstArray[firstArray.length - 1 - i]).forEach(i -> System.out.print(i + " "));
        System.out.println();

        //check if string is palindrome
        String chek = "naman";

        boolean isPalindrome = IntStream.range(0, chek.length() / 2).noneMatch(i -> chek.charAt(i) != chek.charAt(chek.length() - 1 - i));
        System.out.println(chek + " is palindrome: " + (isPalindrome ? "Yes" : "No"));

        //find last element of an array
        numbers.stream().reduce((a, b) -> b).ifPresent(i -> System.out.println("last element of list is " + i));

        numbers.stream().skip(numbers.size() - 1).findFirst().ifPresent(i -> System.out.println("last element of list is using skip method " + i));


        //frequency of each elemnt in List
        List<Integer> integerList = Arrays.asList(2, 4, 5, 6, 7, 8, 9, 10, 1, 3, 4, 4, 6, 2);

        Map<Integer, Long> freqencyOfEachElement = integerList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        //find Longest string in given list
        List<String> stringList = Arrays.asList("Rehan", "Aftaab", "John", "Tom", "Senorita");
        stringList.stream().reduce((a, b) -> a.length() > b.length() ? a : b).ifPresent(i -> System.out.println("Longest length string is : " + i));

        //maximum and minimum in given integer list
        numbers.stream().max(Comparator.naturalOrder()).ifPresent(i -> System.out.println("max element of list is : " + i));

        numbers.stream().min(Comparator.naturalOrder()).ifPresent(i -> System.out.println("max element of list is : " + i));

        //sum of all digits of number
        Integer in = 1527;

        int t = in;
        int res = 0;
        while (t != 0) {
            int remainder = t % 10;
            res = res + remainder;

            t = t / 10;

        }
        System.out.println(res);

        String strNum = in.toString();

        Integer sumOfAlldigits = Arrays.stream(strNum.split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println("sumOfAlldigits: " + sumOfAlldigits);

        // find second Largest number in Integer List
        numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(i -> System.out.println("second large element in list is : " + i));

//find common element between two list
        List<Integer> integerList1 = Arrays.asList(4, 6, 1, 2, 4, 7);
        List<Integer> integerList2 = Arrays.asList(56, 2, 5, 9, 60, 4, 1);

        List<Integer> commonElements = integerList1.stream().filter(integerList2::contains).distinct().collect(Collectors.toList());
        System.out.println("commonElements: " + commonElements);

        //reverse each word of string
        String reversedEachWord = Arrays.stream(inputString.split(" ")).map(word -> new StringBuffer(word).reverse()).collect(Collectors.joining(" "));
        System.out.println("reverse each word of string: " + reversedEachWord);

        //find duplicate element from list
        List<String> strngList = Arrays.asList("Rehan", "Akash", "Rehan", "Jitendra", "Akash");
        HashSet<String> set = new HashSet<>();

        Set<String> duplicates = strngList.stream().filter(e -> !set.add(e)).collect(Collectors.toSet());
        System.out.println("duplicates elements: " + duplicates);

        Set<String> duplicateEl = strngList.stream().filter(e -> strngList.indexOf(e) != strngList.lastIndexOf(e)).collect(Collectors.toSet());
        System.out.println("duplicates elements using index of method: " + duplicateEl);

        //fibonacci series
        Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]}).limit(10).map(el -> el[0]).forEach(i -> System.out.print(i + " "));
        System.out.println();

        //Anagram program
        String s1 = "abcd";
        String s2 = "bdca";

        String sortedS1 = Arrays.stream(s1.split("")).sorted().collect(Collectors.joining(""));
        String sortedS2 = Arrays.stream(s2.split("")).sorted().collect(Collectors.joining(""));

        String isAnagram = sortedS1.equals(sortedS2) ? "YES" : "NO";
        System.out.println(s1 + " and " + s2 + " are Anagram: " + isAnagram);


//most repeated element in array
        int[] elements = {2, 3, 1, 4, 4, 1, 4, 333, 3, 333, 2, 2, 2, 5, 222};
        Arrays.stream(elements).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .ifPresent(i -> System.out.println("most repeated element is " + i));


        //Print duplicate characters in a string
        String word = "rohttoh";
        String extractedDuplicateChar = Arrays.stream(word.split("")).filter(c -> word.indexOf(c) != word.lastIndexOf(c)).distinct().collect(Collectors.joining(""));
        System.out.println("extractedDuplicateChar: " + extractedDuplicateChar);

        //Find the first repeated character in a string
        Arrays.stream(word.split("")).filter(c -> word.indexOf(c) != word.lastIndexOf(c)).findFirst().ifPresent(i -> System.out.println("first repeated char is " + i));

        //Find the first non-repeated character in a string
        Arrays.stream(word.split("")).filter(c -> word.indexOf(c) == word.lastIndexOf(c)).findFirst().ifPresent(i -> System.out.println("first non-repeated char is " + i));

        //Print the first 10 odd numbers
        Stream.iterate(1, f -> f + 2).limit(10).forEach(i -> System.out.print(i + " "));
        System.out.println();


        //Calculate the age of a person in years
        LocalDate dob = LocalDate.of(1992, 11, 06);
        LocalDate current = LocalDate.now();
        int age = Period.between(dob, current).getYears();
        System.out.println("age is : " + age);

        //sorts the entries of a Map by keys in the natural order and collects the sorted entries in a LinkedHashMap
        Map<String, Integer> unsortedMap = Map.of("a", 1, "c", 3, "b", 2, "e", 5, "d", 4);

        LinkedHashMap<String, Integer> sortedMapByKey = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("sortedMapByKey: " + sortedMapByKey);

        ////check number is prime or not
        int numb = 4;
        boolean isPrime = isPrime(numb);
        System.out.println(numb + " is Prime: " + (isPrime ? "Yes" : "No"));

        //print prime number between 1 to 50
        List<Integer> primeNumbers = IntStream.range(2, 50).boxed().filter(i -> isPrime(i)).collect(Collectors.toList());
        System.out.println("primeNumbers: "+primeNumbers);


    }

    private static boolean isPrime(int numb) {
        boolean isPrime = IntStream.rangeClosed(2, numb / 2).boxed().noneMatch(i -> numb % i == 0);
        return isPrime;
    }

    private static List<BlogPost> getBlogPostsList() {
        List<BlogPost> blogPosts = Arrays.asList(new BlogPost("IT", "Java", BlogPostType.NEWS, 10),
                new BlogPost("ECOM", "business", BlogPostType.GUIDE, 17),
                new BlogPost("Automobile", "Car", BlogPostType.NEWS, 2));
        return blogPosts;
    }
}
