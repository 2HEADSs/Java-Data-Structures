package implementations;

import interfaces.LinkedList;
import org.apache.tools.ant.taskdefs.Nice;

import java.awt.*;
import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {

    Node<E> head;
    private int size;

    private static class Node<E> {
        private E value;
        private Node<E> next;

        private Node(E element) {
            this.value = element;
            this.next = null;
        }
    }

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void addFirst(E element) {
        Node<E> temp = new Node<>(element);
        temp.next = this.head;
        this.head = temp;

        this.size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> last = new Node<>(element);
        if (isEmpty()) {
            last.next = this.head;
            this.head = last;
        } else {
            Node<E> current = this.head;
            while (current.next !=null){
                current = current.next;
            }
            current.next = last;
        }
        this.size++;
    }

    @Override
    public E removeFirst() {
        if(isEmpty()){
            throw new IllegalStateException();
        }
        E value = this.head.value;
        this.head = this.head.next;
        this.size--;
        return value;
    }

    @Override
    public E removeLast() {

        if(isEmpty()){
            throw new IllegalStateException();
        }
        if(this.size ==1){
            E value = this.head.value;
            this.head = null;
            this.size--;
            return value;
        }

        Node<E> previous = this.head;
        Node<E> last = this.head;
        while (last.next !=null){
            previous = last;
            last = previous.next;
        }
        previous.next = null;
        this.size--;
        return last.value;
    }

    @Override
    public E getFirst() {

        if(isEmpty()){
            throw new IllegalStateException();
        }
        return this.head.value;
    }

    @Override
    public E getLast() {
        Node<E> last = this.head;
        while (last.next !=null){
            last = last.next;
        }
        return last.value;
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
        return null;
    }
}
