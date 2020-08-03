public class ChainingHashTable<K,V> extends HashTable<K,V> {
    private class LinkedListNode {
        Node value;
        LinkedListNode next;

        public LinkedListNode(Node value) {
            this.value = value;
        }
    }

    private LinkedListNode[] buckets;
    private int LENGTH;

    public ChainingHashTable() {
        buckets = new LinkedListNode[LENGTH];

        for (int i = 0; i < LENGTH; i++) {
            buckets[i] = new LinkedListNode(null);
        }
    }

    @Override
    public V search(K key) {
        return null;
    }

    @Override
    public void insert(K key, V value) {

    }

    @Override
    public void delete(K key) {

    }
}
