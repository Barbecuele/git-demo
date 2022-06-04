package com.bjpowernode.Reflect;

public class Person {
    private String name;
    private int age;

    public  String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String a) {
        this.name = name;
        this.age = age;
        this.a = a;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a='" + a + '\'' +
                '}';
    }

    public void  eat(){
        System.out.println("eat....");
    }

    public void eat(String name){
        System.out.println("eat....." + name);
    }
}
