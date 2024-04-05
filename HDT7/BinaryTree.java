// Define a generic BinaryTree class with three type parameters:
// K for the key, which must be comparable,
// V1 for the first value, and V2 for the second value.
class BinaryTree<K extends Comparable<K>, V1, V2> {
    // Define a Node class to represent nodes in the binary tree.
    // The Node class has three fields: key, value1, and value2.
    static class Node<K, V1, V2> {
        K key;
        V1 value1;
        V2 value2;
        Node<K, V1, V2> left;
        Node<K, V1, V2> right;

        // Constructor to initialize Node with key and associated values.
        Node(K key, V1 value1, V2 value2) {
            this.key = key;
            this.value1 = value1;
            this.value2 = value2;
            this.left = null;
            this.right = null;
        }
    }

    // Define the root node of the binary tree.
    Node<K, V1, V2> root;

    // Constructor to initialize an empty binary tree.
    public BinaryTree() {
        root = null;
    }

    // Method to insert a new association (key, value1, value2) into the binary tree.
    void insert(Association<K, V1, V2> association) {
        // Call the recursive insert method starting from the root.
        root = insertRec(root, association);
    }

    // Recursive method to insert a new association into the binary tree.
    Node<K, V1, V2> insertRec(Node<K, V1, V2> root, Association<K, V1, V2> association) {
        // If the root is null, create a new node with the given association and return it.
        if (root == null) {
            root = new Node<>(association.key, association.value1, association.value2);
            return root;
        }

        // Compare the key of the association with the key of the current root node.
        // Based on the comparison result, recursively insert the association into the left or right subtree.
        if (association.key.compareTo(root.key) < 0)
            root.left = insertRec(root.left, association);
        else if (association.key.compareTo(root.key) > 0)
            root.right = insertRec(root.right, association);

        return root;
    }

    // Method to perform an inorder traversal of the binary tree.
    void inorderTraversal(Node<K, V1, V2> root) {
        // If the root is not null, recursively traverse the left subtree,
        // print the key and associated values, and then traverse the right subtree.
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print("(" + root.key + ", " + root.value1 + ", " + root.value2 + ") ");
            inorderTraversal(root.right);
        }
    }
}
