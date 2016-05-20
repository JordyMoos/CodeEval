object Main extends App {
  val numberMap = Map(("zero" -> 0), ("one" -> 1), ("two" -> 2), ("three" -> 3), ("four" -> 4), ("five" -> 5), ("six" -> 6), ("seven" -> 7), ("eight" -> 8), ("nine" -> 9))
  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0)
  for (line <- lines) {
    println(line.split(";").map(numberMap).mkString(""))
  }
}
