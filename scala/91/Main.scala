object Main extends App {
  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0)
  for (line <- lines) {
    println(line.split(" ").map(_.toDouble).sorted.map("%1.3f" format _).mkString(" "))
  }
}
