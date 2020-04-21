package com.test;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

class Node<T> {

    private final T value;
    private Node<T> next;

    Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public static <T> Node<T> addFirst(Node<T> head, T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        return newNode;
    }

    public static <T> Node<T> addLast(Node<T> head, T value) {
        if (head == null) {
            return new Node<>(value);
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(value);
            return head;
        }
    }

    public static <T> void printList(Node<T> head) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
        printList(head, outputStreamWriter);
    }

    public static <T> void printList(Node<T> head, Writer writer) {
        Node<T> current = head;
        try {
            while (current != null) {
                writer.write(String.format("%s ", current.value));
                current = current.next;
            }
            writer.write(System.lineSeparator());
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Unable to print list", e);
        }
    }
}
