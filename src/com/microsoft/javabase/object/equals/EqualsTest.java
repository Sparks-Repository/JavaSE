package com.microsoft.javabase.object.equals;

public class EqualsTest {
    public static void main(String[] args){
        Person tom = new Person("jack", 12, '女');
        Person jack = new Person("jack",12,'女');
        System.out.println(tom.equals(jack));

    }
}
class Person{
    private String name;
    private int age;
    private char gender;
    public Person(String name,int age, char gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public boolean equals(Person person){
        return this.name.equals(person.name) && this.age == person.age && this.gender == person.gender;
    }
}
