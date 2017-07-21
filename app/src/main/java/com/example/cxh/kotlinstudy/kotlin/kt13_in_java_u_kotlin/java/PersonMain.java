package com.example.cxh.kotlinstudy.kotlin.kt13_in_java_u_kotlin.java;

import com.example.cxh.kotlinstudy.kotlin.kt13_in_java_u_kotlin.kotlin.Person;

/**
 * @author Hai (haigod7[at]gmail[dot]com)
 *         2017/7/20
 */
public class PersonMain {
    public static void main(String... args) {
        Person person = new Person("kobe", 28);
        System.out.println(person);
        System.out.println(person.getName()+person.age);
        person.setName("bryant");
        person.age = 38;
        System.out.println(person);
    }
}
