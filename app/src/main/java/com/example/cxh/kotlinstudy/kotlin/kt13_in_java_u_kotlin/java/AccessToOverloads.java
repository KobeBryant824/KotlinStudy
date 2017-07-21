package com.example.cxh.kotlinstudy.kotlin.kt13_in_java_u_kotlin.java;

import com.example.cxh.kotlinstudy.kotlin.kt13_in_java_u_kotlin.kotlin.Overloads;

/**
 * @author Hai (haigod7[at]gmail[dot]com)
 *         2017/7/20
 */
public class AccessToOverloads {

    public static void main(String... args) {

        Overloads overloads = new Overloads();
        overloads.overLoads();
        overloads.overLoads(1);
        overloads.overLoads(1, "bryant");
        overloads.overLoads(1, "bryant", true);
    }
}
