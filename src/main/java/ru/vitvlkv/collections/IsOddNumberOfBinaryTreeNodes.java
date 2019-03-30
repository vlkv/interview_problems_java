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
            Node<T> r = findSubRootFor(root, v);
            Comparable<? super T> cmpV = (Comparable<? super T>)v;
            if (cmpV.compareTo(r.value) < 0) {
                r.left = new Node(v);
            } else {
                r.right = new Node(v);
            }
        }

        public Node<T> findSubRootFor(Node<T> r, T v) {
            Comparable<? super T> cmpV = (Comparable<? super T>)v;
            if (cmpV.compareTo(r.value) < 0) {
                if (r.left == null) {
                    return r;
                }
                return findSubRootFor(r.left, v);
            } else {
                if (r.right == null) {
                    return r;
                }
                return findSubRootFor(r.right, v);
            }
        }
    }

}


