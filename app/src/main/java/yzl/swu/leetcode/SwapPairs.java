package yzl.swu.leetcode;
/**
 * 24. 两两交换链表中的节点
 * */
public class SwapPairs {

public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        swapPairs(node1);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode first = head;
        ListNode second = (head!=null?head.next:null);
        int temp;
        while(first != null && second != null){
            temp = first.val;
            first.val = second.val;
            second.val = temp;
            first = second.next;
            second = (first!=null?first.next:null);
        }
        return first;
    }
}
