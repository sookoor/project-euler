
import java.util.LinkedList;

class P7 {

  public static void main(String[] args) {

    LinkedList<Long> primeList = new LinkedList<Long>();
    primeList.add(2L);
    primeList.add(3L);
    primeList.add(5L);
    primeList.add(7L);
    primeList.add(11L);
    primeList.add(13L);

    long nextPrime = 13L;

    // Complexity O(N^2)
    while (primeList.size() <= 10000) {
      nextPrime += 2;
      boolean isPrime = true;
      for (Long l : primeList) {
        if (nextPrime % l == 0) {
          isPrime = false;
          break;
        }
      }

      if (isPrime) {
        primeList.add(nextPrime);
      }
    }

    System.out.println(nextPrime);
  }

}
