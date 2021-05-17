public class MyBinaryTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public void insert(T value) {
        if (root == null) {
            root = new TreeNode<>(value);
            return;
        }

        TreeNode<T> currentNode = root;

        do {
            if (currentNode.value.compareTo(value) < 0) {
                if (currentNode.right == null) {
                    currentNode.right = new TreeNode<>(value);
                } else {
                    currentNode = currentNode.right;
                }
            }
            else if (currentNode.value.compareTo(value) > 0) {
                if (currentNode.left == null) {
                    currentNode.left = new TreeNode<>(value);
                } else {
                    currentNode = currentNode.left;
                }
            }
        } while (currentNode.value.compareTo(value) != 0);
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    public class TreeNode<R extends Comparable<R>> {
        private TreeNode<R> left;
        private R value;
        private TreeNode<R> right;

        public TreeNode(R value) {
            this.value = value;
        }

        public TreeNode<R> getLeft() {
            return left;
        }

        public void setLeft(TreeNode<R> left) {
            this.left = left;
        }

        public R getValue() {
            return value;
        }

        public void setValue(R value) {
            this.value = value;
        }

        public TreeNode<R> getRight() {
            return right;
        }

        public void setRight(TreeNode<R> right) {
            this.right = right;
        }
    }
}
