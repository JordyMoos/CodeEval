object Main extends App {
  def has(times: Int, number: Char, line: String): Boolean = {
    line.count(_ == number) == times
  }
  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0)
  for (line <- lines) {
    val result = line.map(_.asDigit).zipWithIndex.exists(data => ! has(data._1, data._2.toString.head, line))
    println(if (result) "0" else "1")
  }
}
