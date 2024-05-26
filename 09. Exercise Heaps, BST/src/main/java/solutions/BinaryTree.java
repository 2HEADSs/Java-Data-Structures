package solutions;

import java.util.List;

public class BinaryTree {
    private int value;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTree(int key, BinaryTree first, BinaryTree second) {
        this.value = key;
        this.left = first;
        this.right = second;
    }

    public Integer findLowestCommonAncestor(int first, int second) {
        List<Integer> firstPath = findPath(this, first);
        List<Integer> secondPath = findPath(this, second);

        int smallerSize = Math.min(firstPath.size(), secondPath.size());

        int i = 0;
        for (; i < smallerSize; i++) {
            if (!firstPath.get(i).equals(secondPath.get(i))) {
                break;
            }
        }
        
        return firstPath.get(i - 1);
    }

    public List<Integer> topView() {
        return null;
    }
}
