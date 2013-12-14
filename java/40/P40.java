

import java.lang.Math;
import java.util.*;

class P40 {

  public static void main(String[] args) {

    int limit = 1000000;

    // Complexity: O(N) where N is the limit
    int ans = 1;

    int nextAnswer = 1;
    int nd = 0; // the nth

    int nextNumber = 1;
    int nextStep = 1;
    int step = 1;
    int x = nextNumber;
    while (nd <= limit) {

      if (step == 0) { // Need next number
        x = ++nextNumber;
        if (nextNumber == nextStep*10) { // Add new digit
          nextStep *= 10;
        }
        step = nextStep;
      }

      // Extract each digit with step
      int d = x/step;
      x = x%step;
      step = step / 10;

      nd++;

      if (nd == nextAnswer) { // If it is an anwser.
        nextAnswer *= 10;
        ans *= d;
      }

    }

    System.out.println(ans);
  }

}
