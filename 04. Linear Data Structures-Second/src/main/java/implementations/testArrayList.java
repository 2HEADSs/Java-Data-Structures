package implementations;

import interfaces.List;

import java.util.Iterator;

public class testArrayList<E> implements List<E> {
    private static final int INITIAL_SIZE = 4;
    private Object[] elements;
    private int size;
    private int capacity;

    public testArrayList() {
        elements = new Object[INITIAL_SIZE];
        this.size = 0;
        this.capacity = INITIAL_SIZE;
    }

    @Override
    public boolean add(E element) {
        if (this.size == this.elements.length) {
            grow();
        }
        this.elements[this.size++] = element;
        return true;
    }


    @Override
    public boolean add(int index, E element) {
        if (!validIndex(index)) {
            return false;
        }
        shiftRight(index);
        this.elements[index] = element;
        this.size++;
        return true;
    }


    @Override
    public E get(int index) {
        if (!validIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        return (E) this.elements[index];
    }

    @Override
    public E set(int index, E element) {
        if (!validIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        Object existing = this.elements[index];
        this.elements[index] = element;
        return (E) existing;
    }

    @Override
    public E remove(int index) {
        if (!validIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        Object existing = this.elements[index];
        shiftLeft(index);
        this.size--;
        return (E) existing;
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < this.size; i++) {
            if (element.equals(this.elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        return this.indexOf(element) != -1;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    private void grow() {
        int newLength = this.elements.length * 2;
        Object[] tmp = new Object[newLength];
        for (int i = 0; i < this.elements.length; i++) {
            tmp[i] = this.elements[i];
        }
        this.elements = tmp;
    }

    private void shiftRight(int index) {
        for (int i = this.size - 1; i >= index; i--) {
            int nextPlace = i + 1;
            this.elements[nextPlace] = this.elements[i];
        }
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
    }

    private boolean validIndex(int index) {
        return index >= 0 && index < this.size;
    }
}
