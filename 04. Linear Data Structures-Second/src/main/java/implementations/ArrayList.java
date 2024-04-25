package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    private static final int INITIAL_SIZE = 4;
    private int size = 0;
    private Object[] elements;

    public ArrayList() {
        this.elements = new Object[INITIAL_SIZE];
        this.size = 0;
    }


    @Override
    public boolean add(E element) {
        if (this.size == this.elements.length) {
            grown();
        }
        this.elements[this.size++] = element;

        return true;
    }


    @Override
    public boolean add(int index, E element) {
        if (index < this.size && index >= 0) {
            shiftRight(index);
            this.elements[index] = element;
            this.size++;
            return true;
        }

        return false;
    }


    @Override
    public E get(int index) {
        if (index < this.size && index >= 0) {
            return (E) this.elements[index];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public E set(int index, E element) {
        if (index < this.size && index >= 0) {
            Object element1 = this.elements[index];
            this.elements[index] = element;
            return (E) element1;
        }
        return null;
    }

    @Override
    public E remove(int index) {
        if (index < this.size && index >= 0) {
            Object element1 = this.elements[index];
            shiftLeft(index);
            this.size--;
            return (E) element1;
        }
        throw new IndexOutOfBoundsException();
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(E element) {
        int index = -1;
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
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

    private void grown() {
        Object[] temp = new Object[this.size * 2];
        for (int i = 0; i < this.elements.length; i++) {
            temp[i] = this.elements[i];
        }
        this.elements = temp;
    }

    private void shiftLeft(int index) {

        for (int i = index; i < this.size; i++) {
            this.elements[i] = this.elements[i + 1];
        }
    }

    private void shiftRight(int index) {
        for (int i = this.size - 1; i >= index; i--) {
            this.elements[i + 1] = this.elements[i];
        }
    }
}
