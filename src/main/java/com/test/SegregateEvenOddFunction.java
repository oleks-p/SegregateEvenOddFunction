package com.test;

public class SegregateEvenOddFunction {

    public static Node<Integer>[] segregateEvenOdd(Node<Integer> linkedListHead) {
        Node<Integer> oddListHead = null;
        Node<Integer> evenListHead = null;

        Node<Integer> current = linkedListHead;
        while (current != null) {
            Integer value = current.getValue();
            if (value % 2 != 0) {
                oddListHead = Node.addFirst(oddListHead, value);
            } else {
                evenListHead = Node.addFirst(evenListHead, value);
            }
            current = current.getNext();
        }
        return new Node[]{oddListHead, evenListHead};
    }
}
