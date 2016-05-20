object Main extends App {
  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0)
  for (line <- lines) {
    val Array(message, char) = line.split(',')
    println(message.lastIndexOf(char(0)))
  }
}
