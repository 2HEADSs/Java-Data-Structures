package implementations;

import interfaces.AbstractTree;

import java.util.*;

public class Tree<E> implements AbstractTree<E> {
    private E value;
    private Tree<E> parent;
    private List<Tree<E>> children;

    public Tree(E value, Tree<E>... subtrees) {
        this.value = value;
        this.parent = null;
        this.children = new ArrayList<>();

        for (Tree<E> subtree : subtrees) {
            this.children.add(subtree);
            subtree.parent = this;
        }
    }

    @Override
    public List<E> orderBfs() {
        List<E> result = new ArrayList<>();
//        if (this.value == null) {
//            return result;
//        }
        Deque<Tree<E>> childrenQueue = new ArrayDeque<>();
        childrenQueue.offer(this);

        while (!childrenQueue.isEmpty()) {
            Tree<E> current = childrenQueue.poll();

            result.add(current.value);

            for (Tree<E> child : current.children) {
                childrenQueue.offer(child);
            }
        }
        return result;
    }

    @Override
    public List<E> orderDfs() {
        List<E> result = new ArrayList<>();

        this.doDfs(this, result);

        return result;
    }

    private void doDfs(Tree<E> node, List<E> result) {
        for (Tree<E> child : node.children) {
            this.doDfs(child, result);
        }
        result.add(node.value);
    }

    @Override
    public void addChild(E parentKey, Tree<E> child) {
        Tree<E> search = find(parentKey);

        if (search == null) {
            throw new IllegalArgumentException();
        }

        search.children.add(child);
        child.parent = search;

    }


    @Override
    public void removeNode(E nodeKey) {

        Tree<E> toRemove = find(nodeKey);
        if (toRemove == null) {
            throw new IllegalArgumentException();
        }

        for (Tree<E> child : toRemove.children) {
            child.parent = null;
        }
        toRemove.children.clear();
        Tree<E> parent = toRemove.parent;
        if (parent != null) {
            parent.children.remove(toRemove);
        }
    }

    @Override
    public void swap(E firstKey, E secondKey) {

    }

    private Tree<E> find(E parentKey) {
        Deque<Tree<E>> childrenQueue = new ArrayDeque<>();
        childrenQueue.offer(this);

        while (!childrenQueue.isEmpty()) {
            Tree<E> current = childrenQueue.poll();

            if (current.value.equals(parentKey)) {
                return current;
            }

            for (Tree<E> child : current.children) {
                childrenQueue.offer(child);
            }
        }
        return null;
    }
}



