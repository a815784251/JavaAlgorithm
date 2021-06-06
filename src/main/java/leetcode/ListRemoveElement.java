package leetcode;

/**
 * 从链表移除某个指定元素
 * @author JingHe
 * @date 2021-06-05 0:47
 */
public class ListRemoveElement {

    public static void main(String[] args) {
        ListRemoveElement.ListNode l1 = new ListRemoveElement.ListNode(2);
        ListRemoveElement.ListNode l2 = new ListRemoveElement.ListNode(4);
        ListRemoveElement.ListNode l3 = new ListRemoveElement.ListNode(3);
        ListRemoveElement.ListNode l4 = new ListRemoveElement.ListNode(5);
        ListRemoveElement.ListNode l5 = new ListRemoveElement.ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode result = removeElements(l1, 3);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode result = null;
        ListNode current = null;
        while (head != null) {
            if (val != head.val) {
                if (result == null) {
                    result = new ListNode(head.val);
                    current = result;
                } else {
                    ListNode nextNode = new ListNode(head.val);
                    current.next = nextNode;
                    current = nextNode;
                }
            }
            head = head.next;
        }
        return result;
    }

    static class ListNode {
        int val;
        ListRemoveElement.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }
}
