object Main extends App {
  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines().filter(_.length > 0)
  for (line <- lines) {
    val numbers = line.split(",").map(_.toInt).sortWith(_ < _)
    val halfLength = numbers.length / 2
    val middle = numbers(halfLength)
    val count = numbers.count(_ == middle)

    println(if (count > halfLength) middle else "None")
  }
}