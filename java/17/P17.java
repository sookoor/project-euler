

class P17 {

  /**
   * Number of letters of number in words
   * Supports only n in [1,1000]
   *
   * Complexity: O(1)
   */
  public static int letter(int n) {
    switch(n) {
      case 1: return "one".length();
      case 2: return "two".length();
      case 3: return "three".length();
      case 4: return "four".length();
      case 5: return "five".length();
      case 6: return "six".length();
      case 7: return "seven".length();
      case 8: return "eight".length();
      case 9: return "nine".length();
      case 10: return "ten".length();
      case 11: return "eleven".length();
      case 12: return "twelve".length();
      case 13: return "thirteen".length();
      case 14: return "fourteen".length();
      case 15: return "fifteen".length();
      case 16: return "sixteen".length();
      case 17: return "seventeen".length();
      case 18: return "eighteen".length();
      case 19: return "nineteen".length();
      case 20: return "twenty".length();
      case 30: return "thirty".length();
      case 40: return "forty".length();
      case 50: return "fifty".length();
      case 60: return "sixty".length();
      case 70: return "seventy".length();
      case 80: return "eighty".length();
      case 90: return "ninety".length();
      case 100: return "onehundred".length();
      case 200: return "twohundred".length();
      case 300: return "threehundred".length();
      case 400: return "fourhundred".length();
      case 500: return "fivehundred".length();
      case 600: return "sixhundred".length();
      case 700: return "sevenhundred".length();
      case 800: return "eighthundred".length();
      case 900: return "ninehundred".length();
      case 1000: return "onethousand".length();
      default: {
        if (n < 100) {
          return letter(n-n%10) + letter(n%10);
        } else {
          int d = n%100;
          if (d > 0)
            return letter(n-d) + letter(d) + "and".length();
          else
            return letter(n-d) + letter(d);
        }
      }
    }
  }

  public static void main(String[] args) {
    int sum = 0;

    // Complexity: O(n) which n is number
    for (int i = 1; i <= 1000; i++) {
      sum += letter(i);
    }

    System.out.println(sum);
  }

}
