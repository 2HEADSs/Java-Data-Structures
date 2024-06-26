package implementations;

import interfaces.AbstractQueue;

import java.util.Iterator;

public class Queue<E> implements AbstractQueue<E> {

    private Node<E> head;
    private int size;

    public class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
            this.next = null;
        }
    }

    public Queue() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void offer(E element) {
        Node<E> newElement = new Node<E>(element);
        if (this.isEmpty()) {
            this.head = newElement;
        } else {
            Node<E> current = this.head;

            while (current.next != null) {
                current = current.next;
            }
            current.next = newElement;
        }

        this.size++;
    }

    @Override
    public E poll() {
        hasElements();
        Node<E> first = this.head;
        this.head = first.next;
        this.size--;

        return first.value;
    }

    @Override
    public E peek() {
        hasElements();
        return this.head.value;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E value = current.value;
                current = current.next;
                return value;
            }
        };
    }


    private void hasElements() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
    }
}
