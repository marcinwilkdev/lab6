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
        } while (!currentNode.value.equals(value));
    }

    public boolean search(T value) {
        TreeNode<T> currentNode = root;

        while (currentNode != null) {
            if (currentNode.value.equals(value)) return true;

            if (currentNode.value.compareTo(value) < 0) currentNode = currentNode.right;
            else currentNode = currentNode.left;
        }

        return false;
    }

    public void delete(T value) {
        TreeNode<T> beforeNode = null;
        boolean isRight = false;

        TreeNode<T> currentNode = root;

        while (currentNode != null) {
            // Behaviour if we found our value in the tree
            if (currentNode.value.equals(value)) {
                int siblingsNotNull = 0;

                // Calculating how many siblings of current node are not null
                siblingsNotNull += (currentNode.left != null) ? 1 : 0;
                siblingsNotNull += (currentNode.right != null) ? 1 : 0;

                // Connecting left sibling in place of deleted node and connecting
                // right sibling at the end of the right path of the left sibling
                if (siblingsNotNull == 2) {
                    TreeNode<T> nodeToAdd = currentNode.right;

                    deleteTreeReconnect(isRight, beforeNode, currentNode.left);

                    currentNode = currentNode.left;

                    while (currentNode.right != null) currentNode = currentNode.right;

                    currentNode.right = nodeToAdd;
                }
                // Connecting not null sibling in place of deleted node
                else if (siblingsNotNull == 1) {
                    if (currentNode.right != null) {
                        deleteTreeReconnect(isRight, beforeNode, currentNode.right);
                    } else {
                        deleteTreeReconnect(isRight, beforeNode, currentNode.left);
                    }
                }
                // Setting deleted node to null
                else {
                    deleteTreeReconnect(isRight, beforeNode, null);
                }

                return;
            }

            // Climbing down the tree and storing information about last node
            // which is needed in complicated deleting process

            beforeNode = currentNode;

            if (currentNode.value.compareTo(value) < 0){
                isRight = true;
                currentNode = currentNode.right;
            }
            else {
                isRight = false;
                currentNode = currentNode.left;
            }
        }
    }

    private void deleteTreeReconnect(boolean isRight, TreeNode<T> beforeNode, TreeNode<T> nodeToConnect) {
        if (beforeNode != null) {
            if (isRight) {
                beforeNode.right = nodeToConnect;
            } else {
                beforeNode.left = nodeToConnect;
            }
        } else {
            root = nodeToConnect;
        }
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
