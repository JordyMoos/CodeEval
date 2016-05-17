object Main extends App {
  var file = scala.io.Source.fromFile(args(0))
  var lines = file.getLines().filter(_.length > 0)
  for (line <- lines) {
    val Array(message, postFix) = line.split(",")
    println(if (message.endsWith(postFix)) "1" else "0")
  }
}