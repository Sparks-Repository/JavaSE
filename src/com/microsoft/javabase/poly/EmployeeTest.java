package com.microsoft.javabase.poly;


public class EmployeeTest {
    public static void main(String[] args) {
        EmployeeTest test = new EmployeeTest();
        // 向上转型
        Employee employee1 = new OrdinaryEmployee("Jack",2000);
        Employee employee2 = new Manager("Tom",3000,100000);

        System.out.println(test.showEmpAnnal(employee1));
        test.testWork(employee2);
    }
    // 实现获取任何员工对象的年工资，并在main方法中调用
    public double showEmpAnnal(Employee e) {
        return e.getAnnual();
    }
    // 如果是普通员工，则调用work方法，如果是经理，则调用manager方法
    public void testWork(Employee e){
        if(e instanceof OrdinaryEmployee){
            ((OrdinaryEmployee)e).work();
        } else if (e instanceof Manager) {
            ((Manager) e).manager();
        }
    }
}

// Employee员工类
class Employee {
    private String name;
    private double salary;
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }

    // 年薪
    public double getAnnual(){
        return salary * 12;
    }
}

// OrdinaryEmployees普通员工
class OrdinaryEmployee extends Employee {
    public OrdinaryEmployee(String name, double salary) {
        super(name, salary);
    }
    public void work() {
        System.out.println("普通员工正在工作....");
    }
    public double getAnnual(){
        return this.getSalary() * 12;
    }
}
class Manager extends Employee{
    private double bonus;
    public Manager(String name,double salary, double bonus){
        super(name,salary);
        this.bonus = bonus;
    }
    public void manager(){
        System.out.println("经理在工作...");
    }
    public double getAnnual(){
        return this.getSalary() * 12;
    }
}