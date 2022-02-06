import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class MyHashMap {

    private int size;
    private int deletedCount;
    private int count;
    private Node[] table;
    private final float loadFactor = (float) 0.6;
    private final int minFator = 3;
    private Node deletedNode = new Node(-1, -1, -1);

    public MyHashMap() {
        this.size = 10;
        table = new Node[this.size];
        this.count = 0;
        this.deletedCount = 0;
    }

    public int hashCode(int key) {
        return key % this.size;
    }

    public int getEntry(int key) {
        int hashKey = this.hashCode(key);
        int rootIdx = hashKey;

        for(int i=0; i<this.size; i++) {
            int newIdx = (rootIdx + i) % this.size;
            Node node = this.table[newIdx];
            if(node == null || (!node.equals(this.deletedNode) && node.hashKey == hashKey && node.key == key)) {
                return newIdx;
            }
        }

        return 0;
    }

    public void resize() {
        Node[] oldTable = this.table;
        this.size *= this.minFator;
        this.table = new Node[this.size];
        this.count = 0;

        for(Node node: oldTable) {
            if(node != null && !node.equals(this.deletedNode)) {
                this.put(node.key, node.value);
            }
        }
    }

    public void put(int key, int value) {
        int newIdx = this.getEntry(key);
        Node node = this.table[newIdx];

        if(node == null) this.count += 1;
        this.table[newIdx] = new Node(key, this.hashCode(key), value);

        if((float)((this.deletedCount + this.count) / this.size) >= this.loadFactor) {
            this.resize();
        }
    }

    public int get(int key) {
        int newIdx = this.getEntry(key);
        Node node = this.table[newIdx];
        if(node == null) return -1;
        else return node.value;
    }

    public void remove(int key) {
        int newIdx = this.getEntry(key);
        Node node = this.table[newIdx];
        if(node != null && !node.equals(this.deletedNode)) {
            this.table[newIdx] = new Node(-1, -1, -1);
            this.count -= 1;
            this.deletedCount += 1;
        }
    }
}

class Node {
    int key;
    int hashKey;
    int value;

    public Node(int key, int hashKey, int value) {
        this.key = key;
        this.hashKey = hashKey;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return key == node.key && hashKey == node.hashKey && value == node.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, hashKey, value);
    }
}