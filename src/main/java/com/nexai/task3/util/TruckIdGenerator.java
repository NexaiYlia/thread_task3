package com.nexai.task3.util;

public class TruckIdGenerator {
    private static int id = 0;

    private TruckIdGenerator() {
    }

    public static int generate() {
        return ++id;
    }
}

