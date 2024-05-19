package implementations;

import interfaces.AbstractBinarySearchTree;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {
    private Node<E> root;
    private Node<E> leftChild;
    private Node<E> rightChild;

    @Override
    public void insert(E element) {
        Node<E> newNode = new Node<>(element);
        if (this.getRoot() == null) {
            this.root = newNode;
        }
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        return null;
    }

    @Override
    public Node<E> getRoot() {
        return null;
    }

    @Override
    public Node<E> getLeft() {
        return this.leftChild;
    }

    @Override
    public Node<E> getRight() {
        return this.rightChild;
    }

    @Override
    public E getValue() {
        return this.root.value;
    }
}
