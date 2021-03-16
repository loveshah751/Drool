package practice.temp;

import java.util.LinkedList;
import java.util.Objects;

public class LinkedListProblem {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;

        ListNode head = new ListNode(0);
        ListNode currentHead = head;

        int sum = 0;

        while(current1 != null || current2 != null) {
            sum /= 10;

            if(current1 != null) {
                sum += current1.val;
                current1 = current1.next;
            }

            if(current2 != null) {
                sum += current2.val;
                current2 = current2.next;
            }

            currentHead.next = new ListNode(sum % 10);
            currentHead = currentHead.next;
        }


        if(sum / 10 == 1) {
            currentHead.next = new ListNode(1);
        }

        return head.next;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


  public ListNode addNum(ListNode list1, ListNode list2) {
        //Current Node
        ListNode result = new ListNode(0);
        ListNode resultNext = result;


        int remainder = 0;
        while(Objects.nonNull(list1) || Objects.nonNull(list2)) {

            if(Objects.nonNull(list1)) {
                remainder += list1.val;
                list1 = list1.next;
            }

            if(Objects.nonNull(list2)) {
                remainder += list2.val;
                list2 = list2.next;
            }

            if (remainder < 10 ) {
                resultNext.next = new ListNode(remainder);
                resultNext = resultNext.next;
                remainder = 0;
            }else {
                resultNext.next = new ListNode(remainder % 10);
                resultNext = resultNext.next;
                remainder = 1;
            }

        }

      if(remainder == 1) {
          resultNext.next = new ListNode(1);
      }

        return result.next;
  }

    public static void main(String[] args) {
        LinkedListProblem test = new LinkedListProblem();
        var list1 = new ListNode(9);
        list1.next = new ListNode(9);
        list1.next.next = new ListNode(9);
        list1.next.next.next = new ListNode(9);
        list1.next.next.next.next = new ListNode(9);
        list1.next.next.next.next = new ListNode(9);
        list1.next.next.next.next = new ListNode(9);

        // 2 -> 4 -> 3 -> 6
        // 5 -> 6
        // 7 -> 0 -> 4 -> 6
        var list2 = new ListNode(9);
        list2.next = new ListNode(9);
        list2.next.next = new ListNode(9);
        list2.next.next = new ListNode(9);



        var rest =test.addTwoNumbers(list1,list2);
        var rest1 = test.addNum(list1,list2);
        System.out.println("Result" + rest);

    }

}
