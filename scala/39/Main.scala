object Main extends App {
  def isHappy(n: Int): Boolean = {
    def next(n: Int): Int = {
      n.toString.map(_.asDigit).map(x => x * x).sum
    }

    n match {
      case 1 => true
      case 4 => false
      case _ => isHappy(next(n))
    }
  }
  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0)
  for (line <- lines) {
    println(if (isHappy(line.toInt)) "1" else "0")
  }
}
