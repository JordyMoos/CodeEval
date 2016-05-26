object Main extends App {
  val pat = "\\((\\-?[0-9]+), (\\-?[0-9]+)\\) \\((\\-?[0-9]+), (\\-?[0-9]+)\\)".r
  def combine(p1: Int, p2: Int): Int = {
    p1 - p2
  }
  def toDistance(line: String): Int = {
    line match {
      case pat(x1, y1, x2, y2) => scala.math.sqrt(combine(x1.toInt, x2.toInt) * combine(x1.toInt, x2.toInt) + combine(y1.toInt, y2.toInt) * combine(y1.toInt, y2.toInt)).toInt
    }
  }
  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0)
  lines.map(toDistance).foreach(println)
}
