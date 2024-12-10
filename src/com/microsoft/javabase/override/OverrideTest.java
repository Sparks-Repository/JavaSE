package com.microsoft.javabase.override;

public class OverrideTest {
    public static void main(String[] args) {
        Sub sub = new Sub();
        System.out.println(sub.m1());
        System.out.println(sub.m2());
    }
}
class Parent{
    public Object m1(){
        return "I am parent";
    }
    protected String m2(){
        return "This is a protected function";
    }
}

class Sub extends Parent{
    // 确保子类的返回类型与父类相同，或者是父类返回类型的子类
    public String m1(){
        return "I am sub";
    }

    // 子类方法不能缩小父类的访问权限
    // public > protected > default > private
    public String m2(){
        return "This is a public function";
    }
}
