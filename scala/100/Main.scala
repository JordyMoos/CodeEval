object Main extends App {
  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0)
  lines.map(_.toInt % 2 == 0).map(if (_) "1" else "0").foreach(println _)
}
