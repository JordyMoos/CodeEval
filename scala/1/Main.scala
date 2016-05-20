object Main extends App {
  final val FIZZ_INDEX = 0
  final val BUZZ_INDEX = 1
  final val MAX_INDEX = 2

  def translateNumber(number: Int, fizz: Int, buzz: Int): String = {
    if (number % fizz == 0 && number % buzz == 0) "FB"
    else if (number % fizz == 0) "F"
    else if (number % buzz == 0) "B"
    else number.toString
  }

  def expandRequest(data: Array[String]): Seq[String] = {
    for (number <- 1 to data(MAX_INDEX).toInt) yield {
      translateNumber(number, data(FIZZ_INDEX).toInt, data(BUZZ_INDEX).toInt)
    }
  }

  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)

  println(
    lines.map(_ split " ")
      .map(expandRequest)
      .map(_.mkString(" "))
      .mkString("\n")
  )
}

