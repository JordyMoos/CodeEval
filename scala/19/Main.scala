object Main extends App {
  def isBitPositionOn(b: String, position: Int): Boolean = {
    b(b.length - position) match {
      case '0' => false
      case '1' => true
    }
  }
  
  def isBitStatusEqual(n: Int, p1: Int, p2: Int): Boolean = {
    isBitPositionOn(n.toBinaryString, p1) == isBitPositionOn(n.toBinaryString, p2)
  }

  def processLine(line: String): Boolean = {
    val Array(n, p1, p2) = line.split(",").map(_.toInt)
    isBitStatusEqual(n, p1, p2)
  }

  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0)
  lines.map(processLine).map(_.toString).foreach(println)
}
