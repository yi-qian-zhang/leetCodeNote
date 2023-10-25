package list.designList;

/**
 * @author clap of thunder
 * @date 2023-10-24 14:00
 * @description
 */
class MyLinkedList {
    int size;
    ListNode dummyhead;
    public MyLinkedList() {
        //初始化自带虚拟头
        this.dummyhead = new ListNode();
        this.size=0;}

    public int get(int index) {
        if(index<0||index>size-1){
            return -1;
        }
        ListNode cur = dummyhead;
        //得到头结点 //获取第n个节点的值 cur.next指向第n个节点 0即头结点
        while (index>0){
            //index=0不走循环，此时cur指向dum
            cur = cur.next;
            index--;
        }
        return cur.next.val;
    }

    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val,dummyhead.next);
        dummyhead.next= newHead;
        size++;
    }

    public void addAtTail(int val) {
        ListNode NewTail = new ListNode(val);
        ListNode cur = dummyhead;
        if (cur.next==null){
            dummyhead.next=NewTail;
        }else {
            while (cur.next!=null){
                cur= cur.next;
            }
            cur.next=NewTail;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index==size){
            addAtTail(val);

        }else if(index==0){
            addAtHead(val);

        }else if(index<size){
            ListNode node = new ListNode(val);
            ListNode cur = dummyhead;
            while (index>0){
                //index=0不走循环，此时cur指向dum
                cur = cur.next;
                index--;
            }
            node.next=cur.next;
            cur.next=node;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        //index合法性！！！
        ListNode cur = dummyhead;
        if (index<size){
            while (index>0){
                //index=0不走循环，cur始终指向index节点的前一个节点，cur.next=index节点
                cur = cur.next;
                index--;
            }
            cur.next=cur.next.next;
            size--;
        }
    }
}
