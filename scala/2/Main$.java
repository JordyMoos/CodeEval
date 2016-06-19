object Main extends App {
  def paddingCount(row: String): Int = {
    val tillLastX = row.split("X")
    val tillFirstY = tillLastX.last.split("Y")

    if (tillFirstY.isEmpty) 0
    else tillFirstY.head.count(_ == '.')
  }

  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)

  for (matrix <- lines) {
    val row = matrix split ","
    println(row.map(paddingCount).min)
  }
}
