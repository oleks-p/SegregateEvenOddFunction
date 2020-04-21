package com.test;

import java.util.Scanner;

import static com.test.Node.addLast;
import static com.test.Node.printList;
import static com.test.SegregateEvenOddFunction.segregateEvenOdd;

public class Main {

    /**
     * The first line contains an integer n, the number of nodes to be inserted.
     * The n subsequent lines each contain an integer describing the value of a node being inserted at the list's tail.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node<Integer> linkedListHead = null;
        while (n-- > 0) {
            int value = sc.nextInt();
            linkedListHead = addLast(linkedListHead, value);
        }

        System.out.println("List from input:");
        printList(linkedListHead);
        Node<Integer>[] linkedLists = segregateEvenOdd(linkedListHead);

        System.out.println("Odd elements:");
        printList(linkedLists[0]);
        System.out.println("Even elements:");
        printList(linkedLists[1]);
    }
}
