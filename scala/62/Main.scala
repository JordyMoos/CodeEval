object Main extends App {
  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0)
  for (line <- lines) {
    val Array(n, m) = line.split(",").map(_.toInt)
    val fitsTimes = n / m
    println(n - (m * fitsTimes))
  }
}
