public class Node <V>{
    public V info;
    public Node<V> next;

    public Node() {
    }
    
    public Node(V info) {
        this.info = info;
    }
    
    public Node (V info, Node next) {
        this.info = info;
        this.next = next;
    }
}
