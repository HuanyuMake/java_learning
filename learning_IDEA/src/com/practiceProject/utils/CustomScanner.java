package com.practiceProject.utils;

import java.util.Scanner;

public class CustomScanner {

    private Scanner scanner;

    public CustomScanner(Readable o) {
        scanner = new Scanner(o);
    }

    public CustomScanner() {
        scanner = new Scanner(System.in);
    }

    public char readChar() {
        return scanner.next().charAt(0);
    }
}
