package com.example.cxh.kotlinstudy.kotlin.kt14_in_kotlin_u_java.java;

import java.util.ArrayList;


public class SAMInJava {

    private ArrayList<Runnable> runnables = new ArrayList<>();

    public void addTask(Runnable runnable){
        runnables.add(runnable);
        System.out.println("After add: " + runnable + ", we have " + runnables.size() + " in all.");
    }

    public void removeTask(Runnable runnable){
        runnables.remove(runnable);
        System.out.println("After remove: " + runnable + ", only " + runnables.size() + " left.");
    }

}
