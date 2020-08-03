import java.util.ArrayList;

public class ChainingHashTable<K,V> extends HashTable<K,V> {
    private class LinkedListNode {
        Node value;
        LinkedListNode next;

        public LinkedListNode(Node value) {
            this.value = value;
        }
    }

    private ArrayList<LinkedListNode> buckets;
    private int LENGTH;

    public ChainingHashTable() {
        buckets = new ArrayList<>(LENGTH);

        for (int i = 0; i < LENGTH; i++) {
            buckets.set(i, new LinkedListNode(null));
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
