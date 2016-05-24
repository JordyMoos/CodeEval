object Main extends App {
  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0)
  for (line <- lines) {
    val Array(l1, l2) = line.split(';').map(_.split(',')).map(_.toList)
    println((l1 intersect l2).mkString(","))
  }
}
