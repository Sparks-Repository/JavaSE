## equals方法
#### ==和equals的对比
1.==是一个比较运算符
* ==:既可以判断基本类型，又可以判断引用类型
* ==:如果判断基本类型，判断的是 **值是否相等** ——> int i =10;double d = 10.0; i == d (true)
* ==:如果判断引用类型，判断的是 **地址是否相等**,即判定是不是同一个对象
2.Object类中的equals方法只能判断引用类型，默认判断的是地址是否相等，子类中往往重写该方法，用于判断内容是否相等。比如Integer判断值是否相等，String重写的equals方法用于判断内容是否相等
```java
/*
        判断两个Person对象的内容是否相等，如果两个Person对象的各个属性值都一样，则返回true，否则返回false
 */
public boolean equals(Object obj){
    // 1.首先利用Object中的equals方法判断两个对象是否是同一个对象，如果是同一个对象，那么值肯定相等，直接返回true
    if(this == obj){
        return true;
    }
    // 2.类型判断，
    if(obj instanceof Person){
       // 进行向下转型，用于获取obj的 各个属性
        Person p = (Person)obj;
        // 比较所有属性是否相等
        return this.name.equals(p.name) && this.age == p.age && this.gender == p.gender;
    }else {
        //如果传进来的参数不是Person类型，那么肯定不相等，直接返回false
        return false;
    }
}
```
## hashCode方法
hashCode用于返回对象的哈希码值
#### 小结
两个引用，如果指向的是同一个对象，则哈希值肯定是一样的
两个引用，如果指向的是不同对象，则哈希值是不一样的
哈希值主要根据地址号来的(地址号经过计算),不能完全将哈希值等价于地址
## toString方法
