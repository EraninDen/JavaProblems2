package leetcode.top35.LinkedList;


public class LinkedListAddTwoNumbersProblems {
    /*
Вам даны два непустых связанных списка, представляющих два неотрицательных целых числа.
Цифры хранятся в обратном порядке , и каждый из их узлов содержит одну цифру.
Добавьте два числа и верните сумму в виде связанного списка.
Вы можете предположить, что эти два числа не содержат начальных нулей, кроме самого числа 0.
Пример 1:
Ввод: l1 = [2,4,3], l2 = [5,6,4]
 Вывод: [7,0,8]
 Объяснение: 342 + 465 = 807.

Пример 2:
Вход: l1 = [0], l2 = [0]
 Выход: [0]

Пример 3:
Ввод: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 Вывод: [8,9,9,9,0,0,0,1]
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(), result = dummy;
        int sum = 0, carry = 0;

        while (l1 != null || l2 != null) {
            sum = carry;  // Carry needs to be added always. If it's 0, result won't be affected

            // One of the numbers could have lesser digits than the other.
            // Thus, we check for the presence of the digits first and then add them to the sum.
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // After this the sum would be like: sum = carry + l1.val + l2.val, if both l1 and l2 are not null.
            // Now, if sum >= 10, we will have the case of a carry.
            // These are base 10 numbers.
            // Thus, a digit that needs to be added would be: digit = sum % 10 and carry would be carry = carry/10;
            // Consider that sum = 9. In that case, digit is 9 and carry is 0.
            // Consider that sum is 21. In that case, digit is 1 and carry is 2.
            // Thus, our result would be accurate for all cases - whether sum is greater than 10 or not.

            dummy.next = new ListNode(sum % 10); // Adding digit directly
            carry = sum / 10;
            dummy = dummy.next;
        }
        // If carry is remaining when digits of both numbers have exhausted, it is added in front of the number.
        if (carry > 0) {
            dummy.next = new ListNode(carry);
        }
        return result.next;
    }
}
