// Define a generic Association class with three type parameters:
// K for the key, V1 for the first value, and V2 for the second value.
class Association<K, V1, V2> {
    // Declare three fields: key, value1, and value2 to hold the association data.
    K key;
    V1 value1;
    V2 value2;

    // Constructor to initialize an Association object with the given key, value1, and value2.
    public Association(K key, V1 value1, V2 value2) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
    }
}
