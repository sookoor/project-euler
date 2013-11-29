



import java.util.*;

class P25 {

  /**
   * Add digit in d1 and d2 plus carry and set addition result to d1
   *
   * Complexity: O(n) which n is number of digits
   */
  public static void add(ListIterator<Integer> d1, ListIterator<Integer> d2, int carry) {
    int num = carry;
    if (d2.hasNext()) {
      num += d2.next();
    }

    if (d1.hasNext()) {
      num += d1.next();

      d1.set(num%10); // set current digit result
      add(d1, d2, num/10); // add next digit

    } else if (num > 0) {
      d1.add(num % 10); // add new digit
      add(d1, d2, num / 10); // add further digits if num > 0
    }
  }

  public static void main(String[] args) {
    int n = 1000;

    LinkedList<Integer> d1 = new LinkedList<Integer>();
    d1.add(1);
    LinkedList<Integer> d2 = new LinkedList<Integer>();
    d2.add(1);

    // Complexity: O(nd) which d is number for digits and n is the number.
    int ith = 2;
    while (d2.size() < n) {
      // d1 + d2
      add(d1.listIterator(), d2.listIterator(), 0);

      // Swap d1 and d2
      LinkedList<Integer> t = d1;
      d1 = d2;
      d2 = t;

      ith++;
    }

    System.out.println(ith);
  }

}
