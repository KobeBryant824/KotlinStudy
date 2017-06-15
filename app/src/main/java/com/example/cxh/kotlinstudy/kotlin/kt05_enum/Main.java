package com.example.cxh.kotlinstudy.kotlin.kt05_enum;


public class Main {
    public static void main(String... args) {
        Lang lang = Lang.JAPANESE;

        String bye;
        switch (lang){
            case ENGLISH:
                bye = "Bye";
                break;
            case CHINESE:
                bye = "再见";
                break;
            case JAPANESE:
                bye = "さようなら";
                break;
            case KOREAN:
                bye = "안녕히가세요";
                break;
            default:
                bye = "Bye";
        }
        System.out.println(bye);
    }
}
