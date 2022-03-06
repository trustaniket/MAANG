package recursions;

import java.util.List;

public class ReverseLinkedList {

 static class ListNode {
  int val;
  ListNode next;

  public ListNode() {
  }

  public ListNode(int val) {
   this.val = val;
  }

  public ListNode(int val, ListNode next) {
   this.val = val;
   this.next = next;
  }
 }

 public ListNode reverseList(ListNode head){

  if (head == null || head.next == null) return head;
  ListNode p = reverseList(head.next);
  head.next.next = head;
  head.next = null;
  return p;
 }

 public static void main(String[] args) {
  ListNode head = new ListNode(1);
  head.next = new ListNode(2);
  head.next.next = new ListNode(3);
  head.next.next.next = new ListNode(4);

  ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
  reverseLinkedList.reverseList(head);
  System.out.println(head);
 }
}
