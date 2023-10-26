package list.exchangeNode;

/**
 * @author clap of thunder
 * @date 2023-10-25 17:25
 * @description
 */
public class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        head.next=head1;
        head1.next=head2;
        head2.next=head3;
        head3.next=head4;
        System.out.println(head);
        System.out.println("--------------------");
        System.out.println(swapPairs(head));
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dum = new ListNode(0,head);
        ListNode cur =dum;
        ListNode start =null;
        ListNode end =null;
        ListNode temp3 =null;
            while (cur.next!=null&&cur.next.next!=null){
                //翻转
                start = cur.next;//1
                end = cur.next.next;//dum指向2
                temp3 = cur.next.next.next;//3
                cur.next = start.next;
                start.next = temp3;
                end.next=start;
                //更新cur
                cur = start;
            }
            return dum.next;
    }
}
