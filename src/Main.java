class MyHashMap {

    private int size;
    private Node[] table;

    public MyHashMap() {
        this.size = 1000;
        table = new Node[1000];
    }

    public int getIdx(int key) {
        return key % this.size;
    }

    public void put(int key, int value) {
        int idx = getIdx(key);

        Node node = this.table[idx];

        if (node == null) {
            this.table[idx] = new Node(key, value);
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

            if(node == null) prev.next = new Node(key, value);
        }
    }

    public int get(int key) {
        int idx = getIdx(key);
        int res = -1;
        Node node = this.table[idx];

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
        int idx = getIdx(key);
        Node node = this.table[idx];
        Node prev = null;

        while(node != null) {
            if(node.key == key) {
                if(prev == null) {
                    this.table[idx] = node.next;
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