package implementations;

import interfaces.AbstractStack;

import java.util.Iterator;

public class Stack<E> implements AbstractStack<E> {
    private Node<E> top;
    private int size;

    private static class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
        }
    }

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(E element) {
        Node<E> newTop = new Node<>(element);
        newTop.next = this.top;
        this.top = newTop;
        this.size++;
    }

    @Override
    public E pop() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }

        Node<E> currentTop = this.top;
        this.top = currentTop.next;
        this.size--;
        return currentTop.value;
    }

    @Override
    public E peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }

        return this.top.value;
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
            private Node<E> current = top;
            @Override
            public boolean hasNext() {
                return this.current != null;
            }

            @Override
            public E next() {
                E value = this.current.value;
                current = this.current.next;
                return value;
            }
        };
    }
}
