package com.example.cxh.kotlinstudy.kotlin.kt04_map_flatmap;

/**
 * a_b_c d_e f_g_h_j
 * a b c d e f g h j
 */
public class ConsoleParamInJava2 {
    public static void main(String... args) {
        for (String arg: args){
            String[] splits = arg.split("_");
            for (String split : splits) {
                System.out.print(split);
                System.out.print(" ");
            }
        }
    }
}
