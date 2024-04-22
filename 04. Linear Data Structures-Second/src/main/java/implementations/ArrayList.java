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

        return false;
    }

    private void grown() {
        Object[] temp = new Object[this.size * 2];
        for (int i = 0; i < this.elements.length; i++) {
            temp[i] = this.elements[i];
        }
        this.elements = temp;
    }

    @Override
    public boolean add(int index, E element) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.size > 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
