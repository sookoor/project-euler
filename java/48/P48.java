

import java.util.*;

class P48 {

  /**
   * Multiply each digit with x and plus carry with limit
   *
   * Complexity: O(n) which n is the limit
   */
  public static void multiply(ListIterator<Integer> digit, int x, int carry, int limit) {
    if (limit < 0) return;

    if (digit.hasNext()) {
      int num = digit.next() * x + carry;

      digit.set(num%10); // set current digit result
      multiply(digit, x, num/10, limit-1); // multiply next digit

    } else if (carry > 0 && limit > 0) {
      digit.add(carry % 10); // add new digit
      multiply(digit, x, carry / 10, limit-1); // add further digits if carry > 0
    }
  }

  /**
   * Add each digit with digit2 and plus carry
   *
   * Complexity: O(n) which n is limit
   */
  public static void add(ListIterator<Integer> digit, ListIterator<Integer> digit2, int carry, int limit) {
    if (limit < 0) return;

    int d2 = (digit2.hasNext())? digit2.next():0;
    int num = d2+carry;

    if (digit.hasNext()) {
      num += digit.next();

      digit.set(num%10); // set current digit result
      add(digit, digit2, num/10, limit-1); // add next digit

    } else if (num > 0 && limit > 0) {
      digit.add(num % 10); // add new digit
      add(digit, digit2, num / 10, limit-1); // add further digits if carry > 0
    }
  }

  public static void main(String[] args) {
    int n = 1000;

    LinkedList<Integer> sum = new LinkedList<Integer>();
    sum.add(0);

    // Complexity: O(n^2) which n is the number.
    for (int i = 1; i <= n; i++) {
      LinkedList<Integer> digits = new LinkedList<Integer>();
      digits.add(1);
      for (int j = 0;j<i;j++) {
        multiply(digits.listIterator(), i, 0, 10);
      }

      add(sum.listIterator(), digits.listIterator(), 0, 10);
    }

    Iterator<Integer> itr = sum.descendingIterator();
    while (itr.hasNext()) {
      System.out.print(itr.next());
    }
    System.out.println("");
  }

}
