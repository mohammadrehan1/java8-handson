package com.example.java_8_coding_questions.mapvsflatmap;

import com.example.java_8_coding_questions.model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MapVsFlatmapTest {

    public static void main(String[] args) {

        List<String> citiesWorkedIn = new ArrayList<>();
        citiesWorkedIn.add("Pune");
        citiesWorkedIn.add("Mumbai");
        citiesWorkedIn.add("Noida");
        citiesWorkedIn.add("Banglore");

        Employee e1 = new Employee(1, "Code", citiesWorkedIn);

        List<String> citiesWorkedIn1 = new ArrayList<>();
        citiesWorkedIn1.add("Pune");
        citiesWorkedIn1.add("Nagpur");
        citiesWorkedIn1.add("Indore");
        citiesWorkedIn1.add("Banglore");

        Employee e2 = new Employee(2, "Decode", citiesWorkedIn1);

        List<String> citiesWorkedIn2 = new ArrayList<>();
        citiesWorkedIn2.add("Pune");
        citiesWorkedIn2.add("Banglore");

        Employee e3 = new Employee(3, "Encrypt", citiesWorkedIn2);



        List<Employee> employeeList = Arrays.asList(e1, e2, e3);

        System.out.println(employeeList);


        List<String> stringList = employeeList.stream().map(e -> e.getName()).toList();
        System.out.println(stringList);

        Set<String> citiesWorkedInList = employeeList.stream().flatMap(e -> e.getCitiesWorkedIn().stream()).collect(Collectors.toSet());
        System.out.println(citiesWorkedInList);
        Set<String> citiesWorkedInList1 = employeeList.stream().flatMap(e -> e.getCitiesWorkedIn().stream().filter(cities -> cities.startsWith("P"))).collect(Collectors.toSet());
        System.out.println(citiesWorkedInList1);
    }
}
