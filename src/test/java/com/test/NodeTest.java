package com.test;

import java.io.StringWriter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class NodeTest {

    @Test
    public void getValue() {
        Integer value = 3;
        Node<Integer> node = new Node<>(value);
        assertEquals(value, node.getValue());
    }

    @Test
    public void getNext_isNull() {
        Node<Integer> node = new Node<>(3);
        assertNull(node.getNext());
    }

    @Test
    public void getNext_notNull() {
        Node<Integer> node = new Node<>(3);
        node = Node.addLast(node, 5);
        assertNotNull(node.getNext());
    }

    @Test
    public void addFirst_first() {
        Integer value = 3;
        Node<Integer> node = Node.addFirst(null, value);
        assertEquals(value, node.getValue());
        assertNull(node.getNext());
    }

    @Test
    public void addFirst_other() {
        Node<Integer> head = new Node<>(3);
        Node<Integer> node = Node.addFirst(head, 5);
        assertNotSame(head, node);
    }

    @Test
    public void addLast() {
        Integer value = 3;
        Node<Integer> node = Node.addLast(null, value);
        assertEquals(value, node.getValue());
        assertNull(node.getNext());
    }

    @Test
    public void addLast_other() {
        Node<Integer> head = new Node<>(3);
        Node<Integer> node = Node.addLast(head, 5);
        assertSame(head, node);
    }

    @Test
    public void printList() {
        Node<Integer> head = new Node<>(1);
        Node.addLast(head, 2);
        Node.addLast(head, 3);
        StringWriter writer = new StringWriter();
        Node.printList(head, writer);
        assertEquals("1 2 3 \n", writer.toString());
    }
}