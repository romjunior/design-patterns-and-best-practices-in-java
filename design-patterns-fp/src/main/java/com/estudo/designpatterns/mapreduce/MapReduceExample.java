package com.estudo.designpatterns.mapreduce;

import java.util.ArrayList;
import java.util.List;

public class MapReduceExample {

    public static void main(String... args) {
        List<Employee> peoples = new ArrayList<>();
        peoples.add(new Employee(101, "Victor", 23));
        peoples.add(new Employee(102, "Rick", 21));
        peoples.add(new Employee(103, "Sam", 25));
        peoples.add(new Employee(104, "John", 27));
        peoples.add(new Employee(105, "Grover", 23));
        peoples.add(new Employee(106, "Adam", 22));
        peoples.add(new Employee(107, "Samy", 224));
        peoples.add(new Employee(108, "Duke", 29));

        peoples.parallelStream()
                .mapToInt(Employee::getAge)
                .average()
                .ifPresent(System.out::println);

    }
}
