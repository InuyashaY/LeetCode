package yzl.swu.leetcode;

public class reverseNum {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public static void main(String[] args) {
//        System.out.printf(""+(-100)%3);
//        int a = 342;
//        String c = String.valueOf(a);
//        c.charAt(1);
//        char b;
//        b='a';
//        char[] ssss = new char[5];
//        String []ss = new String[10];
//        System.out.printf(""+ss.length);
            System.out.printf("" + valueChar("([])}{"));
        }


        //有效括号
        public static boolean valueChar(String s) {
            if (s.equals("")) return true;
            if (s.length() == 1) return false;
            char[] stack = new char[s.length()];
            int stackTop = -1;
            for (int i = 0; i < s.length(); i++) {
                stackTop++;
                stack[stackTop] = s.charAt(i);
                if (stackTop > 0) {
                    char expect = 'd';
                    switch (stack[stackTop]) {
                        case ')':
                            expect = '(';
                            break;
                        case '}':
                            expect = '{';
                            break;
                        case ']':
                            expect = '[';
                            break;

                        default:
                            break;

                    }
                    if (expect == stack[stackTop - 1]) {
                        stackTop -= 2;
                    }
                }
            }
            return stackTop == -1 ? true : false;
        }
        //合并有序链表
        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }

            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }


        
    }
}
