object Main extends App {
  def isLetter(c: Char) = {
    c.toInt >= 97 && c.toInt <= 122
  }

  case class Acc(total: Int = 0, next: Int = 26)

  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0)
  for (line <- lines) {
    val result = line.toLowerCase
      .filter(isLetter)
      .groupBy(x => x)
      .map(data => data._2.length)
      .toList
      .sortBy(count => -count)
      .foldLeft(Acc())((acc, count) => {
        Acc(acc.total + count * acc.next, acc.next - 1)
      })
      .total
    println(result)
  }
}