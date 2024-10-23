package com.example.java_8_coding_questions.test;

import com.example.java_8_coding_questions.model.BlogPost;
import com.example.java_8_coding_questions.model.BlogPostType;
import com.example.java_8_coding_questions.model.PostCountTitlesLikesStats;
import com.example.java_8_coding_questions.model.Tuple;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        seperateOddAndEvenNumbers();

        //groupingBy examples
        frequencyOfEachCharacterInString();


        List<BlogPost> blogPosts = getBlogPostsList();

        //grouping by single column
        groupingBySingleColumn(blogPosts);


        //groupingBy with a Complex Map Key Type
        groupingByComplexMapKey(blogPosts);


        //in groupingBy , Modifying the Returned Map Value Type
        modifyingGroupingByReturnedMapValueType(blogPosts);


        //Grouping by Multiple Fields: A different application of the downstream collector is to do a secondary groupingBy to the results of the first group by.
        //To group the List of BlogPosts first by author and then by type:
        groupingByMultipleFields(blogPosts);


        //Getting the Average from Grouped Results
        averageFromGroupedResult(blogPosts);


        //sum value of Likes
        sumOfGroupedResultLikes(blogPosts);


        //Getting a Summary for an Attribute of Grouped Results:The Collectors API offers a summarizing collector that we can use in cases when we need to calculate the count, sum, minimum, maximum and average of a numerical attribute at the same time.
        //The IntSummaryStatistics object for each type contains the count, sum, average, min and max values for the likes attribute. Additional summary objects exist for double and long values.
        summeryOfAttributeOfGroupedResult(blogPosts);


        //Getting the Maximum or Minimum from Grouped Results
        getMaxFromGroupedResult(blogPosts);


        //Aggregating Multiple Attributes of a Grouped Result
        aggregateMultipleAttributeOfGroupedResult(blogPosts);


        Map<BlogPostType, Optional<BlogPost>> blogPostTypeMapByMaxLike = blogPosts.stream().collect(Collectors.groupingBy(BlogPost::getType,
                Collectors.maxBy(Comparator.comparing(BlogPost::getLikes))));
        blogPostTypeMapByMaxLike.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(blogSpot -> {
                    Optional<BlogPost> value = blogSpot.getValue();

                    System.out.println(value.get().getTitle());
                });

        //Collectors.mapping() method:
        collectorMappingExample(blogPosts);

        //sort list of names in reverse order
        sortNamesInReverseOrder();

        //print multiple of five from the list
        printMultipleOfFiveFromList();

        //3 max and 3 min numbers from list
        printThreeMaxAndMinNumbers();

        //merge two unsorted arrays into single sorted array
        mergedTwoUnsortedArraysIntoSingleSortedArray();

        System.out.println();
        //merge two unsorted arrays into single sorted array without duplicate
        mergedTwoUnsortedArrayIntoSingleArrayWithoutDuplicate();

        System.out.println();
        //print List of String in increasing order of their length
        printListOfStringInIncreasingOrderOfTheirLenght();
        System.out.println();

        //sum and average of all elemnts of array
        sumAndAverageOfArrayElements();
        System.out.println();

        //reversed an Integer array
        reversedIntegerArray();
        System.out.println();

        //check if string is palindrome
        checkGivenStringAndNumberIsPalindrome();

        //find last element of an array
        findLastElementOfList();

        //remove duplicate element from list
        removeDuplicateFromList();
        
        //frequency of each elemnt in List
        frequencyOfEachElementInStringAndNumber();
        
        //find Longest string in given list
        findLongestStringInList();

        //join list of string with prefix,suffix,and delimitter
        joinStringListWithPrefixSuffixAndDelimitter();
        
        //maximum and minimum in given integer list
        maximumAndMinimumNumberInList();

        //sum of all digits of number
        sumOfAllDigitsOfNumber();

        // find second Largest number in Integer List
        findSecondLargestIntegerInList();

        //find common element between two list
        findCommonElementsInTwoList();

        //reverse each word of string
        reverseEachWordOfString();

        //find strings which start with number
        findStringsWhichStartsWithNumber();

        //find duplicate element from list
        findDuplicateElementsFromList();

        //fibonacci series
        fibonacciSeries();

        //Anagram program
        //An anagram of a string is another string that contains the same characters,
        // only the order of characters can be different.
        // For example, “abcd” and “dabc” are an anagram of each other.
        checkStringIsAnagram();

        // find most repeated elements in an array
        // implementation need to understand
        mostRepeatedElementInArray();

        //Extract duplicate elements from an array
        // also need to understand implementation
        extractDuplicateElements();

        //Print duplicate characters in a string
        //need to understand implementation
        duplicateCharactersInString();

        //Find the first repeated character in a string
        firstRepeatedCharacter();

        //Find the first non-repeated character in a string
        firstNonRepeatingCharacter();

        //Print the first 10 odd numbers
        firstTenOddNumbers();

        //Get the last element of an array
        lastElementInTheArray();

        //Calculate the age of a person in years
        calculatePersonAgeInYear();

        //just to understand collectingAndThen and Collectors.mapping method
        blogPostsTypeWithLongestTitle(blogPosts);

        //get max frequent character in string
        getMostFrequentCharacterInString();

        //sorts the entries of a Map by keys in the natural order and collects the sorted entries in a LinkedHashMap
        Map<String, Integer> unsortedMap = Map.of("a", 1, "c", 3, "b", 2, "e", 5, "d", 4);

        LinkedHashMap<String, Integer> sortedMapUsingKeys = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(entryset -> entryset.getKey(), entryset -> entryset.getValue(), (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("sortedMapUsingKeys: "+sortedMapUsingKeys);

        //sorts map in desc order
        LinkedHashMap<String, Integer> sortedMapInDescOrderUsingKeys = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue)-> oldValue, LinkedHashMap::new));
        System.out.println("sortedMapInDescOrderUsingKeys: "+sortedMapInDescOrderUsingKeys);

        //reverse integer array
        reverseIntegerArrayWithJava8();

        //get Nth highest likes in blogPost
        List<BlogPost> postsListWithSameLikes = getBlogPostsListWithSameLikes();
        Map<Integer, List<String>> likesWithAuthors = postsListWithSameLikes.stream().collect(Collectors.groupingBy(BlogPost::getLikes, Collectors.mapping(BlogPost::getAuthor, Collectors.toList())));
        System.out.println(likesWithAuthors);
        Map.Entry<Integer, List<String>> nthHighestLikes = likesWithAuthors.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList())
                .get(2);
        System.out.println(nthHighestLikes);


        //check number is prime or not
        int num = 8;
        boolean isPrime = isPrime(num);
        System.out.println(num+" is prime: "+isPrime);

        //print prime numbers between 1 to 40
        List<Integer> primeNumberBetween = IntStream.range(2, 40).boxed().filter(i -> isPrime(i)).collect(Collectors.toList());
        System.out.println("primeNumberBetween 1 to 40 are : "+primeNumberBetween);
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

    private static void getMostFrequentCharacterInString() {
        //frequency of each character in String
        String inputString = "My name is Rehan";
        Map<String, Long> charWithTheirCount = Arrays.stream(inputString.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charWithTheirCount);
        Map.Entry<String, Long> mostFrequentCharacterInString = Arrays.stream(inputString.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(mostFrequentCharacterInString);
    }

    private static void blogPostsTypeWithLongestTitle(List<BlogPost> blogPosts) {
        String maxLenghtTitle = blogPosts.stream().collect(Collectors.collectingAndThen(Collectors.mapping(
                // Encounter all the BlogPost objects
                // Map them to their title
                // Collect those titles in a list
                BlogPost::getTitle,
                Collectors.toList()),
                // Stream those titles again
                // Find the longest title
                // If not available, return "?"
                list -> {
            return list.stream().collect(Collectors.maxBy(Comparator.comparing(String::length))).orElse("?");
        }));
        System.out.println(maxLenghtTitle);

        Map<BlogPostType, String> blogPostTypeWithLongestTitle = blogPosts.stream().collect(Collectors.groupingBy(BlogPost::getType,
                Collectors.collectingAndThen(Collectors.mapping(
                                // Encounter all the BlogPost objects
                                // Map them to their title
                                // Collect those titles in a list
                        BlogPost::getTitle, Collectors.toList()),
                        // Stream those titles again
                        // Find the longest title
                        // If not available, return "?"
                        list -> {
                            return list.stream().collect(Collectors.maxBy(Comparator.comparing(String::length))).orElse("?");
                        })));
        System.out.println(blogPostTypeWithLongestTitle);
    }

    private static void calculatePersonAgeInYear() {
        LocalDate birthDate = LocalDate.of(1998, 8, 17);
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthDate, currentDate).getYears();
        System.out.println("Age of the person is: " + age);
    }

    //peek method used for logging
    private static void lastElementInTheArray() {
        int[] intArray = {0,1,2,3,4,5};
        Integer lastElementInTheArray = Arrays.stream(intArray)
                .boxed()
                .peek(x-> System.out.println("from reducing stream : "+x))
                .reduce((first, second) -> second).orElse(-1);
                //.stream().peek(x-> System.out.println("from reducing stream : "+x))

        System.out.println("\nlast elements in the array " + lastElementInTheArray);
    }

    private static void firstTenOddNumbers() {
        Stream.iterate(1,i->i+2)
                .limit(10)
                .forEach(System.out::print);
    }

    private static void firstNonRepeatingCharacter() {
        String tempStr = "rohitrohi";
        System.out.println (Arrays.stream (tempStr.split (""))
                .filter (str -> tempStr.indexOf (str) == tempStr.lastIndexOf (str))
                .findFirst ()
                .orElse (""));
    }

    private static void firstRepeatedCharacter() {
        String word = "rohttoh";
        System.out.println (Arrays.stream (word.split (""))
                .filter (str -> word.indexOf (str) != word.lastIndexOf (str))
                .findFirst ().orElse (""));
    }

    private static void duplicateCharactersInString() {
        String word = "rohttoh";
        System.out.println ("original String " + word);


        System.out.println (Arrays.stream (word.split (""))
                .filter (str -> word.indexOf (str) != word.lastIndexOf (str))
                .map (str -> str.charAt (0))
                .collect (Collectors.toList ()));
    }

    private static void extractDuplicateElements() {
        List<Integer> duplicateElements = Arrays.asList(1, 2,2,2,3, 3, 4, 5,1,1,56, 7, 8, 9, 10);
        System.out.println("maxed Elements " + duplicateElements);

        List<Integer> extractDuplicateElements = duplicateElements.stream()
                .filter(element -> duplicateElements.indexOf(element)
                        != duplicateElements.lastIndexOf(element))
                .distinct()
                .collect(Collectors.toList());


        System.out.println("extract duplicates elements from " + extractDuplicateElements);
    }

    private static void mostRepeatedElementInArray() {
        int [] elements = {2,3,1,4,4,1,4,333,3,333,2,2,2,5,222};
        System.out.println("original Array" + Arrays.toString(elements));
        Function<Map<Integer, Long>, Integer> maxValuesKey = integerLongMap ->
                integerLongMap.entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .map(Map.Entry::getKey)
                        .orElse(Integer.MAX_VALUE);

        Integer maxDuplicateValue = Arrays.stream(elements)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()), maxValuesKey));

        System.out.println("max duplicate value in the array "+maxDuplicateValue);

        //Another way to do
        Integer maxOccuredElement = Arrays.stream(elements).boxed().collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting())).entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(Integer.MAX_VALUE);
        System.out.println("maxOccuredElement: "+maxOccuredElement);

    }

    private static void checkStringIsAnagram() {
        String s = "abcd";
        String s1 = "dabc";

        String firstString = Stream.of(s.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        String secondString = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

        boolean isAnagram = firstString.equals(secondString);
        System.out.println(s+" and "+s1+" is Anagram : "+isAnagram);
    }

    private static void fibonacciSeries() {
        List<Integer> fibonacciSeries = Stream.iterate(new int[]{0, 1}, array -> new int[]{array[1], array[0] + array[1]})
                .map(arrayElement -> arrayElement[0])
                .limit(10)
                .collect(Collectors.toList());
        System.out.println("fibonacciSeries : "+fibonacciSeries);

        //another way
        Function<int[], List<Integer>> intArraytoListOFInt = array -> Arrays.stream(array).boxed()
                .collect(Collectors.toList());
        List<Integer> collect = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(intArraytoListOFInt)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("fibonacci using another way : "+collect);
    }

    private static void findDuplicateElementsFromList() {
        Set<String> set = new HashSet<>();
        List<String> stringList = Arrays.asList("Rehan", "Akash", "Rehan", "Jitendra", "Akash");
        List<String> duplucateElements = stringList.stream().filter(str -> !set.add(str)).collect(Collectors.toList());
        System.out.println("duplicate element list: "+duplucateElements);
    }

    private static void findStringsWhichStartsWithNumber() {
        List<String> stringList = Arrays.asList("Rehan", "Varun", "9Vistara", "2Kajol");
        List<String> stringStartWithNumber = stringList.stream().filter(str -> Character.isDigit(str.charAt(0))).collect(Collectors.toList());
        System.out.println("strings which starts with number: "+stringStartWithNumber);
    }

    private static void reverseEachWordOfString() {
        String s = "Rehan is a good man";
        String reversedString = Arrays.stream(s.split(" ")).map(word -> new StringBuffer(word).reverse()).collect(Collectors.joining(" "));
        System.out.println("reverse each word of string : "+reversedString);
    }

    private static void findCommonElementsInTwoList() {
        List<Integer> integerList1 = Arrays.asList(4, 6, 1, 2, 4, 7);
        List<Integer> integerList2 = Arrays.asList(56, 2, 5, 9, 60, 4, 1);
        List<Integer> commonElementsInTwoList = integerList1.stream().filter(integerList2::contains).collect(Collectors.toList());
        System.out.println(commonElementsInTwoList);
    }

    private static void findSecondLargestIntegerInList() {
        List<Integer> integerList = Arrays.asList(2, 4, 5, 6, 7, 13, 10, 14, 16, 32);
        Integer secondLargestNumber = integerList.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("secondLargestNumber : "+secondLargestNumber);
    }

    private static void sumOfAllDigitsOfNumber() {
        Integer number = 1594;
        Integer sumOfAllDigitOfNumber = Stream.of(String.valueOf(number).split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println("sumOfAllDigitOfNumber : "+sumOfAllDigitOfNumber);
    }

    private static void maximumAndMinimumNumberInList() {
        List<Integer> integerList = Arrays.asList(2, 4, 5, 1, 7, 8, 11, 98, 37, 13);
        Integer maximumNumber = integerList.stream().max(Comparator.naturalOrder()).get();
        System.out.println("max number in list "+maximumNumber);

        Integer minNumber = integerList.stream().min(Comparator.naturalOrder()).get();
        System.out.println("minimum number in a List : "+minNumber);
    }

    private static void joinStringListWithPrefixSuffixAndDelimitter() {
        List<String> stringList = Arrays.asList("Rehan", "Aftaab", "John", "Tom", "Senorita");

        String joineString = stringList.stream().collect(Collectors.joining("-", "{ ", " }"));
        System.out.println(joineString);
    }

    private static void findLongestStringInList() {
        List<String> stringList = Arrays.asList("Rehan", "Aftaab", "John", "Tom", "Senorita");
        String longestString = stringList.stream().reduce((a, b) -> a.length() > b.length() ? a : b).get();
        System.out.println(longestString);
    }

    private static void frequencyOfEachElementInStringAndNumber() {
        List<Integer> integerList = Arrays.asList(2, 4, 5, 6, 7, 8, 9, 10, 1, 3, 4, 4, 6, 2);
        Map<Integer, Long> numbersWithTheirFrequency = integerList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(numbersWithTheirFrequency);

        String str = "Hello Java 8";
        Map<Character, Long> charWithTheirCount = str.chars().mapToObj(c -> Character.toLowerCase((char) c)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charWithTheirCount);

        //another way to find character frequency
        Map<String, Long> charWithTheirFrequency = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("chars in string with their frequency : "+charWithTheirFrequency);

        //another way using collectingAndThen
        /*Map<String, List<String>> stringListMap = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity()));
        System.out.println("testing stringListMap with grouping by : "+stringListMap);*/
        Map<String, Integer> charWithFrequencyUsingCollectingAndThen = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
        System.out.println("chars frequency using collecting and then method : "+charWithFrequencyUsingCollectingAndThen);

    }

    private static void removeDuplicateFromList() {
        List<Integer> integerList = Arrays.asList(1, 3, 2, 1, 1, 5, 2, 4, 9);
        List<Integer> numbersWihtoutDuplicate = integerList.stream().distinct().collect(Collectors.toList());
        System.out.println(numbersWihtoutDuplicate);
    }

    private static void findLastElementOfList() {
        List<Integer> integerList = Arrays.asList(2, 4, 6, 2, 8, 45, 3);
        Integer lastElement = integerList.stream().skip(integerList.size() - 1).findFirst().get();
        System.out.println(lastElement);
    }

    private static void reversedIntegerArray() {
        int[] firstArray = new int[]{2,34,8,1,2,9,117};
        int[] secondArray = new int[]{5,1,3,0,1,4,14,10};
        int[] mergedArray= IntStream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).sorted().toArray();

        int[] reverserdIntArray = IntStream.rangeClosed(1, mergedArray.length)
                .map(i -> mergedArray[mergedArray.length - i]).toArray();

        Arrays.stream(reverserdIntArray).forEach(arrayElement-> System.out.print(arrayElement+" "));
    }

    private static void checkGivenStringAndNumberIsPalindrome() {
        // Palindrome number exapmle : 545, 151, 34543, 343, 171, 48984
        //Palindrome String exapmle: "abba", "RACEcar",
        String str = "abba";
        String str1 = "RACEcar";
        boolean isPalindrome = IntStream.range(0, str.length() / 2).noneMatch(x -> str.charAt(x) != str.charAt(str.length() - x - 1));
        System.out.println(str+" is palindrome : "+isPalindrome);

        boolean isStr1Palimdrome = IntStream.range(0, str1.length() / 2).noneMatch(y -> Character.toUpperCase(str1.charAt(y)) != Character.toUpperCase(str1.charAt(str1.length() - y - 1)));
        System.out.println(str1+" is palindrome : "+isStr1Palimdrome);

        Integer palindromeNumber = 151;
        String palindromeNumberString = palindromeNumber.toString();
        boolean isNumberPalindrome = IntStream.range(0, palindromeNumberString.length() / 2).noneMatch(n -> palindromeNumberString.charAt(n) != palindromeNumberString.charAt(palindromeNumberString.length() - n - 1));
        System.out.println(palindromeNumber+" is palindrome : "+isNumberPalindrome);
    }

    private static void sumAndAverageOfArrayElements() {
        int[] firstArray = new int[]{2,34,8,1,2,9,117};
        int[] secondArray = new int[]{5,1,3,0,1,4,14,10};
        int[] mergedTwoUnsortedArrayIntoSingleSortedArray = IntStream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).sorted().toArray();

        int sumOfElements = Arrays.stream(mergedTwoUnsortedArrayIntoSingleSortedArray).sum();
        System.out.println(sumOfElements);
        double averageOfElements = Arrays.stream(mergedTwoUnsortedArrayIntoSingleSortedArray).average().getAsDouble();
        System.out.println(averageOfElements);
    }

    private static void printListOfStringInIncreasingOrderOfTheirLenght() {
        List<String> stringList = Arrays.asList("Rehan", "John", "Monika", "Abraham", "Senorita", "Julie");
        stringList.stream().sorted(Comparator.comparing(String::length)).forEach(str-> System.out.print(str+" "));
    }

    private static void mergedTwoUnsortedArrayIntoSingleArrayWithoutDuplicate() {
        int[] firstArray = new int[]{2,34,8,1,2,9,117};
        int[] secondArray = new int[]{5,1,3,0,1,4,14,10};

        int[] mergedTwoUnsortedArraysToSingleSortedArrayWithoutDuplicate = IntStream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).sorted().distinct().toArray();
        Arrays.stream(mergedTwoUnsortedArraysToSingleSortedArrayWithoutDuplicate).forEach(arrayElemt-> System.out.print(arrayElemt+" "));
    }

    private static void mergedTwoUnsortedArraysIntoSingleSortedArray() {
        int[] firstArray = new int[]{2,34,8,1,2,9,117};
        int[] secondArray = new int[]{5,1,3,0,1,4,14,10};
        int[] mergedTwoUnsortedArrayIntoSingleSortedArray = IntStream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).sorted().toArray();
        //to print above array result used below line
        Arrays.stream(mergedTwoUnsortedArrayIntoSingleSortedArray).forEach(arrayElemt-> System.out.print(arrayElemt+" "));
    }

    private static void printThreeMaxAndMinNumbers() {
        List<Integer> numbers = Arrays.asList(2, 6, 1, 8, 16, 33, 7, 53);
        List<Integer> maxThree = numbers.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
        System.out.println(maxThree);

        List<Integer> minThree = numbers.stream().sorted().limit(3).collect(Collectors.toList());
        System.out.println(minThree);
    }

    private static void printMultipleOfFiveFromList() {
        List<Integer> multplerOfFive = IntStream.range(1, 20).boxed().filter(i -> i % 5 == 0).collect(Collectors.toList());
        System.out.println(multplerOfFive);
    }

    private static void sortNamesInReverseOrder() {
        List<String> names = Arrays.asList("Akash", "Zebra", "Pankaj", "John", "Ponta", "Julie");
        List<String> sortedInReverseOrder = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("sortNamesInReverseOrder: "+sortedInReverseOrder);
    }

    private static void collectorMappingExample(List<BlogPost> blogPosts) {
        Map<BlogPostType, Optional<Integer>> collectorsMappingFunction = blogPosts.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.mapping(BlogPost::getLikes, Collectors.maxBy(Integer::compareTo))));
        System.out.println("collectorMappingExample : "+collectorsMappingFunction);
    }

    private static void aggregateMultipleAttributeOfGroupedResult(List<BlogPost> blogPosts) {
        Map<BlogPostType, List<BlogPost>> blogPostTypeListMap = blogPosts.stream().collect(Collectors.groupingBy(BlogPost::getType));
        System.out.println("testing purpose printing blogPost with groupingBy : "+blogPostTypeListMap);
        Map<BlogPostType, PostCountTitlesLikesStats> blogPostTypePostCountTitlesLikesStatsMap = blogPosts.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.collectingAndThen(Collectors.toList(), list -> {
            long titleCount = list.stream().map(BlogPost::getTitle).count();
            String titleList = list.stream().map(BlogPost::getTitle).collect(Collectors.joining(" : "));
            IntSummaryStatistics likesSummaryStatistics = list.stream().collect(Collectors.summarizingInt(BlogPost::getLikes));
            return new PostCountTitlesLikesStats(titleCount, titleList, likesSummaryStatistics);
        })));
        System.out.println(blogPostTypePostCountTitlesLikesStatsMap);
    }

    private static void getMaxFromGroupedResult(List<BlogPost> blogPosts) {
        Map<BlogPostType, Optional<BlogPost>> blogPostTypeOptionalMap = blogPosts.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.maxBy(Comparator.comparingInt(BlogPost::getLikes))));
        System.out.println(blogPostTypeOptionalMap);
    }

    private static void sumOfGroupedResultLikes(List<BlogPost> blogPosts) {
        Map<BlogPostType, Integer> blogPostTypeSum = blogPosts.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.summingInt(BlogPost::getLikes)));
        System.out.println(blogPostTypeSum);
    }

    private static void summeryOfAttributeOfGroupedResult(List<BlogPost> blogPosts) {
        Map<BlogPostType, IntSummaryStatistics> blogPostTypeIntSummaryStatisticsMap = blogPosts.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.summarizingInt(BlogPost::getLikes)));
        System.out.println(blogPostTypeIntSummaryStatisticsMap);
    }

    private static void averageFromGroupedResult(List<BlogPost> blogPosts) {
        Map<BlogPostType, Double> blogPostTypeAvgerage = blogPosts.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.averagingInt(BlogPost::getLikes)));
        System.out.println(blogPostTypeAvgerage);
    }

    private static void groupingByMultipleFields(List<BlogPost> blogPosts) {
        Map<String, Map<BlogPostType, List<BlogPost>>> firstGroupByAuthorAndThenByType = blogPosts.stream().collect(Collectors.groupingBy(BlogPost::getAuthor, Collectors.groupingBy(BlogPost::getType)));
        System.out.println("groupingByMultipleFields : "+firstGroupByAuthorAndThenByType);
    }

    private static void modifyingGroupingByReturnedMapValueType(List<BlogPost> blogPosts) {
        Map<BlogPostType, Set<BlogPost>> blogPostTypeSetMap = blogPosts.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.toSet()));
        System.out.println(blogPostTypeSetMap);
    }

    private static void groupingByComplexMapKey(List<BlogPost> blogPosts) {
        Map<Tuple, List<BlogPost>> tupleListMap = blogPosts.stream().collect(Collectors.groupingBy(blogPost -> new Tuple(blogPost.getType(), blogPost.getAuthor())));
        System.out.println(tupleListMap);
    }

    private static void groupingBySingleColumn(List<BlogPost> blogPosts) {
        Map<BlogPostType, List<BlogPost>> blogPostTypeListMap = blogPosts.stream().collect(Collectors.groupingBy(BlogPost::getType));
        System.out.println(blogPostTypeListMap);
    }

    private static List<BlogPost> getBlogPostsList() {
        List<BlogPost> blogPosts = Arrays.asList(new BlogPost("IT", "Java", BlogPostType.NEWS, 10),
                new BlogPost("ECOM", "business", BlogPostType.GUIDE, 17),
                new BlogPost("Automobile", "Car", BlogPostType.NEWS, 2));
        return blogPosts;
    }

    private static List<BlogPost> getBlogPostsListWithSameLikes() {
        List<BlogPost> blogPosts = Arrays.asList(new BlogPost("IT", "Java", BlogPostType.NEWS, 10),
                new BlogPost("ECOM", "business", BlogPostType.GUIDE, 17),
                new BlogPost("Automobile", "Car", BlogPostType.NEWS, 2),
                new BlogPost("Physics", "Java", BlogPostType.NEWS, 10),
                new BlogPost("Chemistry", "business", BlogPostType.GUIDE, 10),
                new BlogPost("Biologic", "Car", BlogPostType.NEWS, 2));
        return blogPosts;
    }

    private static void frequencyOfEachCharacterInString() {
        //frequency of each character in String
        String inputString = "My name is Rehan";
        Map<Character, Long> frequencyOfEachCharacterInString = inputString.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(frequencyOfEachCharacterInString);
    }

    private static void seperateOddAndEvenNumbers() {
        Map<Boolean, List<Integer>> seperateOddAndEven = IntStream.range(1, 15).boxed().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println(seperateOddAndEven);
    }

    private static boolean isPrime(int num){
       return  IntStream.rangeClosed(2, num/2).noneMatch(i -> num%i ==0);
    }
}
