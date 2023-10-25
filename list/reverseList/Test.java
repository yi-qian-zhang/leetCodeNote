package list.reverseList;

/**
 * @author clap of thunder
 * @date 2023-10-25 10:03
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
        System.out.println(reverseList(head));
        System.out.println(reverseList(null));

    }
    public static ListNode reverseList(ListNode head) {
        //双指针解法pre,cur
        if (head==null){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur!=null){
            temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
//        return recurve( null, head);
    }

    public static ListNode recurve(ListNode pre,ListNode cur) {
        //边缘条件
        if (cur==null){
            return pre;
        }
        ListNode temp = null;

        temp = cur.next;
        //反转 cur的next指针主动改方向指向pre
        cur.next = pre ;

        return recurve(cur,temp);
    }
}
