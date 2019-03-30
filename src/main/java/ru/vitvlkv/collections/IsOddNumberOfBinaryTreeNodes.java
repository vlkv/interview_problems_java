package ru.vitvlkv.collections;

/** https://careercup.com/question?id=5637620793606144
 * How to find if a Binary tree has an odd number of nodes without using node count? Binary tree does not have to be balanced
 */
public class IsOddNumberOfBinaryTreeNodes {
    public static <T> boolean isOddNumberOfNodes(Tree<T> t) {
        return t.root.isOdd();
    }

    public static class Node<T> {
        private T value;
        private Node left;
        private Node right;

        public Node(T v) {
            value = v;
        }

        // TODO: we may implement caching of isOdd result, making it "dirty" after each add/remove node
        public boolean isOdd() {
            int lc = left == null ? 0 : left.isOdd() ? 1 : 0;
            int rc = right == null ? 0 : right.isOdd() ? 1 : 0;
            return (lc + rc + 1) % 2 == 1;
        }
    }

    public static class Tree<T> {
        private Node<T> root;

        public void add(T v) {
            if (root == null) {
                root = new Node<>(v);
                return;
            }
            addImpl(root, v);
        }

        private void addImpl(Node<T> r, T v) {
            Comparable<? super T> cmpV = (Comparable<? super T>)v;
            if (cmpV.compareTo(r.value) < 0) {
                if (r.left == null) {
                    r.left = new Node(v);
                    return;
                }
                addImpl(r.left, v);
            } else {
                if (r.right == null) {
                    r.right = new Node(v);
                    return;
                }
                addImpl(r.right, v);
            }
        }
    }

}


