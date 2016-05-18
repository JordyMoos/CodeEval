object Main extends App {
  def findExponent(x: Double, exponent: Int = 0): Int = {
    if (x > 1.0)
      findExponent(x * 0.5, exponent + 1)
    else
      exponent
  }

  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0)
  for (line <- lines) {
    val Array(n, m) = line.split(",")
    println(scala.math.pow(2, findExponent(n.toDouble)).toInt)
  }
}
