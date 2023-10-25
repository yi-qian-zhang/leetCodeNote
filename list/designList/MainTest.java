package list.designList;

import list.Node;

/**
 * @author clap of thunder
 * @date 2023-10-24 14:06
 * @description
 */
public class MainTest {
    public static void main(String[] args) {
//        测试用例:["MyLinkedList","addAtHead","get","addAtHead","addAtHead","deleteAtIndex","addAtHead","get","get","get","addAtHead","deleteAtIndex"]
//			[[],[4],[1],[1],[5],[3],[7],[3],[3],[3],[1],[4]]
//        期望结果:[null,null,-1,null,null,null,null,4,4,4,null,null]
//        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addAtHead(4);
//        myLinkedList.get(1);
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtHead(5);
//        myLinkedList.addAtHead(3);
//        myLinkedList.deleteAtIndex(7);
//        myLinkedList.get(3);
//        myLinkedList.get(3);
//        myLinkedList.get(3);
//        myLinkedList.addAtHead(1);
//        myLinkedList.deleteAtIndex(4);

//        ["MyLinkedList","addAtHead","addAtIndex","get","addAtHead","addAtTail","get","addAtTail","get","addAtHead","get","addAtHead"]
//			[[],[5],[1,2],[1],[6],[2],[3],[1],[5],[2],[2],[6]]
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(5);
        myLinkedList.addAtIndex(1,2);
        myLinkedList.get(1);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(2);
        myLinkedList.get(3);
        myLinkedList.addAtTail(1);
        myLinkedList.get(5);
        myLinkedList.addAtHead(2);
        myLinkedList.get(2);
        myLinkedList.addAtHead(6);

        ListNode cur = myLinkedList.dummyhead;
        while (cur.next!=null){
            System.out.print(cur.next.val+" ");
            cur=cur.next;
        }

    }
}
