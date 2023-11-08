package list.getIntersectionNode;

/**
 * @author clap of thunder
 * @date 2023-11-01 9:56
 * @description
 */
public class appTest {
    public static void main(String[] args) {
        //A 19124
        ListNode headA = new ListNode(2);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(4);
        ListNode headA3B2 = new ListNode(5);
        ListNode headA4B3 = new ListNode(4);
        headA.next=head1;
        head1.next=head2;
        head2.next=headA3B2;
        headA3B2.next=headA4B3;

        ListNode headB = new ListNode(2);
        ListNode headB1 = new ListNode(2);
        ListNode headB2 = head2;
        headB.next = headB1;
        headB1.next = headB2;
        headB2.next=headA3B2;
        headA3B2.next=headA4B3;

        //B 324
//        ListNode headB = new ListNode(3);
//        ListNode headB1 = new ListNode(2);
//        ListNode headB2 = new ListNode(4);
//        headB.next=headA3B2;
//        headB1.next=headB2;
//        System.out.println(getIntersectionNode(headA,headB));
//        ListNode headA = new ListNode(2);
//        ListNode nodeA1 = new ListNode(6);
//        headA.next = nodeA1;
//        ListNode nodeA2 = new ListNode(4);
//        nodeA1.next = nodeA2;
//
//        ListNode headB = new ListNode(1);
//        ListNode nodeB1 = new ListNode(5);
//        headB.next = nodeB1;

//        ListNode headA = new ListNode(1);
//        ListNode headA = new ListNode(3);
//        ListNode headA1 = new ListNode(2);
//        headA.next=headA1;
//        ListNode headB = headA1;

        System.out.println(getIntersectionNode(headA,headB));
        System.out.println(getIntersectionNode(null,null));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        //返回结果
        ListNode resultNode = null;
            //得到链表A的长度
            ListNode curA = headA;
            ListNode curB = headB;
            int sizeA = 0;
            int sizeB = 0;

            while (curA != null) {
                sizeA++;
                curA = curA.next;
            }
            //得到链表B的长度
            while (curB != null) {
                sizeB++;
                curB = curB.next;
            }

            //长度差
            int len = sizeA - sizeB;
            curA = headA;
            curB = headB;

            if (headA == headB || headA==null||headB==null) {
                return headA;
            }  else if (len==0){
                while (curA!= null && curB!= null) {
                    if (curA == curB) {
                        resultNode = curA;
                        return resultNode;
                    }
                    curA = curA.next;
                    curB = curB.next;
                }

                return null;
            }
            else {
                //开始并不相交
                if (len>0) {
                    //A长度大于B

                        //此处需考虑链表长度为0的情况
                        while (len > 0) {
                            len--;
                            curA = curA.next;
                        }
                        //此时AB上指针都指向尾部对齐后的同一节点
                        //从此处往后遍历若有物理节点相同处，则该处为交叉节点
                        while (curA!= null && curB!= null) {
                            if (curA == curB) {
                                resultNode = curA;
                                return resultNode;
                            }
                            curA = curA.next;
                            curB = curB.next;
                        }

                    return null;
                }else {
                    len = sizeB - sizeA;
                    //此处需考虑链表长度为0的情况
                    while (len > 0) {
                        len--;
                        curB = curB.next;
                    }
                    //此时AB上指针都指向尾部对齐后的同一节点
                    //从此处往后遍历若有物理节点相同处，则该处为交叉节点
                    while (curA!= null && curB != null) {
                        if (curA == curB) {
                            return curB;
                        }
                        curA = curA.next;
                        curB = curB.next;
                    }
                    return null;
                }
            }
    }
}
