package com.microsoft.javabase.poly;

public class PersonTest {
    public static void main(String[] args) {
        // 多态的应用——多态数组
        // 数组的定义类型为父类类型，里面保存的实际元素类型为子类类型
        // 有一个继承结构如下：要求创建1个Person对象、2个Student对象、2个Teacher对象，统一放在数组中，并调用say()方法
        // 创建Person数组用于存放Person、Student、Teacher实例
        Person[] persons = new Person[5];
        persons[0] = new Person("Jack",44);
        persons[1] = new Student("Jack",14,88);
        persons[2] = new Student("Jack",15,90);
        persons[3] = new Teacher("Jack",26,2000);
        persons[4] = new Teacher("Jack",47,4000);

        // for循环遍历persons数组
        for (int i = 0; i < persons.length; i++) {
//            System.out.println(persons[i].say());

            // 添加学生，老师的特殊方法后，实现各自方法输出
            // 判断persons[i]运行类型是不是Student,如果是，则强制转换为student引用
            // 向下转型
            if(persons[i] instanceof Student){
                ((Student) ((Student) persons[i])).study();

            } else if (persons[i] instanceof Teacher) { // 同理，判断是否为Teacher
                ((Teacher) persons[i]).teach();
            }else {
                System.out.println(persons[i].say());
            }
        }
    }

}
    class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
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

        public String say() {
            return "My name is " + name + " and I am " + age + " years old.";
        }
    }

    // Student类
class Student extends Person {
    private int score;
    public Student(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }
    public String say(){
        return super.say() + " " + " score "+ score ;
    }
    // Student中的特殊方法
    public void study(){
        System.out.println("学生 " + getName() + " 正在学Java....");
    }
}

// Teacher类
class Teacher extends Person {
    private double salary;
    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }
    public String say(){
        return super.say() + " " + " salary "+ salary ;
    }

    // Teacher中的特殊方法
    public void teach(){
        System.out.println("老师 " + getName() + " 正在教Java...");
    }
}
