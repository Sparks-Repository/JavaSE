package com.microsoft.javabase.extend;

public class ExtendsExercise {
    public static void main(String[] args) {
        PC pc = new PC("12700H","16GB","256GB","HP");
        pc.printInfo();

//        NotePad notePad = new NotePad();

    }
}
class Computer {
    private String CPU;
    private String Memory;
    private String SSD;

//    public Computer(){
//
//    }
    public Computer(String CPU, String Memory, String SSD) {
        setCPU(CPU);
        setMemory(Memory);
        setSSD(SSD);
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getMemory() {
        return Memory;
    }

    public void setMemory(String memory) {
        Memory = memory;
    }

    public String getSSD() {
        return SSD;
    }

    public void setSSD(String SSD) {
        this.SSD = SSD;
    }

    public String getDetails(){
        return "CPU: " + CPU + ", Memory: " + Memory + ", SSD: " + SSD;
    }
}

class PC extends Computer {
    private String brand;
    public PC(String CPU, String Memory, String SSD, String brand) {
        super(CPU, Memory, SSD);
        this.brand = brand;
    }
    public void printInfo(){
        System.out.println(getDetails() + ", brand: " + brand);
    }
}
class NotePad extends Computer {
    public NotePad(String CPU, String Memory, String SSD, String color) {
        super(CPU, Memory, SSD);
        this.color = color;
    }
    private String color;
}