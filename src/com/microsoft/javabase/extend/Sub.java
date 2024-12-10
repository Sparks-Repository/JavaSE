package com.microsoft.javabase.extend;

public class Sub extends Parent {
//    public Sub(){
//        super();
//        System.out.println("Sub Constructor");
//    }
//    public Sub(String name, int age){
//        super(name,age);
//    }
//    public void B(){
//        super.A();
//    }

    // 当创建子类对象时，不管使用子类的哪个构造器，默认情况下总会去调用父类的无参构造器，
//    public Sub(){
//        System.out.println("子类的无参构造器被调用。。。。。。");
//    }
//
//    //如果父类没有提供无参构造器，则必须在子类的构造器中用super去指向使用父类的哪个构造器完成对父类的初始化工作，
//   // super只能在构造器中使用
//    // super和this都只能放在构造器的第一行，所以构造器要么只有super要么只有this
//    public Sub(String name){
//        super(name);
//        System.out.println("子类的name构造器被调用");
//    }
//    public void sayOk(){
//        n1();
//        n2();
//        n4();
////        n3()
////        System.out.println(n1() + " " + n2() + " " + n4());
//    }
    public Sub(){
        this("sub");
        System.out.println("sub");
    }
    Sub(String name){
        System.out.println("sub name");
    }

}
 