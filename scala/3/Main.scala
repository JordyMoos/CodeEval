object Main extends App {
  def isPalindrome(n: Int) = {
    n.toString == n.toString.reverse
  }

  def isPrime(n: Int) = {
    ! (2 to math.sqrt(n).toInt).exists(n % _ == 0)
  }

  (1000 to 2 by -1).toIterator
    .filter(isPalindrome)
    .filter(isPrime)
    .take(1)
    .foreach(println)
}