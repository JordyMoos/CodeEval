object Main extends App {
  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0)
  for (line <- lines) {
    val Array(first, second) = line.split('|').map(_.trim).map(_ split ' ')
    val combined = first zip second
    println(combined.map(data => data._1.toInt * data._2.toInt).mkString(" "))
  }
}
