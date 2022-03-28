package com.nexai.task3.util;

public class TerminalIdGenerator {
    private static int id = 0;

    private TerminalIdGenerator() {
    }

    public static int generate() {
        return ++id;
    }
}
