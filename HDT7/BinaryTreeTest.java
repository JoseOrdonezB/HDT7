import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

// Import statements to include necessary JUnit Assert methods and annotations.

// Define a test class BinaryTreeTest to test the BinaryTree class functionality.
public class BinaryTreeTest {

    // Test method to verify the insertion operation in the binary tree.
    @Test
    public void testInsert() {
        // Create a new instance of BinaryTree with String keys and values.
        BinaryTree<String, String, String> tree = new BinaryTree<>();

        // Create a new Association representing "house" with values "casa" and "loger".
        Association<String, String, String> association = new Association<>("house", "casa", "loger");

        // Insert the association into the binary tree.
        tree.insert(association);

        // Verify if the insertion was successful:
        // 1. Check if the root of the tree is not null.
        assertNotNull(tree.root);
        // 2. Check if the association inserted matches the association stored in the root node.
        assertEquals(association, tree.root.association);
    }

    // Test method to verify searching for a found association in the binary tree.
    @Test
    public void testSearchFound() {
        // Create a new instance of BinaryTree with String keys and values.
        BinaryTree<String, String, String> tree = new BinaryTree<>();

        // Create a new Association representing "house" with values "casa" and "loger".
        Association<String, String, String> association = new Association<>("house", "casa", "loger");

        // Insert the association into the binary tree.
        tree.insert(association);

        // Search for an existing association with key "house".
        Node<String, String, String> result = tree.search(tree.root, "house");

        // Verify if the search was successful:
        // 1. Check if the result is not null, indicating that the association was found.
        assertNotNull(result);
        // 2. Check if the association found matches the association inserted.
        assertEquals(association, result.association);
    }

    // Test method to verify searching for a not found association in the binary tree.
    @Test
    public void testSearchNotFound() {
        // Create a new instance of BinaryTree with String keys and values.
        BinaryTree<String, String, String> tree = new BinaryTree<>();

        // Create a new Association representing "house" with values "casa" and "loger".
        Association<String, String, String> association = new Association<>("house", "casa", "loger");

        // Insert the association into the binary tree.
        tree.insert(association);

        // Search for an association with key "dog", which does not exist in the tree.
        Node<String, String, String> result = tree.search(tree.root, "dog");

        // Verify that the search did not find the association:
        // Check if the result is null, indicating that the association was not found.
        assertNull(result);
    }
}
