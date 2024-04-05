// Define a generic Node class with three type parameters:
// K for the key, V1 for the first value, and V2 for the second value.
class Node<K, V1, V2> {
    // Declare fields to hold an association and references to left and right child nodes.
    Association<K, V1, V2> association;
    Node<K, V1, V2> left, right;

    // Constructor to initialize a Node with the given association.
    public Node(Association<K, V1, V2> association) {
        // Set the association and initialize left and right child nodes to null.
        this.association = association;
        left = right = null;
    }
}
