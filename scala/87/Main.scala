object Main extends App {
  val size = 256
  val m = Array.fill[Int](size, size)(0)

  val setRowPat = "SetRow ([0-9]+) ([0-9]+)".r
  val setColPat = "SetCol ([0-9]+) ([0-9]+)".r
  val queryRowPat = "QueryRow ([0-9]+)".r
  val queryColPat = "QueryCol ([0-9]+)".r

  def processLine(line: String): Unit = {
    line match {
      case setRowPat(i, x) => m(i.toInt) = Array.fill[Int](size)(x.toInt)
      case setColPat(j, x) => m.foreach(_(j.toInt) = x.toInt)
      case queryRowPat(i) => println(m(i.toInt).sum)
      case queryColPat(j) => println(m.map(_(j.toInt)).sum)
    }
  }

  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0)
  lines.foreach(processLine)
}