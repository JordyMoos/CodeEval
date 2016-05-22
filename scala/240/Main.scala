object Main extends App {
  val primes = Array(3, 7, 31, 127, 2047)
  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0).map(_.toInt)
  for (line <- lines) {
    println(primes.filter(_ < line).mkString(", "))
  }
}