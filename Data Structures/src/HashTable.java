public abstract class HashTable<K,V> {
    protected class Node {
        K key;
        V value;
    }

    public abstract V search(K key);

    public abstract void insert(K key, V value);

    public abstract void delete(K key);

}
