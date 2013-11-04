
import java.lang.Math;

class P3 {

  public static long largest_prime_factor(long n) {
    long p = 2;
    long ans = n;
    double limit = Math.sqrt(n);

    while (p<=limit) {
      if ((n%p) == 0) {
        long a = largest_prime_factor(n/p);
        ans = (a>p)? a:p;
        break;
      }
      p++;
    }
    return ans;
  }

  public static void main(String[] args) {
    long n = 600851475143L;
    System.out.println(largest_prime_factor(n));
  }

}
