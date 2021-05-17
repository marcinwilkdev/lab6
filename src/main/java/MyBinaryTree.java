public class MyBinaryTree<T> {
    TreeNode<T> root;

    private class TreeNode<R> {
        private TreeNode<R> left;
        private R value;
        private TreeNode<R> right;

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
