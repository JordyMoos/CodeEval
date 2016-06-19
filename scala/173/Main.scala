object Main {
  def main(args: Array[String]) = {
    val file = scala.io.Source.fromFile(args(0))
    val lines = file.getLines.filter(_.length > 0)

    for (line <- lines) {
      println(line.foldLeft("")((acc: String, c: Char) => {
        if ( ! acc.isEmpty && acc.last == c) acc
        else acc + c
      }))
    }
  }
}