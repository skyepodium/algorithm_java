import java.util.ArrayList;
import java.util.List;

class MyHashMap {

    private int size;
    private Node[] table;
    private final float loadFactor = (float) 0.6;
    private int count;

    public MyHashMap() {
        this.size = 1000;
        table = new Node[this.size];
        this.count = 0;
    }

    public void resize() {
        List<Node> prevElements = this.getAllElements();
        this.size *= 2;
        this.table = new Node[this.size];
        this.count = 0;
        prevElements.forEach(x -> this.put(x.key, x.value));
    }

    public List<Node> getAllElements() {
        List<Node> res = new ArrayList<>();
        for(Node node: this.table) {
            while(node != null) {
                res.add(new Node(node.key, node.value));
                node = node.next;
            }
        }
        return res;
    }

    public int hashCode(int key) {
        return key % this.size;
    }

    public void put(int key, int value) {
        int h = hashCode(key);

        Node node = this.table[h];

        if (node == null) {
            this.count += 1;
            this.table[h] = new Node(key, value);
        } else {
            Node prev = null;

            while(node != null) {
                if(node.key == key) {
                    node.value = value;
                    break;
                }

                prev = node;
                node = node.next;
            }

            if(node == null) {
                this.count += 1;
                prev.next = new Node(key, value);
            }
        }
        if((float)(this.count / this.size) >= this.loadFactor) {
            this.resize();
        }
    }

    public int get(int key) {
        int h = hashCode(key);
        int res = -1;
        Node node = this.table[h];

        while(node != null) {
            if(node.key == key) {
                res = node.value;
                break;
            }

            node = node.next;
        }

        return res;
    }

    public void remove(int key) {
        int h = hashCode(key);
        Node node = this.table[h];
        Node prev = null;

        while(node != null) {
            if(node.key == key) {
                this.count -= 1;
                if(prev == null) {
                    this.table[h] = node.next;
                } else if(node.next == null) {
                    prev.next = null;
                } else {
                    prev.next = node.next;
                }
            }

            prev = node;
            node = node.next;
        }
    }
}

class Node {
    int key;
    int value;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}