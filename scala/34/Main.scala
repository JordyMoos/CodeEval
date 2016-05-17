
object Main extends App {

  def createIsEligible(total: Int, numbers: Map[String, Int])(x: Int): Boolean = {
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

    val isEligible = createIsEligible(total, index) _
    val expand = createExpand(total) _

    val pairs = numbers.map(_.toInt)
      .filter(isEligible)
      .map(expand)

    if (pairs.length > 0)
      println(pairs.mkString(";"))
    else
      println("NULL")
  }
}
