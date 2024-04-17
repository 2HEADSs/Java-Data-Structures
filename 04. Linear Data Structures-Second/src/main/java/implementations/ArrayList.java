package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    private Object[] elements;
    private static int size;

    public ArrayList() {
        elements = new Object[4];
        this.size = 0;
    }

    @Override
    public boolean add(E element) {
        if (this.size == this.elements.length) {
            grow();
        }
        this.elements[this.size++] = element;
        return true;
    }

    private void grow() {
        this.elements = new Object[this.size * 2];

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
        return this.elements.length;
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
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
