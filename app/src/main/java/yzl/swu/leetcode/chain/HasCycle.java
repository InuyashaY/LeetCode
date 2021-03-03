package yzl.swu.leetcode.chain;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

public class HasCycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (set.contains(head)) return false;
            set.add(head);
            head = head.next;
        }
        return true;
    }


    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while (quick.next != null && slow.next != null){
            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick) return true;
        }

        return false;
    }

    public boolean hasCycle3(ListNode head) {
        ListNode newHead = reverseList(head);
        if (head!=null && head.next != null &&head == newHead) return true;
        return false;
    }


    public ListNode reverseList(ListNode head){
        ListNode newHead = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }

        return newHead;
    }
}
