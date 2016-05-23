
def isPalindrome(n: Int): Boolean = {
  n.toString == n.toString.reverse
}

def isPrime(n: Int): Boolean = {
  ! (2 to n / 2).exists(n % _ == 0)
}

(1000 to 2 by -1).toIterator
  .filter(isPalindrome)
  .filter(isPrime)
  .take(1)
  .foreach(println)

