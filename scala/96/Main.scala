object Main extends App {
  def swapCase(c: Char): Char = {
    c.toInt match {
       case i: Int if (i >= 97 && i <= 122) => (i - 32).toChar
       case i: Int if (i >= 65 && i <= 90) => (i + 32).toChar
       case _ => c
     }
   }

  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0)
  for (line <- lines) {
    println(line.map(swapCase))
  }
}
