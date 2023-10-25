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
        System.out.println(swapPairs(head));
        System.out.println(swapPairs(null));
    }

    public static ListNode swapPairs(ListNode head) {
        if (head==null){
            return head;
        }else {
            ListNode pre =head;
            ListNode cur =head.next;
            ListNode dir =cur.next;
            while (cur!=null){
                //翻转
                cur.next=pre;
                pre.next=dir;
                //交换索引
                ListNode temp = pre;
                pre = cur;
                cur = temp;
            }
            return head.next;
        }
    }
}
