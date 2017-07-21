package com.example.cxh.kotlinstudy.kotlin.kt14_in_kotlin_u_java.java;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class NullSafetyAbsClass {
    public abstract String formatDate(Date date);

    public @NotNull String formatTime(@NotNull Date date){
        return new SimpleDateFormat("HH:mm:ss").format(date);
    }
}
