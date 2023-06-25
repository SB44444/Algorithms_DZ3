package ru.geekbrains;

import java.util.Scanner;

public class Main {
    private static node root;

    public static void main(String[] args) {
        red_BlackTree node = new red_BlackTree();
        Scanner scan = new Scanner(System.in);
        char ch;
        do {System.out.println("Input int digit and 'Enter'");
            int number = scan.nextInt();
            root = node.add(root, number);
            node.caseR_B(root);
            System.out.println("\nTo add digit press '+' and 'Enter'\nTo exit press any letter sign");
            ch = scan.next().charAt(0);
        } while (ch == '+');
    }
}