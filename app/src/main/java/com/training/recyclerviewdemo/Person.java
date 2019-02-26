package com.training.recyclerviewdemo;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private int age;
    private String gender;

    private List<Person> personList = new ArrayList<>();

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static List<Person> getPersonsList() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Anthony Jones", 22, "M"));
        persons.add(new Person("Anthony Jones", 22, "M"));
        persons.add(new Person("Anthony Jones", 22, "M"));
        persons.add(new Person("Anthony Jones", 22, "M"));
        persons.add(new Person("Anthony Jones", 22, "M"));
        persons.add(new Person("Anthony Jones", 22, "M"));

        return persons;
    }
}
