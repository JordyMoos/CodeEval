object Main extends App {
  def longestWordSorter(lhs: (Int, Int, String), rhs: (Int, Int, String)): Boolean = {
    if (lhs._1 > rhs._1) true
    else if (lhs._1 < rhs._1) false
    else if (lhs._2 < rhs._2) true
    else false
  }

  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0)
  for (line <- lines) {
    println(line.split(" ").zipWithIndex.map(data => (data._1.length, data._2, data._1)).sortWith(longestWordSorter).head._3)
  }
}
