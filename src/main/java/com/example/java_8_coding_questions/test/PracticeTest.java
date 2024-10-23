package com.example.java_8_coding_questions.test;

import com.example.java_8_coding_questions.model.BlogPost;
import com.example.java_8_coding_questions.model.BlogPostType;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PracticeTest {


    public static void main(String[] args) {

		/*
		 * //seperate odd and even numbers List<Integer> integerList = Arrays.asList(2,
		 * 5, 23, 78, 30, 36, 48, 10); Map<Boolean, List<Integer>> seperateOddAndEven =
		 * integerList.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
		 * System.out.println(seperateOddAndEven);
		 * 
		 * //frequency of each char in string String inputString = "My name is Rehan";
		 * Map<Character, Long> frequencyOfEachChar = inputString.chars().mapToObj(i ->
		 * (char) i).collect(Collectors.groupingBy(Function.identity(),
		 * Collectors.counting())); System.out.println(frequencyOfEachChar);
		 * 
		 * // most occured char in string Map.Entry<Character, Long> characterLongEntry
		 * =
		 * frequencyOfEachChar.entrySet().stream().max(Map.Entry.comparingByValue()).get
		 * (); System.out.println(characterLongEntry);
		 * 
		 * List<BlogPost> blogPostsList = getBlogPostsList();
		 * 
		 * //avg time from blog Map<BlogPostType, Double> blogPostTypeDoubleMap =
		 * blogPostsList.stream().collect(Collectors.groupingBy(BlogPost::getType,
		 * Collectors.averagingInt(BlogPost::getLikes)));
		 * System.out.println(blogPostTypeDoubleMap);
		 * 
		 * Map<BlogPostType, Optional<BlogPost>> blogPostTypeOptionalMap =
		 * blogPostsList.stream().collect(Collectors.groupingBy(BlogPost::getType,
		 * Collectors.maxBy(Comparator.comparing(BlogPost::getLikes))));
		 * System.out.println(blogPostTypeOptionalMap);
		 * 
		 * List<String> names = Arrays.asList("Akash", "Zebra", "Pankaj", "John",
		 * "Ponta", "Julie"); List<String> reverseOrderString =
		 * names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())
		 * ; System.out.println(reverseOrderString);
		 * 
		 * //print multiple of five from list List<Integer> multipleOfFiveList =
		 * IntStream.range(1, 30).filter(i -> i%5
		 * ==0).boxed().collect(Collectors.toList());
		 * System.out.println(multipleOfFiveList);
		 * 
		 * List<Integer> numbers = Arrays.asList(2, 6, 1, 8, 16, 33, 7, 53);
		 * List<Integer> threeMinNumbers =
		 * numbers.stream().sorted().limit(3).collect(Collectors.toList());
		 * 
		 * System.out.println(threeMinNumbers);
		 * 
		 * List<Integer> threeMaxNumbers =
		 * numbers.stream().sorted(Comparator.reverseOrder()).limit(3).collect(
		 * Collectors.toList()); System.out.println(threeMaxNumbers);
		 * 
		 * int[] firstArray = new int[]{2,34,8,1,2,9,117}; int[] secondArray = new
		 * int[]{5,1,3,0,1,4,14,10};
		 * 
		 * int[] mergedSortedArray = IntStream.concat(Arrays.stream(firstArray),
		 * Arrays.stream(secondArray)).sorted().toArray();
		 * Arrays.stream(mergedSortedArray).forEach(i -> System.out.print(i+" "));
		 * System.out.println(); int[] mergedArrayWithoutDuplicate =
		 * IntStream.concat(Arrays.stream(firstArray),
		 * Arrays.stream(secondArray)).sorted().distinct().toArray();
		 * Arrays.stream(mergedArrayWithoutDuplicate).forEach(i ->
		 * System.out.print(i+" "));
		 * 
		 * System.out.println(); List<String> stringList = Arrays.asList("Rehan",
		 * "John", "Monika", "Abraham", "Senorita", "Julie"); List<String>
		 * stringInIncreasingOrderOfTheirLength =
		 * stringList.stream().sorted(Comparator.comparing(String::length)).collect(
		 * Collectors.toList());
		 * System.out.println(stringInIncreasingOrderOfTheirLength);
		 * 
		 * double asDouble = Arrays.stream(mergedSortedArray).average().getAsDouble();
		 * System.out.println(asDouble);
		 * 
		 * int[] reversedIntArrays = IntStream.rangeClosed(1,
		 * mergedSortedArray.length).map(i ->
		 * mergedSortedArray[mergedSortedArray.length-i]).toArray();
		 * Arrays.stream(reversedIntArrays).forEach(i -> System.out.print(i+" "));
		 * 
		 * //check if string is palindrom String str = "abba"; String str1 = "RACEcar";
		 * 
		 * boolean isStringPalindrome = IntStream.range(0, str.length()/2).noneMatch(i
		 * -> str.charAt(i) != str.charAt(str.length()-i-1));
		 * System.out.println(isStringPalindrome);
		 * 
		 * Integer palindromeNumber = 151; String stringNum =
		 * palindromeNumber.toString(); boolean noneMatch = IntStream.range(0,
		 * stringNum.length()/2).noneMatch(i -> stringNum.charAt(i) !=
		 * stringNum.charAt(stringNum.length()-i-1)); System.out.println(noneMatch);
		 * 
		 * List<Integer> integerListt = Arrays.asList(2, 4, 6, 2, 8, 45, 3); Integer
		 * lastElement =
		 * integerListt.stream().skip(integerListt.size()-1).findFirst().get();
		 * System.out.println(lastElement);
		 * 
		 * List<Integer> integerList1 = Arrays.asList(1, 3, 2, 1, 1, 5, 2, 4, 9);
		 * List<Integer> removedDuplicates =
		 * integerList1.stream().distinct().collect(Collectors.toList());
		 * System.out.println(removedDuplicates);
		 * 
		 * Set<Integer> set = new HashSet<>(); Set<Integer> duplicateElement =
		 * integerList1.stream().filter(i -> !set.add(i)).collect(Collectors.toSet());
		 * System.out.println(duplicateElement);
		 * 
		 * List<String> stringList1 = Arrays.asList("Rehan", "Aftaab", "John", "Tom",
		 * "Senorita"); //find longest string String longestString =
		 * stringList1.stream().reduce((a,b)-> a.length()>b.length()? a:b).get();
		 * System.out.println(longestString);
		 * 
		 * //join string with prefix,suffix and delimitter String joinedString =
		 * stringList1.stream().collect(Collectors.joining(",", "[", "]"));
		 * System.out.println(joinedString);
		 * 
		 * List<Integer> integerList2 = Arrays.asList(2, 4, 5, 1, 7, 8, 11, 98, 37, 13);
		 * Integer maxNum = integerList2.stream().max(Integer::compareTo).get();
		 * System.out.println(maxNum); Integer minNumber =
		 * integerList2.stream().min(Integer::compareTo).get();
		 * System.out.println(minNumber);
		 * 
		 * Integer number = 1594; String stringNumb = number.toString(); Integer
		 * sumOfAllGigits =
		 * Arrays.stream(stringNumb.split("")).collect(Collectors.summingInt(Integer::
		 * parseInt)); System.out.println(sumOfAllGigits);
		 * 
		 * //find second largest integer in list List<Integer> integerList3 =
		 * Arrays.asList(2, 4, 5, 6, 7, 13, 10, 14, 16, 32); Integer secondLargeNum =
		 * integerList3.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().
		 * get(); System.out.println(secondLargeNum);
		 * 
		 * //findCommonElement in two list List<Integer> integerList11 =
		 * Arrays.asList(4, 6, 1, 2, 4, 7); List<Integer> integerList12 =
		 * Arrays.asList(56, 2, 5, 9, 60, 4, 1); List<Integer> commonElementInTwoList =
		 * integerList11.stream().filter(integerList12::contains).collect(Collectors.
		 * toList()); System.out.println(commonElementInTwoList);
		 * 
		 * //reverse each word of string String s = "Rehan is a good man"; String
		 * reversedEachWord = Arrays.stream(s.split(" ")).map(word -> new
		 * StringBuffer(word).reverse()).collect(Collectors.joining(" "));
		 * 
		 * System.out.println(reversedEachWord);
		 * 
		 * List<String> strngList = Arrays.asList("Rehan", "Varun", "9Vistara",
		 * "2Kajol"); List<String> stringStartWithNum = strngList.stream().filter(st ->
		 * Character.isDigit(st.charAt(0))).collect(Collectors.toList());
		 * System.out.println(stringStartWithNum);
		 * 
		 * //fibonacci series List<Integer> fibonacciSeries = Stream.iterate(new int[]
		 * {0,1}, arr -> new int[] {arr[1],arr[0]+arr[1]}).limit(15).map(arr ->
		 * arr[0]).collect(Collectors.toList()); System.out.println(fibonacciSeries);
		 * 
		 * String s3 = "abcd"; String s1 = "dabc";
		 * 
		 * String sortedS1 =
		 * Arrays.stream(s1.split("")).sorted().collect(Collectors.joining()); String
		 * sortedS3 = Stream.of(s3.split("")).sorted().collect(Collectors.joining());
		 * boolean isAnagram = sortedS1.equals(sortedS3);
		 * System.out.println(sortedS1+" and "+sortedS3+" isAnagram: "+isAnagram);
		 * 
		 * int [] elements = {2,3,1,4,4,1,4,333,3,333,2,2,2,5,222}; Map<Integer, Long>
		 * elemntwiseCount =
		 * Arrays.stream(elements).boxed().collect(Collectors.groupingBy(Function.
		 * identity(),Collectors.counting())); Entry<Integer, Long> entry =
		 * elemntwiseCount.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		 * System.out.println(entry);
		 * 
		 * //print duplicate char in string String word = "rohttoh"; List<String>
		 * duplicateChar = Stream.of(word.split("")).filter(stt -> word.indexOf(stt) !=
		 * word.lastIndexOf(stt)).distinct().collect(Collectors.toList());
		 * System.out.println(duplicateChar);
		 * 
		 * List<Integer> duplicateElements = Arrays.asList(1, 2,2,2,3, 3, 4, 5,1,1,56,
		 * 7, 8, 9, 10); List<Integer> duplicateInteger =
		 * duplicateElements.stream().filter(el -> duplicateElements.indexOf(el) !=
		 * duplicateElements.lastIndexOf(el)).distinct().collect(Collectors.toList());
		 * System.out.println(duplicateInteger);
		 * 
		 * //find first repeated character String firstRepeatedChar =
		 * Stream.of(word.split("")).filter(strr -> word.indexOf(strr) !=
		 * word.lastIndexOf(strr)).findFirst().get();
		 * System.out.println(firstRepeatedChar);
		 * 
		 * //Find the first non-repeated character in a string String
		 * firstNonRepeatedChar = Stream.of(word.split("")).filter(stiring ->
		 * word.indexOf(stiring) == word.lastIndexOf(stiring)).findFirst().get();
		 * System.out.println(firstNonRepeatedChar);
		 * 
		 * //Print the first 10 odd numbers List<Integer> firstTenOddNum =
		 * IntStream.range(0, 25).boxed().filter(i -> i%2
		 * !=0).collect(Collectors.toList()); System.out.println(firstTenOddNum);
		 * List<Integer> firstTenOddNumByIterate = Stream.iterate(1, i ->
		 * i+2).limit(10).collect(Collectors.toList());
		 * System.out.println(firstTenOddNumByIterate);
		 * 
		 * //Get the last element of an array int[] intArray = {0,1,2,3,4,5}; int
		 * lastElementInArray = Arrays.stream(intArray).reduce((a,b) -> b).getAsInt();
		 * System.out.println(lastElementInArray);
		 * 
		 * //Calculate the age of a person in years LocalDate dob = LocalDate.of(1992,
		 * 11, 06); LocalDate currentDate = LocalDate.now(); Period age =
		 * Period.between(dob, currentDate); System.out.println(age.getYears());
		 * 
		 * ////get max frequent character in string String inputtString =
		 * "MynameisRehan";
		 * 
		 * Map<String, Long> charCounts = Stream.of(inputtString.split("")).map(ss ->
		 * ss.toLowerCase()).collect(Collectors.groupingBy(Function.identity(),
		 * Collectors.counting())); String maxFrequentChar =
		 * charCounts.entrySet().stream().max(Map.Entry.comparingByValue()).map(Entry::
		 * getKey).get(); System.out.println(maxFrequentChar);
		 */


    	PracticeTest practiceTest = new PracticeTest();
    	practiceTest.practiceJava8Coding();
       
    }
    
    private void practiceJava8Coding() {
    	//seperateOddAndEvenNumbers
    	List<Integer> integerList = Arrays.asList(2, 5, 23, 78, 30, 36, 48, 10);
    	Map<Boolean, List<Integer>> seperateOddEven = integerList.stream().collect(Collectors.partitioningBy(i -> i%2 == 0));
    	System.out.println(seperateOddEven);
    	
    	//frequency of each char in string 
    	String inputString = "MynameisRehan";
    	Map<String, Long> eachCharFrequency = Stream.of(inputString.split("")).map(String::toLowerCase).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    	System.out.println(eachCharFrequency);
    	
    	// most occured char in string
    	String mostOccuredChar = eachCharFrequency.entrySet().stream().max(Map.Entry.comparingByValue()).map(Entry::getKey).get();
    	System.out.println(mostOccuredChar);
    	
    	//Getting the Average from Grouped Results
    	List<BlogPost> blogPostsList = getBlogPostsList();
    	Map<String, Double> avgFromGroupedResult = blogPostsList.stream().collect(Collectors.groupingBy(BlogPost::getTitle, Collectors.averagingInt(BlogPost::getLikes)));
    	System.out.println(avgFromGroupedResult);
    	
    	//get max and min from group result 
    	Map<BlogPostType, Optional<BlogPost>> maxFromGroupResult = blogPostsList.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.maxBy(Comparator.comparing(BlogPost::getLikes))));
    	System.out.println(maxFromGroupResult);
    	
    	Map<BlogPostType, Optional<BlogPost>> minFromGroupedResult = blogPostsList.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.minBy(Comparator.comparing(BlogPost::getLikes))));
    	System.out.println(minFromGroupedResult);
    	
    	//print multiple of five
    	List<Integer> multipleOfFive = IntStream.range(1, 40).filter(i -> i%5 == 0).boxed().collect(Collectors.toList());
    	System.out.println(multipleOfFive);
    	
    	//print three max and min numbers
    	List<Integer> numbers = Arrays.asList(2, 6, 1, 8, 16, 33, 7, 53);
    	List<Integer> threeMaxNum = numbers.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
    	System.out.println(threeMaxNum);
    	
    	List<Integer> threeMinNum = numbers.stream().sorted().limit(3).collect(Collectors.toList());
    	System.out.println(threeMinNum);
    	
    	//merge two unsorted arrays into single sorted array
    	int[] firstArray = new int[]{2,34,8,1,2,9,117};
        int[] secondArray = new int[]{5,1,3,0,1,4,14,10};
        
        int[] mergedTwoUnsortedArrayInOne = IntStream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).sorted().toArray();
        Arrays.stream(mergedTwoUnsortedArrayInOne).forEach(el -> System.out.print(el+" "));
        System.out.println();
        
      //merge two unsorted arrays into single sorted array without duplicate
        IntStream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).sorted().distinct().forEach(ele -> System.out.print(ele+" "));
        System.out.println();
        
    }

    private static List<BlogPost> getBlogPostsList() {
        List<BlogPost> blogPosts = Arrays.asList(new BlogPost("IT", "Java", BlogPostType.NEWS, 10),
                new BlogPost("ECOM", "business", BlogPostType.GUIDE, 17),
                new BlogPost("Automobile", "Car", BlogPostType.NEWS, 2));
        return blogPosts;
    }
}
