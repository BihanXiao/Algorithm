/**
 * Definition for ListNode
 * public class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode(int x) {
 *     val = x;
 *     next = null;
 *    }
 *  }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: head of the new linked List
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode pointer = head;
        while (pointer != null && pointer.next != null) {
            if (pointer.val == pointer.next.val) {
                pointer.next = pointer.next.next;
            } else {
		pointer = pointer.next;
		// This is critical!!! If put this statement
		// out of else clause, then every second duplicates
		// will be skipped.
		// Put it in the else clause, pointer only moves when
		// the next one is not a duplicate.
            }
        }
        return head;
    }
}
