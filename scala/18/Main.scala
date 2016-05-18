object Main extends App {
  def findLargerValue(n: Int, m: Int, incr: Int): Int = {
    if (n > m)
      findLargerValue(n, m + incr, incr)
    else
      m
  }

  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0)
  for (line <- lines) {
    val Array(n, m) = line.split(",").map(_.toInt)
    println(findLargerValue(n, m, m))
  }
}
