
object Main extends App {

  def createIsEligible(total: Int, numbers: Array[String])(x: Int): Boolean = {
    val remainder = total - x
    if (x * 2 >= total)
      false
    else if (numbers contains remainder.toString)
      true
    else false
  }

  def createExpand(total: Int)(x: Int): String = {
    val remainder = total - x

    x.toString + "," + remainder.toString
  }

  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)

  for (line <- lines) {
    val Array(numbersString, totalString) = line.split(";")

    val total = totalString.toInt
    val numbers = numbersString.split(",")
    val index = numbers.zipWithIndex.toMap

    val isEligible = createIsEligible(total, numbers) _
    val expand = createExpand(total) _

    val newLine = numbers.map(_.toInt)
      .filter(isEligible)
      .map(expand)
      .mkString(";")

    if (newLine.length > 0)
      println(newLine)
    else
      println("NULL")
  }
}
