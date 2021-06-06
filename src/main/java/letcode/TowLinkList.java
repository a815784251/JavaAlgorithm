package letcode;

/**
 * 双链表实现加法 链表顺序代表个位，十位，依次类推
 * @author Administrator
 * @date 2021-05-28 0:26
 */
public class TowLinkList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(6);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode result = addTwoNumbers(l1, n1);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        int fix = 0;
        ListNode current = result;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }
            current.val = l1.val + l2.val + fix;
            fix = current.val / 10;
            current.val = current.val % 10;
            current.next = new ListNode();
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode temp = result;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        if (fix == 1) {
            temp.next.val = fix;
        } else {
            temp.next = null;
        }
        return result;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }
}
