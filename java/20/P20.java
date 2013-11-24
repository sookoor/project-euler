


import java.util.LinkedList;
import java.util.ListIterator;

class P20 {

  /**
   * Multiply each digit with x and plus carry
   *
   * Complexity: O(n) which n is number of digits
   */
  public static void multiply(ListIterator<Integer> digit, int x, int carry) {
    if (digit.hasNext()) {
      int num = digit.next() * x + carry;

      digit.set(num%10); // set current digit result
      multiply(digit, x, num/10); // multiply next digit

    } else if (carry > 0) {
      digit.add(carry % 10); // add new digit
      multiply(digit, x, carry / 10); // add further digits if carry > 0
    }
  }

  public static void main(String[] args) {
    int n = 100;

    LinkedList<Integer> digits = new LinkedList<Integer>();
    digits.add(1);

    // Complexity: O(nd) which d is number for digits and n is the number.
    for (int i = 1; i <= n; i++) {
      multiply(digits.listIterator(), i, 0);
    }

    int sum = 0;
    for (Integer x : digits) {
      sum += x;
    }
    System.out.println(sum);
  }

}
