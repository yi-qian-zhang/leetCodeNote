package list;

/**
 * @author clap of thunder
 * @date 2023-10-16 16:12
 * @description
 */
public class ListTest {
    public static void main(String[] args) {
//        ListNode node1 = new ListNode(1);//1,2,6,3,4,5,6
//        ListNode node2 = new ListNode(2);//1,2,6,3,4,5,6
//        ListNode node3 = new ListNode(6);//1,2,6,3,4,5,6
//        ListNode node4 = new ListNode(3);//1,2,6,3,4,5,6
//        ListNode node5 = new ListNode(4);//1,2,6,3,4,5,6
//        ListNode node6 = new ListNode(5);//1,2,6,3,4,5,6
//        ListNode node7 = new ListNode(6);//1,2,6,3,4,5,6
//        node1.next=node2;
//        node2.next=node3;
//        node3.next=node4;
//        node4.next=node5;
//        node5.next=node6;
//        node6.next=node7;
//        System.out.println(removeElements(node1, 6));

        Node demo2node1 = new Node(7);//7,7,7,7
        Node demo2node2 = new Node(7);//7,7,7,7
        Node demo2node3 = new Node(7);//7,7,7,7
        Node demo2node4 = new Node(7);//7,7,7,7
        demo2node1.next = demo2node2;
        demo2node2.next = demo2node3;
        demo2node3.next = demo2node4;
        System.out.println(removeElements(demo2node1, 7));

    }

    public static Node removeElements(Node head, int val) {
        //虚拟头结点
        Node dummyHead = new Node(-1, head);
        Node flag = dummyHead;
        if (dummyHead.next == null) {
            return null;
        }
        while (flag.next != null) {
            if (flag.next.val == val) {
                flag.next = flag.next.next;
            }else {
                flag = flag.next;
            }
        }
        return dummyHead.next;
    }
}
