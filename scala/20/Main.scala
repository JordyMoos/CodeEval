object Main extends App {
  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0)
  lines.map(_.toLowerCase).foreach(println _)
}
