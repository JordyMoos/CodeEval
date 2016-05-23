object Main extends App {
  val pattern = "Vampires: ([0-9]+), Zombies: ([0-9]+), Witches: ([0-9]+), Houses: ([0-9]+)".r
  def candyCount(line: String): Int = {
    line match {
      case pattern(v, z, w, h) => {
        ((v.toInt * h.toInt * 3) + (z.toInt * h.toInt * 4) + (w.toInt * h.toInt * 5)) / (v.toInt + z.toInt + w.toInt)
      }
    }
  }
  val file = scala.io.Source.fromFile(args(0))
  val lines = file.getLines.filter(_.length > 0)
  lines.map(candyCount).foreach(println)
}
