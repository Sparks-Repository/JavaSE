package com.microsoft.javabase.override;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/*
1.编写一个Person类，包括属性/private (name、age)，构造器、方法say(返回自我介绍的字符串)。
2.编写一个Student类，继承Person类，增加id、score属性/private，以及构造器，定义say方法(返回自我介绍的信息)。
3.在main中，分别创建Person和Student对象，调用say方法输出自我介绍。
 */
public class OverrideExercise {
    public static void main(String[] args) {
        Person person = new Person("Tom",44);
        System.out.println(person.say());
        Student student = new Student("Jack",16,22,87);
        System.out.println(student.say());
    }


}
// Person类
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String say(){
        return "my name is " + name + " and age is " + age;
    }

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//    public void setAge(int age) {
//        this.age = age;
//    }
//    public int getAge() {
//        return age;
//    }
}

// Student类
class Student extends Person{
    private int id;
    private int score;

    public  Student(String name, int age,int id, int score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }
    public String say(){
        return super.say() + " id = " + id + ", score = " + score;
    }
}
