package list.deleteSameVal;

/**
 * @author clap of thunder
 * @date 2023-10-24 14:12
 * @description
 */
public class Node {
    int val;
    Node next;
    Node() {};
    Node(int val) { this.val = val; }
    Node(int val, Node next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "Test{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

}
