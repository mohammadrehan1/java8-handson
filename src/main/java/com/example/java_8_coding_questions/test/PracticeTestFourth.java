package com.example.java_8_coding_questions.test;

import com.example.java_8_coding_questions.model.BlogPost;
import com.example.java_8_coding_questions.model.BlogPostType;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PracticeTestFourth {

    public static void main(String[] args) {

        List<BlogPost> blogPosts = getBlogPostsList();


        //seperateOddAndEvenNumbers
        Map<Boolean, List<Integer>> seperateOddAndEvenNumbers = IntStream.range(1, 15).boxed().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println("seperateOddAndEvenNumbers: " + seperateOddAndEvenNumbers);

        //frequencyOfEachCharacterInString
        String inputString = "My name is Rehan";
        Map<Character, Long> freqOfEachChar = inputString.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("freqOfEachChar: " + freqOfEachChar);

        ////blogpost sum value of Likes
        Map<BlogPostType, Integer> blogPostSumOfLikes = blogPosts.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.summingInt(BlogPost::getLikes)));
        System.out.println("blogPostSumOfLikes: " + blogPostSumOfLikes);


        ////Getting the Maximum or Minimum from Grouped Results
        Map<BlogPostType, Optional<BlogPost>> maxLikesFromBlogPost = blogPosts.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.maxBy(Comparator.comparingInt(BlogPost::getLikes))));
        System.out.println("maxLikesFromBlogPost: " + maxLikesFromBlogPost);

        ////sort list of names in reverse order
        List<String> names = Arrays.asList("Akash", "Zebra", "Pankaj", "John", "Ponta", "Julie");
        List<String> reversedNames = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("reversedNames: "+reversedNames);

        //print multiple of five from the list
        IntStream.range(1,20).boxed().filter(x -> x%5 ==0).forEach(i -> System.out.print(i+" "));

        System.out.println();

        //3 max and 3 min numbers from list
        List<Integer> integerList = Arrays.asList(2, 5, 1, 3, 7, 9, 3, 45, 23);
        System.out.println("Three max from list-----");
        integerList.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(i -> System.out.print(i+" "));
        System.out.println();

        System.out.println("Three min from list-----");
        integerList.stream().sorted().limit(3).forEach(i -> System.out.print(i+" "));
        System.out.println();

        //print List of String in increasing order of their length
        System.out.println("List of strings in increasing order of their length======");
        names.stream().sorted(Comparator.comparing(String::length)).forEach(i -> System.out.print(i+" "));
        System.out.println();

        //reversed an Integer array
        int[] intArray = new int[]{2,1,4,6,5,7};
        IntStream.range(0, intArray.length).boxed().map(i -> intArray[intArray.length-i-1]).forEach(i -> System.out.print(i+" "));
        System.out.println();

        ////check if string is palindrome
        String s ="ana";
        boolean checkIfPalindrom = IntStream.range(0, s.length() / 2).noneMatch(i -> s.charAt(i) != s.charAt(s.length() - i - 1));
        String isPalindrom = checkIfPalindrom?"Yes":"No";
        System.out.println(s+" is palindrome? :"+isPalindrom);

        //find last element of an array
        List<Integer> integerrList = Arrays.asList(2, 4, 6, 2, 8, 45, 3);

        integerrList.stream().skip(integerrList.size()-1).findFirst().ifPresent(i -> System.out.println("last element of list iss: "+i));

        integerrList.stream().reduce((a,b)-> b).ifPresent(i -> System.out.println("last element of list iss: "+i));

        //find Longest string in given list
        names.stream().reduce((a, b) -> a.length()>b.length()?a:b).ifPresent(i -> System.out.println("longest string in list is: "+i));

        //maximum and minimum in given integer list
        Integer maxNumFromList = integerrList.stream().max(Comparator.naturalOrder()).get();
        System.out.println("maximum in given integer list is: "+maxNumFromList);

        Integer minNumberFromList = integerrList.stream().min(Comparator.naturalOrder()).get();
        System.out.println("minimum in given integer list is: "+minNumberFromList);

        ////sum of all digits of number
        Integer i = 76439;
        String numStr = i.toString();
        Integer sumOfAllDigits = Arrays.stream(numStr.split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println("sumOfAllDigits: "+sumOfAllDigits);

        //find common element between two list
        List<Integer> integerList1 = Arrays.asList(4, 6, 1, 2, 4, 7);
        List<Integer> integerList2 = Arrays.asList(56, 2, 5, 9, 60, 4, 1);
        System.out.println("Common elements in two list are=====");
        integerList1.stream().filter(integerList2::contains).distinct().forEach(y -> System.out.print(y+" "));

        System.out.println();
        //reverse each word of string
        Arrays.stream(inputString.split(" ")).map(p -> new StringBuffer(p).reverse()).forEach(k -> System.out.print(k+" "));
        System.out.println();

        //find strings which start with number

    }

    private static List<BlogPost> getBlogPostsList() {
        List<BlogPost> blogPosts = Arrays.asList(new BlogPost("IT", "Java", BlogPostType.NEWS, 10),
                new BlogPost("ECOM", "business", BlogPostType.GUIDE, 17),
                new BlogPost("Automobile", "Car", BlogPostType.NEWS, 2));
        return blogPosts;
    }
}
