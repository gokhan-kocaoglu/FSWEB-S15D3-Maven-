package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();

        employees.add(new Employee(1, "Ann", "Smith"));
        employees.add(new Employee(2, "Bob", "Jones"));
        employees.add(new Employee(3, "Carol", "White"));
        employees.add(new Employee(2, "Robert", "Jones"));
        employees.add(new Employee(1, "Anne", "Smith"));
        employees.add(new Employee(4, "David", "Black"));

        System.out.println("Original List:");
        employees.forEach(System.out::println);

        List<Employee> duplicates = findDuplicates(employees);
        System.out.println("\nDuplicates:");
        duplicates.forEach(System.out::println);

        Map<Integer, Employee> uniques = findUniques(employees);
        System.out.println("\nUniques (as Map):");
        uniques.values().forEach(System.out::println);

        List<Employee> singleEntries = removeDuplicates(employees);
        System.out.println("\nOnly single entries (all duplicates removed):");
        singleEntries.forEach(System.out::println);


        System.out.println("*****************************");

        Map<String, Integer> counts = WordCounter.calculateWord();

        counts.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    public static List<Employee> findDuplicates(List<Employee> list) {

        Map<Integer, Integer> countMap = new HashMap<>();
        List<Employee> result = new LinkedList<>();
        if (list == null) return result;

        for (Employee e : list) {
            if (e == null) continue;
            countMap.put(e.getId(), countMap.getOrDefault(e.getId(), 0) + 1);
        }
        Set<Integer> added = new HashSet<>();
        for (Employee e : list) {
            if (e == null) continue;
            if (countMap.get(e.getId()) > 1 && added.add(e.getId())) {
                result.add(e);
            }
        }
        return result;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Employee> uniqueMap = new HashMap<>();
        if (list == null) return uniqueMap;

        for (Employee e : list) {
            if (e == null) continue;
            countMap.put(e.getId(), countMap.getOrDefault(e.getId(), 0) + 1);
            uniqueMap.put(e.getId(), e);
        }
        return uniqueMap;
    }


    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Integer, Integer> countMap = new HashMap<>();
        if (list == null) return new LinkedList<>();
        for (Employee e : list) {
            if (e == null) continue;
            countMap.put(e.getId(), countMap.getOrDefault(e.getId(), 0) + 1);
        }
        List<Employee> result = new LinkedList<>();
        Set<Integer> added = new HashSet<>();
        for (Employee e : list) {
            if (e == null) continue;
            if (countMap.get(e.getId()) == 1 && added.add(e.getId())) {
                result.add(e);
            }
        }
        return result;
    }
}