
class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    private int cap;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();

        // Dummy head and tail
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Move node to front (most recently used)
        deleteNode(node);
        insertNodeAfterHead(node);

        return node.val;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            // Update existing node
            Node node = map.get(key);
            node.val = value;

            deleteNode(node);
            insertNodeAfterHead(node);
            return;
        }

        // Create new node
        Node node = new Node(key, value);

        // If capacity reached, remove LRU
        if (map.size() == cap) {
            Node lru = tail.prev;   // Least recently used
            deleteNode(lru);
            map.remove(lru.key);
        }

        insertNodeAfterHead(node);
        map.put(key, node);
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertNodeAfterHead(Node node) {
        Node next = head.next;

        head.next = node;
        node.prev = head;

        node.next = next;
        next.prev = node;
    }
}
