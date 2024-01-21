package com.coding.test.basic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Linkedlistcreateservice {

    @Test
    public void linkedListCreateWithPrevious() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.append(100);
        linkedList.append(200);
        linkedList.append(300);
        linkedList.append(400);
        linkedList.append(500);
        linkedList.append(600);
        System.out.println("22");
    }

    public class DoublyNode {
        public int value;
        public DoublyNode prev;
        public DoublyNode next;

        public DoublyNode(int value, DoublyNode prev, DoublyNode next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public class DoublyLinkedList {
        private DoublyNode head;
        private DoublyNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void append(int value) {
            DoublyNode newNode = new DoublyNode(value, null, null);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        public int get(int idx) {
            DoublyNode current = head;
            for (int i = 0; i < idx; i++) {
                current = current.next;
            }
            return current.value;
        }

        public void insertAt(int idx, int value) {
            DoublyNode newNode = new DoublyNode(value, null, null);
            if (idx == 0) {
                newNode.next = head;
                if (head != null) {
                    head.prev = newNode;
                }
                head = newNode;
            } else {
                DoublyNode current = head;
                for (int i = 0; i < idx; i++) {
                    current = current.next;
                }
                newNode.next = current;
                newNode.prev = current.prev;
                if (current.prev != null) {
                    current.prev.next = newNode;
                }
                current.prev = newNode;
            }
        }

        public void removeAt(int idx) {
            if (idx == 0) {
                if (head != null) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                }
            } else {
                DoublyNode current = head;
                for (int i = 0; i < idx; i++) {
                    current = current.next;
                }
                if (current.next == null) {
                    if (current.prev != null) {
                        current.prev.next = null;
                    }
                } else {
                    if (current.prev != null) {
                        current.prev.next = current.next;
                    }
                    current.next.prev = current.prev;
                }
            }
        }

        public void printAll() {
            DoublyNode current = head;
            while (current != null) {
                System.out.print(current.value);
                current = current.next;
                if (current != null) {
                    System.out.print("->");
                }
            }
            System.out.println();
        }

        public Integer searchNode(int val) {
            int idx = 0;
            if (head == null) {
                return null;
            } else {
                DoublyNode current = head;
                while (current.next != null) {
                    if (current.value == val) {
                        return idx;
                    }
                    current = current.next;
                    idx++;
                }
                return null;
            }
        }

        public int getSize() {
            if (head == null) {
                return 0;
            } else {
                DoublyNode current = head;
                int count = 1;
                while (current.next != null) {
                    current = current.next;
                    count++;
                }
                return count;
            }
        }
    }
}
