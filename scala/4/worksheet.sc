
def isPrime(n: Int) = {
  ! (2 to math.sqrt(n).toInt).exists(n % _ == 0)
}

Stream.from(2).filter(isPrime).take(1000).sum
