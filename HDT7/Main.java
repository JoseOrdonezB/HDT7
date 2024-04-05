import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Main class to handle translation using binary trees.
public class Main {
    // Three binary trees for English-Spanish, English-French, and French-English translations.
    static BinaryTree<String, String, String> engToSpa = new BinaryTree<>();
    static BinaryTree<String, String, String> engToFra = new BinaryTree<>();
    static BinaryTree<String, String, String> fraToEng = new BinaryTree<>();

    // Main method to load dictionary, display translations, and prompt user for input.
    public static void main(String[] args) {
        // Load the dictionary from file.
        loadDictionary("diccionario.txt");

        // Display English-Spanish translations.
        System.out.println("Diccionario Inglés-Español:");
        engToSpa.inorderTraversal(engToSpa.root);

        // Display English-French translations.
        System.out.println("\n\nDiccionario Inglés-Francés:");
        engToFra.inorderTraversal(engToFra.root);

        // Prompt the user for a phrase to translate.
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nIngrese una frase:");
        String input = scanner.nextLine();

        // Prompt the user to choose the target language.
        System.out.println("\n¿A qué idioma desea traducir la frase? (Español/Francés)");
        String language = scanner.nextLine().toLowerCase();

        // Translate the input phrase based on the chosen language.
        if (language.equals("español")) {
            translateToSpanish(input);
        } else if (language.equals("francés")) {
            translateToFrench(input);
        } else {
            System.out.println("Idioma no reconocido.");
        }
    }

    // Method to load dictionary from file and populate binary trees.
    static void loadDictionary(String filename) {
        try {
            // Open the dictionary file.
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            // Read each line and split into key, value1, and value2.
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                // Check if the line has the expected format.
                if (line.length >= 3) {
                    // Create Association objects and insert into binary trees.
                    Association<String, String, String> association = new Association<>(line[0], line[1], line[2]);
                    engToSpa.insert(association);
                    engToFra.insert(new Association<>(line[0], line[2], line[1]));
                    fraToEng.insert(new Association<>(line[2], line[0], line[1]));
                } else {
                    // Print a warning if the line doesn't have the expected format.
                    System.out.println(
                            "La línea del diccionario no tiene el formato esperado: " + String.join(",", line));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            // Handle the case where the dictionary file is not found.
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }
    }

    // Method to translate input phrase to Spanish.
    static void translateToSpanish(String input) {
        String[] words = input.split("\\s+");
        for (String word : words) {
            // Find translation in the English-Spanish binary tree.
            String translation = findTranslation(engToSpa, word);
            System.out.print(translation + " ");
        }
    }

    // Method to translate input phrase to French.
    static void translateToFrench(String input) {
        String[] words = input.split("\\s+");
        for (String word : words) {
            // Find translation in the English-French binary tree.
            String translation = findTranslation(engToFra, word);
            System.out.print(translation + " ");
        }
    }

    // Method to find translation of a word in the specified binary tree.
    static String findTranslation(BinaryTree<String, String, String> tree, String word) {
        // Search for the word in the binary tree.
        Node<String, String, String> node = search(tree.root, word.toLowerCase());
        if (node != null) {
            // If word is found, return its translation.
            return node.association.value1;
        } else {
            // If word is not found, return with asterisks as indication.
            return "*" + word + "*";
        }
    }

    // Method to search for a word in the binary tree.
    static Node<String, String, String> search(Node<String, String, String> root, String key) {
        // If root is null or matches the search key, return the root.
        if (root == null || root.association.key.equalsIgnoreCase(key)) {
            return root;
        }

        // Compare search key with root key to determine traversal direction.
        int cmp = key.compareToIgnoreCase(root.association.key);
        if (cmp < 0) {
            // If search key is less, search in the left subtree.
            return search(root.left, key);
        } else {
            // If search key is greater, search in the right subtree.
            return search(root.right, key);
        }
    }
}
