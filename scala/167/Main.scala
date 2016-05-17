object Main extends App {
  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines().filter(_.length > 0)
  for (line <- lines) {
    if (line.length > 55) {
      val chunked = line.substring(0, 40)
      val split = chunked splitAt (chunked lastIndexOf ' ')
      val text = if (split._1.length > 0) split._1 else split._2
      println(text + "... <Read More>")
    }
    else
      println(line)
  }
}