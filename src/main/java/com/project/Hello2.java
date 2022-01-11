package com.project;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Hello2 {
    public static void main(String[] args) {
        Console console = System.console();
        String username = console.readLine("username:");
        char[] pwd = console.readPassword("password:");
    }
}
