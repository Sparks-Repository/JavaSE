package com.microsoft.javabase.poly;

public class PolyTest {
    public static void main(String[] args) {

        // animal的编译类型是 Animal，
        // 运行类型是 Dog
        Animal animal = new Dog();
        // 当程序编译完成，开始运行，执行到这一行(第10行)时，animal的运行类型是 Dog，所以cry就是Dog中的cry()
        animal.cry();

        // 此时，animal的编译类型还是Animal，但是运行类型变成了 Cat
        animal = new Cat();
        animal.cry();
    }
}
