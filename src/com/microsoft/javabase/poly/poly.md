## 多态的具体体现
### 1.方法的多态

#### 方法重载的多态
```java
// 通过不同的参数个数调用sum方法，就会调用不同的方法，
// 因此对sum方法来说，就是多种状态的体现
System.out.println(a.sum(10,20));
System.out.println(a.sum(10,20,50));
```
#### 方法重写的多态
```java
public static void main(String[] args) {
    A a = new A();
    B =b = new B();
    // A,B都有say方法，但会各自调用，
    // 方法重写体现多态
    a.say();
    b.say();
}
class A{
    public void say(){
        System.out.println("我是父类");
    }
}
class B extends A{
    public void say(){
        System.out.println("我是子类");
    }
}
```
### 2.对象的多态(核心，困难，重点)
* 一个对象的编译类型和运行类型可以不一致
* 编译类型在定义对象时，就确定了，不能改变
* 运行类型是可以变化的
* 编译类型看定义时 =号的 左边，运行类型看 = 号的 右边
```java
// animal的编译类型是Animal，运行类型是Dog（第一条）
// 父类的引用，指向了子类对象（父类 new子类）
Animal animal = new Dog();
// 此时，animal的运行类型变成了Cat，编译类型仍然是Animal（第二条，第三条）
// 个人理解编译类型一旦定义不可改变：定义一个引用就像一个人的出生一样，
// 一个人一旦出生，其父母一定是确定的，并且永远无法改变，
// 编译类型就是如此，一个引用一旦被创建，就无法改变编译类型
animal = new Cat();
```
## 多态注意事项和细节
#### 多态的向上转型
1. 本质：父类的引用指向了子类的对象
2. 语法：父类类型 引用名 = new 子类类型();
3. 特点： 编译类型看左边，运行类型看右边.
   可以调用父类中的所有成员（需遵守访问权限）
   **不能调用子类中特有成员**(原因：因为在编译阶段，能调用哪些成员，是由编译类型来决定的，只能调用编译类型中声明的方法和属性。
   如果调用的方法或属性不属于 编译类型的成员，编译就会报错。)
   **最终运行效果看子类的具体实现**
4. 特别注意：一个向上转型的引用，在调用一个父类中不存在的方法时，编译不会通过，
   因为该引用的编译类型是父类，在编译时，发现父类不存在该方法，就会编译不通过，不管子类有没有该方法
#### 多态的向下转型
1. 语法：子类类型  引用名 =  (子类类型) 父类引用；
2. 只能强转父类的引用，不能强转父类的对象
3. 要求父类的引用必须指向的是当前目标类型的对象
4. 当向下转型后，可以调用子类类型中所有的成员
```java
/*
    animal是父类引用，父类引用指向了子类对象Cat()，在代码编译过程中，Animal是编译类型，Cat是运行类型
    在编译时，编译器的行为：只能调用编译类型中声明的方法和属性。如果调用的方法或属性不属于 Animal，编译就会报错。
    在运行时，调用的成员一定是在父类编译类型范围内的，所以子类中特殊成员是无法调用的。    
 */
Animal animal = new Cat();
/*
     为此需要进行向下转型，向下转型个人理解：
     向下转型（强制转换）是指将一个父类类型的引用临时“伪装”成子类类型，从而允许它访问子类特有的成员和方法，同时仍然保留对父类成员的访问。这种“欺骗”编译器的行为使得编译器认为这个引用可以操作子类的特有方法。
     向下转型的前提是父类引用实际指向的对象必须是子类类型
     编译时检查： 检查 animal 的编译时类型和 (Cat) 是否存在继承关系。如果没有关系，编译直接报错。
     运行时检查： 在运行时，JVM 会检查 animal 的实际运行类型是否是 Cat 或其子类。如果实际类型不匹配，会抛出 ClassCastException。
     
     具体解释：
父类引用指向子类对象：

animal 是 Animal 类型的引用，实际指向的是一个 Cat 对象。
在这种情况下，animal 可以在编译器的视角下访问所有 Animal 类型的成员方法，同时因为 animal 指向了 Cat 对象，还可以在运行时调用 Cat 特有的方法，如 meow()。
强制转换的作用：

强制转换 (Cat) animal 使得编译器认为 animal 可以直接访问 Cat 的特有成员。
虽然 animal 的编译类型仍然是 Animal，但经过强制转换后，它可以访问 Cat 特有的属性和方法，同时仍然拥有 Animal 类型的所有权限。
这就是“伪装”：编译器临时将 animal 视为 Cat，允许访问 Cat 的特有方法。
 */
Cat cat = (cat)animal;
```
#### 属性的多态
属性没有重写，属性的值看编译类型，与方法调用不一样
```java
public static void main(String[] args) {
   Base base = new Sub();
   // base的编译类型是Base，所以调用Base中的count属性
   base.count;
}
class Base {
    int count = 10;
}
class Sub extends Base{
    int count = 20;
}
```
#### instanceOf 比较操作符
用于判断对象的**运行类型**是否为XX类型或XX类型的子类
```java
public static void main(String[] args) {
   // 父类new子类
   A a = new B();
   System.out.println(a instanceof B); // true
   System.out.println(a instanceof A); // true
}
class A {}
class B extends A{}
```
#### java的动态绑定机制（非常非常非常重要）
1.当调用对象方法时，该方法会和该对象的内存地址/运行类型绑定
2.当调用对象属性时，没有动态绑定机制，哪里声明，哪里调用
```java
public static void main(String[] args) {
   A a = new B();
   // a的编译类型是A，运行类型是B
   // a.sum()会现在B中找sum方法，
   // B中没有sum方法，所以会去父类A中找，有sum方法，
   // 在sum方法中调用了i这个属性，在哪个类声明就在哪个类调用，所以是返回当前类中的i，即调用A的i
   // 并且sum()调用了getI()方法
   // 由于动态绑定机制，调用的对象方法已经和该对象的运行类型绑定了，
   // 所以不会调用A中的getI()方法，而是调用B中的getI()方法
   System.out.println(a.sum());
}
class A{
    public int i = 20;
    public int sum(){
        return i + getI();
    }
    public int getI(){
        return i;
    }
}
class B extends A {
    public int i = 10;

//    public int sum() {
//        return i + getI();
//    }

    public int getI() {
        return i;
    }
}
```
## 多态的应用
#### 多态数组
```java
public static void main(String[] args) {
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
// 数组的定义类型为父类类型，里面保存的实际元素类型为子类类型
// 有一个继承结构如下：要求创建1个Person对象、2个Student对象、2个Teacher对象，统一放在数组中，并调用say()方法
class Person{
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
    public String say(){
        return "My name is " + name + " and I am " + age + " years old.";
    }
}

// Student类
class Student extends Person{
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
class Teacher extends Person{
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
```
#### 多态参数
